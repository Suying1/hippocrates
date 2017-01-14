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

package org.medicinefreedom.member.service.impl;

import org.apache.commons.lang3.time.StopWatch;
import org.dozer.Mapper;
import org.medicinefreedom.member.service.base.common.OperationEnvironment;
import org.medicinefreedom.member.core.service.PatientBasicInfoService;
import org.medicinefreedom.member.core.vo.PatientBasicInfoVO;
import org.medicinefreedom.member.service.facade.PatientInfoFacade;
import org.medicinefreedom.member.service.validator.RequestValidator;
import org.medicinefreedom.member.service.request.PatientBasicInfoRequest;
import org.medicinefreedom.member.service.response.CreatePatientInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.jws.WebService;

/**
 * 通用说明：患者信息服务实现类.
 *
 * @author <a href="mailto:shucunbin@163.com">shucunbin</a>
 * @version 1.0.0  2017/1/11 11:03
 */
@WebService(endpointInterface = "org.medicinefreedom.member.service.facade.PatientInfoFacade")
public class DefaultPatientInfoFacade implements PatientInfoFacade {
    private static final Logger logger = LoggerFactory.getLogger(DefaultPatientInfoFacade.class);
    @Resource(name = "patientBasicInfoRequestValidator")
    private RequestValidator<PatientBasicInfoRequest> patientBasicInfoRequestValidator;

    @Resource(name = "patientBasicInfoService")
    private PatientBasicInfoService patientBasicInfoService;

    @Resource(name = "beanMapper")
    private Mapper mapper;

    @Override
    public CreatePatientInfoResponse createPatientBasicInfo(PatientBasicInfoRequest request, OperationEnvironment environment) {
        logger.info("[app->member]创建患者基本信息请求开始，请求参数：{}，环境信息：{}", request, environment);

        CreatePatientInfoResponse response = null;

        StopWatch stopWatch = StopWatch.createStarted();
        try {
            // 1. 参数校验
            patientBasicInfoRequestValidator.validate(request);

            // 2. 转换为内部实体对象
            PatientBasicInfoVO patientBasicInfoVO = mapper.map(request.getPatientBasicInfo(),PatientBasicInfoVO.class);

            // 3. 调用相关服务进行处理
            String patientId = patientBasicInfoService.savePatientBasicInfo(patientBasicInfoVO);
            response = new CreatePatientInfoResponse();
            response.setSuccess(true);
            response.setResponseCode("000");
            response.setResponseMessage("创建患者基本信息成功");
            response.setPatientId(patientId);
        } catch (Exception ex) {
            logger.error("创建患者基本信息请求发生未知异常！",ex);
            response = new CreatePatientInfoResponse();
            response.setSuccess(true);
            response.setResponseCode("001");
            response.setResponseMessage("创建患者基本信息失败");
        } finally {
            stopWatch.stop();
            logger.info("[member->app]创建患者基本信息请求结束，响应内容：{}，耗时：{}ms",response,stopWatch.getSplitTime());
        }

        return response;
    }
}
