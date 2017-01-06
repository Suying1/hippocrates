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
public class PatientBasicInfoDO extends BaseDO {
    private static final long serialVersionUID = 1538852436138626799L;

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
    private Boolean hasHeartDisease;

    // 心脏病备注信息
    private String heartDiseaseRemark;

    // 血压状况
    private BloodPressureStatus bloodPressureStatus;

    // 当前血压值
    private int currentBloodPressure;

    // 血糖状况
    private BloodGlucoseStatus bloodGlucoseStatus;

    // 当前血糖值
    private int currentBloodGlucose;

    // 是否有其它疾病
    private Boolean hasOtherDisease;

    // 其它疾病备注信息
    private String otherDiseaseRemark;

    // 是否有吸烟史
    private Boolean hasSmokingHistory;

    // 是否有饮酒史
    private Boolean hasDrinkingHistory;

    // 口腔麻醉反应
    private AnaesthesiaAdverseReactions anaesthesiaAdverseReactions;

    // 是否怀孕
    private Boolean isPregnant;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getResidencePlace() {
        return residencePlace;
    }

    public void setResidencePlace(String residencePlace) {
        this.residencePlace = residencePlace;
    }

    public Set<String> getAllergicDrugs() {
        return allergicDrugs;
    }

    public void setAllergicDrugs(Set<String> allergicDrugs) {
        this.allergicDrugs = allergicDrugs;
    }

    public Set<String> getAllergenicFoods() {
        return allergenicFoods;
    }

    public void setAllergenicFoods(Set<String> allergenicFoods) {
        this.allergenicFoods = allergenicFoods;
    }

    public Set<String> getOtherAllergens() {
        return otherAllergens;
    }

    public void setOtherAllergens(Set<String> otherAllergens) {
        this.otherAllergens = otherAllergens;
    }

    public Boolean getHasHeartDisease() {
        return hasHeartDisease;
    }

    public void setHasHeartDisease(Boolean hasHeartDisease) {
        this.hasHeartDisease = hasHeartDisease;
    }

    public String getHeartDiseaseRemark() {
        return heartDiseaseRemark;
    }

    public void setHeartDiseaseRemark(String heartDiseaseRemark) {
        this.heartDiseaseRemark = heartDiseaseRemark;
    }

    public BloodPressureStatus getBloodPressureStatus() {
        return bloodPressureStatus;
    }

    public void setBloodPressureStatus(BloodPressureStatus bloodPressureStatus) {
        this.bloodPressureStatus = bloodPressureStatus;
    }

    public int getCurrentBloodPressure() {
        return currentBloodPressure;
    }

    public void setCurrentBloodPressure(int currentBloodPressure) {
        this.currentBloodPressure = currentBloodPressure;
    }

    public BloodGlucoseStatus getBloodGlucoseStatus() {
        return bloodGlucoseStatus;
    }

    public void setBloodGlucoseStatus(BloodGlucoseStatus bloodGlucoseStatus) {
        this.bloodGlucoseStatus = bloodGlucoseStatus;
    }

    public int getCurrentBloodGlucose() {
        return currentBloodGlucose;
    }

    public void setCurrentBloodGlucose(int currentBloodGlucose) {
        this.currentBloodGlucose = currentBloodGlucose;
    }

    public Boolean getHasOtherDisease() {
        return hasOtherDisease;
    }

    public void setHasOtherDisease(Boolean hasOtherDisease) {
        this.hasOtherDisease = hasOtherDisease;
    }

    public String getOtherDiseaseRemark() {
        return otherDiseaseRemark;
    }

    public void setOtherDiseaseRemark(String otherDiseaseRemark) {
        this.otherDiseaseRemark = otherDiseaseRemark;
    }

    public Boolean getHasSmokingHistory() {
        return hasSmokingHistory;
    }

    public void setHasSmokingHistory(Boolean hasSmokingHistory) {
        this.hasSmokingHistory = hasSmokingHistory;
    }

    public Boolean getHasDrinkingHistory() {
        return hasDrinkingHistory;
    }

    public void setHasDrinkingHistory(Boolean hasDrinkingHistory) {
        this.hasDrinkingHistory = hasDrinkingHistory;
    }

    public AnaesthesiaAdverseReactions getAnaesthesiaAdverseReactions() {
        return anaesthesiaAdverseReactions;
    }

    public void setAnaesthesiaAdverseReactions(AnaesthesiaAdverseReactions anaesthesiaAdverseReactions) {
        this.anaesthesiaAdverseReactions = anaesthesiaAdverseReactions;
    }

    public Boolean getIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(Boolean isPregnant) {
        this.isPregnant = isPregnant;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("birthday", birthday)
                .append("gender", gender)
                .append("guardian", guardian)
                .append("mobilephone", mobilephone)
                .append("telephone", telephone)
                .append("email", email)
                .append("qq", qq)
                .append("wechat", wechat)
                .append("residencePlace", residencePlace)
                .append("allergicDrugs", allergicDrugs)
                .append("allergenicFoods", allergenicFoods)
                .append("otherAllergens", otherAllergens)
                .append("hasHeartDisease", hasHeartDisease)
                .append("heartDiseaseRemark", heartDiseaseRemark)
                .append("bloodPressureStatus", bloodPressureStatus)
                .append("currentBloodPressure", currentBloodPressure)
                .append("bloodGlucoseStatus", bloodGlucoseStatus)
                .append("currentBloodGlucose", currentBloodGlucose)
                .append("hasOtherDisease", hasOtherDisease)
                .append("otherDiseaseRemark", otherDiseaseRemark)
                .append("hasSmokingHistory", hasSmokingHistory)
                .append("hasDrinkingHistory", hasDrinkingHistory)
                .append("anaesthesiaAdverseReactions", anaesthesiaAdverseReactions)
                .append("isPregnant", isPregnant)
                .toString();
    }
}