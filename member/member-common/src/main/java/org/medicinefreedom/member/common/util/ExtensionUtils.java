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

package org.medicinefreedom.member.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用说明：扩展字段工具类.
 *
 * @author <a href="mailto:shucunbin@163.com">shucunbin</a>
 * @version 1.0.0  2017/1/11 16:31
 */
public class ExtensionUtils {
    /**
     * 将键值对添加到扩展字段中.
     *
     * @param targetExtension 目标扩展字段
     * @param key 键名
     * @param value 值
     * @return 添加后的扩展字段字符串
     */
    public static String appendToExtension(String targetExtension, String key, String value) {
        if (StringUtils.isEmpty(key)) {
            return targetExtension;
        }

        if (StringUtils.isEmpty(targetExtension)) {
            Map<String, String> extMap = new HashMap<>();
            extMap.put(key, value);
            return JSON.toJSONString(extMap);
        } else {
            try {
                Map<String, String> extMap = JSON.parseObject(targetExtension, new TypeReference<Map<String, String>>() {});
                extMap.put(key, value);
                return JSON.toJSONString(extMap);
            } catch (JSONException exception) {
                // 如果原扩展字段为非JSON格式，则直接返回
                return targetExtension;
            }
        }
    }

    /**
     * 从扩展字段中获取指定的键对应的值.
     *
     * @param targetExtension 目标扩展字段
     * @param key 键名
     * @return 指定的键对应的值
     */
    public static String getFromExtenstion(String targetExtension, String key) {
        if (StringUtils.isEmpty(targetExtension) || StringUtils.isEmpty(key)) {
            return StringUtils.EMPTY;
        }

        try {
            Map<String,String> extMap = JSON.parseObject(targetExtension,new TypeReference<Map<String, String>>(){});
            return extMap.get(key);
        } catch (JSONException exception) {
            return StringUtils.EMPTY;
        }
    }
}
