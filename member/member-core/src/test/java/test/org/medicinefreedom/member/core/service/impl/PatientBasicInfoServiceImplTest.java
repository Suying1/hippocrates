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

package test.org.medicinefreedom.member.core.service.impl;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.medicinefreedom.member.core.enums.Gender;
import org.medicinefreedom.member.core.model.PatientBasicInfo;
import org.medicinefreedom.member.core.service.PatientBasicInfoService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * PatientBasicInfoServiceImpl Tester.
 *
 * @author shucunbin
 * @version 1.0
 * @since <pre>2017/01/10</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/springtest/testApplicationContext.xml")
public class PatientBasicInfoServiceImplTest {
    @Resource(name = "patientBasicInfoService")
    private PatientBasicInfoService patientBasicInfoService;

    private PatientBasicInfo patientBasicInfo;

    @Before
    public void before() throws Exception {
        patientBasicInfo = new PatientBasicInfo();
        patientBasicInfo.setName("张三");
        patientBasicInfo.setBirthday(DateUtils.parseDate("1990-01-01","yyyy-MM-dd"));
        patientBasicInfo.setGender(Gender.FEMALE);
        patientBasicInfo.setGuardian("张大三");
        patientBasicInfo.setMobilephone("13600000001");
        patientBasicInfo.setTelephone("012-000123");
        patientBasicInfo.setEmail("zhangsan@test.com");
        patientBasicInfo.setQq("123456");
        patientBasicInfo.setWechat("13600000001");
        patientBasicInfo.setResidencePlace("天朝xx省xx市xxx街道xx楼1234室");

        Set<String> allergicDrugs = new HashSet<>();
        allergicDrugs.add("过敏药1");
        allergicDrugs.add("过敏药2");
        allergicDrugs.add("过敏药3");
        patientBasicInfo.setAllergicDrugs(allergicDrugs);

        patientBasicInfo.setHasHeartDisease(Boolean.TRUE);
        patientBasicInfo.setHeartDiseaseRemark("先天性心脏疾病");
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: savePatientBasicInfo(PatientBasicInfo patientBasicInfo)
     */
    @Test
    public void testSavePatientBasicInfo() throws Exception {
        patientBasicInfoService.savePatientBasicInfo(patientBasicInfo);
    }
} 
