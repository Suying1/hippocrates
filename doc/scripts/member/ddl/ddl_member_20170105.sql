-- 取消外键约束
SET FOREIGN_KEY_CHECKS=0;

-- 创建数据库
CREATE DATABASE `member`;
USE member;


-- -----------------------------
-- 表名：病人基本信息表
-- 作者：shucunbin
-- 日期：2017/01/05
-- 版本：1.0.0
-- 描述：用于记录病人基本信息.
-- -----------------------------
DROP TABLE IF EXISTS `t_patient`;
CREATE TABLE `t_patient` (
  `PATIENT_ID` VARCHAR(32) NOT NULL COMMENT '患者唯一标识',
  `PATIENT_NAME` VARCHAR(255) NOT NULL COMMENT '患者姓名',
  `BIRTHDAY` DATE COMMENT '患者出生日期',
  `GENDER` VARCHAR(1) COMMENT '患者性别：M 表示男性，F 表示女性',
  `PATIENT_GUARDIAN` VARCHAR(255) COMMENT '患者监护人',
  `MOBILEPHONE` VARCHAR(16) COMMENT '患者手机号',
  `TELEPHONE` VARCHAR(32) COMMENT '患者固定电话号码',
  `EMAIL` VARCHAR(64) COMMENT '患者电子邮件',
  `QQ` VARCHAR(16) COMMENT '患者QQ号',
  `WECHAT` VARCHAR(64) COMMENT '患者微信号',
  `RESIDENCE_PLACE` VARCHAR(512) COMMENT '患者家庭住址',
  `ALLERGIC_DRUGS` VARCHAR(512) COMMENT '过敏药物',
  `ALLERGENIC_FOODS` VARCHAR(512) COMMENT '过敏食物',
  `OTHER_ALLERGENS` VARCHAR(512) COMMENT '其它过敏源',
  `HAS_HEART_DISEASE` VARCHAR(1) DEFAULT 'N' COMMENT '是否有心脏病：Y 表示有，N表示没有',
  `HEART_DISEASE_REMARK` VARCHAR(512) COMMENT '心脏病备注信息',
  `BLOOD_PRESSURE_STATUS` TINYINT(1) DEFAULT 0 COMMENT '患者血压状况：0 表示正常，1 表示有高血压，2 表示有低血压',
  `CURRENT_BLOOD_PRESSURE` DECIMAL(8 , 0 ) COMMENT '当前血压值',
  `BLOOD_GLUCOSE_STATUS` TINYINT(1) DEFAULT 0 COMMENT '血糖状况：0 表示正常，1 表示高血糖，2 表示低血糖',
  `CURRENT_BLOOD_GLUCOSE` DECIMAL(8 , 0 ) COMMENT '当前血糖值',
  `HAS_OTHER_DISEASE` VARCHAR(1) DEFAULT 'N' COMMENT '是否有其它疾病：Y 表示有，N表示没有',
  `OTHER_DISEASE_REMARK` VARCHAR(512) COMMENT '其它疾病备注信息',
  `HAS_SMOKING_HISTORY` VARCHAR(1) DEFAULT 'N' COMMENT '是否有吸烟史：Y 表示有，N 表示没有',
  `HAS_DRINKING_HISTORY` VARCHAR(1) DEFAULT 'N' COMMENT '是否有饮酒史：Y 表示有，N 表示没有',
  `ANAESTHESIA_ADVERSE_REACTIONS` TINYINT(1) DEFAULT 0 COMMENT '口腔麻醉反应：0 表示没有，1 表示有，2 表示不知道',
  `IS_PREGNANT` VARCHAR(1) DEFAULT 'N' COMMENT '是否怀孕：Y 表示已怀孕，N 表示未怀孕',
  `CREATE_TIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '患者信息建立时间',
  `UPDATE_TIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '患者信息更新时间',
  `CREATE_USER` VARCHAR(50) DEFAULT NULL COMMENT '患者信息建立人',
  `UPDATE_USER` VARCHAR(50) DEFAULT NULL COMMENT '患者信息更新人',
  `EXTENSION` VARCHAR(1024) COMMENT '扩展字段',
  PRIMARY KEY (`PATIENT_ID`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='患者基本信息表';


-- -----------------------------
-- 表名：通用序列表
-- 作者：shucunbin
-- 日期：2017/01/09
-- 版本：1.0.0
-- 描述：用于生成唯一标识.
-- -----------------------------
DROP TABLE IF EXISTS `t_sequence`;
CREATE TABLE `t_sequence` (
  `SEQ_NAME` VARCHAR(64) NOT NULL COMMENT '序列名称（标识）',
  `CURRENT_VALUE` INT(11) NOT NULL DEFAULT 1 COMMENT '序列当前值',
  `INCREMENT` SMALLINT(6) NOT NULL DEFAULT 1 COMMENT '序列自增量',
  `CAPACITY` SMALLINT(6) NOT NULL DEFAULT 10000 COMMENT '每次取值容量',
  `THRESHOLD` SMALLINT(6) NOT NULL DEFAULT 7500 COMMENT '阈值',
  PRIMARY KEY (`SEQ_NAME`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='通用序列表';