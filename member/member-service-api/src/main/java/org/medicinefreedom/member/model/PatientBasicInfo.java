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

package org.medicinefreedom.member.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.medicinefreedom.member.enums.AnaesthesiaAdverseReactions;
import org.medicinefreedom.member.enums.BloodGlucoseStatus;
import org.medicinefreedom.member.enums.BloodPressureStatus;
import org.medicinefreedom.member.enums.Gender;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * 通用说明：患者基本信息类.
 *
 * @author <a href="mailto:shucunbin@163.com">shucunbin</a>
 * @version 1.0.0  2017/1/11 10:47
 */
public class PatientBasicInfo {
    /**
     * 患者姓名
     */
    @NotNull(message = "患者姓名不能为空")
    @Size(min = 1, max = 255, message = "患者姓名校验失败，长度限制为1~255位")
    private String name;

    /**
     * 患者出生日期（格式为yyyy-MM-dd）
     */
    private Date birthday;

    /**
     * 患者性别
     */
    @NotNull(message = "患者性别不能为空")
    private Gender gender;

    /**
     * 患者监护人
     */
    private String guardian;

    /**
     * 患者移动电话
     */
    @NotNull(message = "患者手机号不能为空")
    @Size(min = 1, max = 16, message = "患者手机好校验失败，长度限制为1~16位")
    private String mobilephone;

    /**
     * 患者固定电话
     */
    private String telephone;

    /**
     * 患者电子邮件
     */
    private String email;

    /**
     * 患者 QQ 号
     */
    private String qq;

    /**
     * 患者微信
     */
    private String wechat;

    /**
     * 患者家庭地址
     */
    private String residencePlace;

    /**
     * 患者过敏药物
     */
    private Set<String> allergicDrugs;

    /**
     * 患者过敏食物
     */
    private Set<String> allergenicFoods;

    /**
     * 患者其它过敏源
     */
    private Set<String> otherAllergens;

    /**
     * 患者是否患有心脏病
     */
    private boolean hasHeartDisease;

    /**
     * 患者心脏病备注信息
     */
    private String heartDiseaseRemark;

    /**
     * 患者血压状况
     */
    private BloodPressureStatus bloodPressureStatus;

    /**
     * 患者当前血压值
     */
    private int currentBloodPressure;

    /**
     * 患者血糖状况
     */
    private BloodGlucoseStatus bloodGlucoseStatus;

    /**
     * 患者当前血糖值
     */
    private int currentBloodGlucose;

    /**
     * 患者是否有其它疾病
     */
    private boolean hasOtherDisease;

    /**
     * 患者其它疾病备注信息
     */
    private String otherDiseaseRemark;

    /**
     * 患者是否有吸烟史
     */
    private boolean hasSmokingHistory;

    /**
     * 患者是否有饮酒史
     */
    private boolean hasDrinkingHistory;

    /**
     * 患者口腔麻醉反应
     */
    private AnaesthesiaAdverseReactions anaesthesiaAdverseReactions;

    /**
     * 患者是否怀孕
     */
    private boolean isPregnant;

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

    public boolean isHasHeartDisease() {
        return hasHeartDisease;
    }

    public void setHasHeartDisease(boolean hasHeartDisease) {
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

    public boolean isHasOtherDisease() {
        return hasOtherDisease;
    }

    public void setHasOtherDisease(boolean hasOtherDisease) {
        this.hasOtherDisease = hasOtherDisease;
    }

    public String getOtherDiseaseRemark() {
        return otherDiseaseRemark;
    }

    public void setOtherDiseaseRemark(String otherDiseaseRemark) {
        this.otherDiseaseRemark = otherDiseaseRemark;
    }

    public boolean isHasSmokingHistory() {
        return hasSmokingHistory;
    }

    public void setHasSmokingHistory(boolean hasSmokingHistory) {
        this.hasSmokingHistory = hasSmokingHistory;
    }

    public boolean isHasDrinkingHistory() {
        return hasDrinkingHistory;
    }

    public void setHasDrinkingHistory(boolean hasDrinkingHistory) {
        this.hasDrinkingHistory = hasDrinkingHistory;
    }

    public AnaesthesiaAdverseReactions getAnaesthesiaAdverseReactions() {
        return anaesthesiaAdverseReactions;
    }

    public void setAnaesthesiaAdverseReactions(AnaesthesiaAdverseReactions anaesthesiaAdverseReactions) {
        this.anaesthesiaAdverseReactions = anaesthesiaAdverseReactions;
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    public void setPregnant(boolean pregnant) {
        isPregnant = pregnant;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
