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

package org.medicinefreedom.member.service.common.sequence.dao;

import org.medicinefreedom.member.service.common.sequence.domain.Sequence;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 通用说明：Sequence 数据访问接口实现类.
 *
 * @author <a href="mailto:shucunbin@163.com">shucunbin</a>
 * @version 1.0.0  2017/1/9 14:38
 */
public class SequenceDAOImpl extends JdbcDaoSupport implements SequenceDAO {
    private static final String SQL_LIST_ALL_SEQ = "SELECT SEQ_NAME,CURRENT_VALUE,INCREMENT,CAPACITY,THRESHOLD FROM T_SEQUENCE";
    private static final String SQL_LOCK_SEQ = "SELECT * FROM T_SEQUENCE WHERE SEQ_NAME = ? FOR UPDATE";
    private static final String SQL_UPDATE_SEQ = "UPDATE T_SEQUENCE SET CURRENT_VALUE = ? WHERE SEQ_NAME = ? AND CURRENT_VALUE = ?";

    @Override
    public List<Sequence> listAll() {
        return getJdbcTemplate().query(SQL_LIST_ALL_SEQ, new SequenceMapper());
    }

    @Override
    public Sequence lock(String sequenceName) {
        return getJdbcTemplate().queryForObject(SQL_LOCK_SEQ, new Object[]{sequenceName}, new SequenceMapper());
    }

    @Override
    public void update(String sequenceName, long oldCurrentValue, long newCurrentValue) {
        getJdbcTemplate().update(SQL_UPDATE_SEQ, newCurrentValue, sequenceName, oldCurrentValue);
    }

    private static final class SequenceMapper implements RowMapper<Sequence> {
        @Override
        public Sequence mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sequence sequence = new Sequence();
            sequence.setName(rs.getString("seq_name"));
            sequence.setCurrentValue(rs.getLong("current_value"));
            sequence.setIncrement(rs.getInt("increment"));
            sequence.setCapacity(rs.getInt("capacity"));
            sequence.setThreshold(rs.getInt("threshold"));

            return sequence;
        }
    }
}
