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

package org.medicinefreedom.member.facade.impl;

import org.medicinefreedom.member.core.service.PatientBasicInfoService;
import org.medicinefreedom.member.facade.PatientInfoFacade;
import org.medicinefreedom.member.facade.validator.RequestValidator;
import org.medicinefreedom.member.request.PatientBasicInfoRequest;
import org.medicinefreedom.member.response.CreatePatientInfoResponse;

import javax.annotation.Resource;
import javax.jws.WebService;

/**
 * 通用说明：患者信息服务实现类.
 *
 * @author <a href="mailto:shucunbin@163.com">shucunbin</a>
 * @version 1.0.0  2017/1/11 11:03
 */
@WebService(endpointInterface = "org.medicinefreedom.member.facade.PatientInfoFacade")
public class DefaultPatientInfoFacade implements PatientInfoFacade {
    @Resource(name = "patientBasicInfoRequestValidator")
    private RequestValidator<PatientBasicInfoRequest> patientBasicInfoRequestValidator;

    @Resource(name = "patientBasicInfoService")
    private PatientBasicInfoService patientBasicInfoService;

    @Override
    public CreatePatientInfoResponse createPatientBasicInfo(PatientBasicInfoRequest request) {
        // 1. 参数校验
        // 2. 转换为内部实体对象
        // 3. 调用相关服务进行处理
        return null;
    }
}
