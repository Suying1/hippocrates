/*
 * MIT License
 *
 * Copyright (c) 2016 Medicine Freedom Organization.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.medicinefreedom.member.common.sequence;

import org.apache.commons.collections4.MapUtils;
import org.medicinefreedom.member.common.sequence.domain.Sequence;
import org.medicinefreedom.member.common.sequence.exception.SequenceUpdateException;
import org.medicinefreedom.member.common.sequence.dao.SequenceDAO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通用说明：基于 Table 策略的唯一标识生成器默认实现.
 *
 * @author <a href="mailto:shucunbin@163.com">shucunbin</a>
 * @version 1.0.0  2017/1/9 11:06
 */
public class DefaultSequenceGenerator implements SequenceGenerator, InitializingBean {
    private SequenceDAO sequenceDAO;

    private TransactionTemplate transactionTemplate;

    // 序列缓存
    private ConcurrentHashMap<String, ConcurrentLinkedQueue<Long>> sequenceBuffer = new ConcurrentHashMap<>();

    // 计数器（记录已使用序列个数）
    private ConcurrentHashMap<String, AtomicInteger> countSequenceInUse = new ConcurrentHashMap<>();

    // 计数器锁（每个序列分配一把锁）
    private ConcurrentHashMap<String, ReentrantLock> sequenceLocks = new ConcurrentHashMap<String, ReentrantLock>();

    // 记录各个序列的最大容量
    private Map<String, Integer> sequenceCapacityMap = new HashMap<>();

    // 记录各个序列的阈值
    private Map<String, Integer> sequenceThresholdMap = new HashMap<>();

    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public Long nextSequence(final String sequenceName) {
        Long sequence = sequenceBuffer.get(sequenceName).poll();
        if (sequence != null) {
            countSequenceInUse.get(sequenceName).incrementAndGet();
            checkCapacity(sequenceName);
            return sequence;
        }

        // 缓存里的序列队列已为空，刷新缓存并获取
        try {
            asyncFlushSequenceBuffer(sequenceName);
            return nextSequence(sequenceName);
        } catch (Exception ex) {
            return nextSequence(sequenceName);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (MapUtils.isEmpty(sequenceBuffer)) {
            List<Sequence> sequenceList = sequenceDAO.listAll();
            for (Sequence sequence : sequenceList) {
                sequenceCapacityMap.put(sequence.getName(), sequence.getCapacity());
                sequenceThresholdMap.put(sequence.getName(), sequence.getThreshold());
                sequenceLocks.put(sequence.getName(), new ReentrantLock());

                flushSequenceBuffer(sequence.getName());
            }
        }
    }

    private void flushSequenceBuffer(final String sequenceName) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                Sequence sequence = sequenceDAO.lock(sequenceName);

                int offset = sequence.getIncrement() * sequence.getCapacity();
                long oldCurrentValue = sequence.getCurrentValue();
                long newCurrentValue = oldCurrentValue + offset;

                try {
                    sequenceDAO.update(sequenceName, oldCurrentValue, newCurrentValue);
                } catch (Exception ex) {
                    throw new SequenceUpdateException(ex);
                }

                sequenceBuffer.put(sequenceName, new ConcurrentLinkedQueue<>());
                for (long seqValue = oldCurrentValue; seqValue < newCurrentValue; seqValue += sequence.getIncrement()) {
                    sequenceBuffer.get(sequenceName).add(seqValue);
                }

                countSequenceInUse.put(sequenceName, new AtomicInteger(0));
            }
        });
    }

    private void checkCapacity(final String sequenceName) {
        int threshold = sequenceThresholdMap.get(sequenceName);
        int capacity = sequenceCapacityMap.get(sequenceName);

        if (capacity - countSequenceInUse.get(sequenceName).intValue() < threshold) {
            // 为了不影响本次序列的获取速度，异步刷新序列缓存
            asyncFlushSequenceBuffer(sequenceName);
        }
    }

    private void asyncFlushSequenceBuffer(String sequenceName) {
        try {
            threadPoolTaskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    if (sequenceLocks.get(sequenceName).tryLock()) {
                        try {
                            flushSequenceBuffer(sequenceName);
                        } catch (SequenceUpdateException e) {
                            //  更新异常则异步线程更新
                            asyncFlushSequenceBuffer(sequenceName);
                        } finally {
                            sequenceLocks.get(sequenceName).unlock();
                        }
                    }
                }
            });
        } catch (TaskRejectedException ignore) {
            // 不做处理
        }
    }

    public void setSequenceDAO(SequenceDAO sequenceDAO) {
        this.sequenceDAO = sequenceDAO;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }
}
