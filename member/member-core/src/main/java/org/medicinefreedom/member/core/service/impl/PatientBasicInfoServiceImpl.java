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

package org.medicinefreedom.member.core.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.medicinefreedom.member.common.constant.MemberConstant;
import org.medicinefreedom.member.common.sequence.SequenceGenerator;
import org.medicinefreedom.member.core.data.dataobject.PatientBasicInfoDO;
import org.medicinefreedom.member.core.data.mapper.PatientBasicInfoMapper;
import org.medicinefreedom.member.core.vo.PatientBasicInfoVO;
import org.medicinefreedom.member.core.service.PatientBasicInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 通用说明：患者基本信息服务实现类.
 *
 * @author <a href="mailto:shucunbin@163.com">shucunbin</a>
 * @version 1.0.0  2017/1/10 15:31
 */
@Service(value = "patientBasicInfoService")
public class PatientBasicInfoServiceImpl implements PatientBasicInfoService {
    private static final Logger logger = LoggerFactory.getLogger(PatientBasicInfoServiceImpl.class);

    @Resource(name = "beanMapper")
    private Mapper mapper;

    @Resource(name = "sequenceGenerator")
    private SequenceGenerator sequenceGenerator;

    @Resource(name = "patientBasicInfoMapper")
    private PatientBasicInfoMapper patientBasicInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String savePatientBasicInfo(PatientBasicInfoVO patientBasicInfoVO) {
        logger.info("[facade->service]保存患者基本信息开始，请求参数：{}", patientBasicInfoVO);
        if (patientBasicInfoVO == null) {
            return StringUtils.EMPTY;
        }

        String patientId = String.valueOf(sequenceGenerator.nextSequence(MemberConstant.SEQ_NAME_PATIENT_ID));
        patientBasicInfoVO.setPatientId(patientId);
        PatientBasicInfoDO patientBasicInfoDO = mapper.map(patientBasicInfoVO, PatientBasicInfoDO.class);
        patientBasicInfoMapper.insertPatientBasicInfo(patientBasicInfoDO);
        logger.info("[service->facade]保存患者基本信息结束，已保存的患者标识为：{}",patientId);
        return patientId;
    }
}
