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

package org.medicinefreedom.member.core.data.typehandler;

import com.alibaba.fastjson.*;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 * 通用说明：集合类<tt>java.util.Set</tt>转换类.
 *
 * @author <a href="mailto:shucunbin@163.com">matrix</a>
 * @version 1.0.0  2017/1/4 21:01
 */
@MappedTypes(java.util.Set.class)
@MappedJdbcTypes(value = JdbcType.VARCHAR,includeNullJdbcType = true)
public class SetTypeHandler extends BaseTypeHandler<Set<String>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Set<String> stringSet, JdbcType jdbcType) throws SQLException {
        String commaSeparatedString  = serialize2JsonString(stringSet);
        ps.setString(i,commaSeparatedString);
    }

    @Override
    public Set<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String commaSeparatedString = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return deserializeFromJsonString(commaSeparatedString);
        }
    }

    @Override
    public Set<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String commaSeparatedString = rs.getString(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return deserializeFromJsonString(commaSeparatedString);
        }
    }

    @Override
    public Set<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String commaSeparatedString = cs.getString(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return deserializeFromJsonString(commaSeparatedString);
        }
    }

    private String serialize2JsonString(Set<String> stringSet) {
        if (CollectionUtils.isEmpty(stringSet)) {
            return StringUtils.EMPTY;
        }
        return JSON.toJSONString(stringSet);
    }

    private Set<String> deserializeFromJsonString(String jsonString) {
        return JSON.parseObject(jsonString, new TypeReference<Set<String>>(){});
    }
}
