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

package org.medicinefreedom.member.core.data.dataobject;

import org.medicinefreedom.member.core.enums.*;

import java.util.Date;
import java.util.Set;

/**
 * 通用说明：患者基本信息，对应数据库表<tt>t_patient</tt>.
 *
 * @author <a href="mailto:shucunbin@163.com">shucunbin</a>
 * @version 1.0.0  2016/12/28 9:12
 */
public class PatientBasicInfoDO {

    // 唯一标识
    private String id;

    // 姓名
    private String name;

    // 出生日期
    private Date birthday;

    // 性别
    private Gender gender;

    // 监护人
    private String guardian;

    //-------------------------------------------------------------------------
    // 以下为病人联系方式
    //-------------------------------------------------------------------------

    // 移动电话
    private String mobilephone;

    // 固定电话
    private String telephone;

    // 电子邮件
    private String email;

    // QQ
    private String qq;

    // 微信
    private String wechat;

    // 家庭地址
    private String residencePlace;


    //-------------------------------------------------------------------------
    // 以下为病人健康状况字段
    //-------------------------------------------------------------------------
    // 过敏药物
    private Set<String> allergicDrugs;

    // 过敏食物
    private Set<String> allergenicFoods;

    // 其它过敏源
    private Set<String> otherAllergens;

    // 是否有心脏病
    private HeartStatus heartStatus;

    // 心脏病备注信息
    private String heartDiseaseRemark;

    // 是否有高血压症
    private BloodPressureStatus bloodPressureStatus;

    // 当前血压值
    private int currentBloodPressure;

    // 是否有糖尿病
    private BloodGlucoseStatus bloodGlucoseStatus;

    // 当前血糖值
    private int currentbloodGlucoseLevel;

    // 是否有其它疾病
    private HealthStatus healthStatus;

    // 其它疾病备注信息
    private String otherDiseaseRemark;

    // 是否有吸烟史
    private SmokingHistory smokingHistory;

    // 是否有饮酒史
    private DrinkingHistory drinkingHistory;

    // 口腔麻醉反应
    private AnaesthesiaAdverseReactions anaesthesiaAdverseReactions;

    // 是否怀孕
    private PregnancyStatus pregnancyStatus;
}