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

package org.medicinefreedom.member.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * 通用说明：通用请求对象.
 *
 * @author <a href="mailto:shucunbin@163.com">shucunbin</a>
 * @version 1.0.0  2017/1/11 10:46
 */
public class BaseRequest implements Serializable{
    private static final long serialVersionUID = -2853960317441850806L;

    // 扩展信息（JSON）格式
    private String extenstion;

    public String getExtenstion() {
        return extenstion;
    }

    public void setExtenstion(String extenstion) {
        this.extenstion = extenstion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("extenstion", extenstion)
                .toString();
    }
}
