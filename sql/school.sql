/*
 Navicat Premium Data Transfer

 Source Server         : ali_mysql
 Source Server Type    : MySQL
 Source Server Version : 50549
 Source Host           : localhost
 Source Database       : zhongkaobao

 Target Server Type    : MySQL
 Target Server Version : 50549
 File Encoding         : utf-8

 Date: 07/01/2016 15:12:33 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `zkb_school`;
CREATE TABLE `zkb_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '学校名称',
  `level` tinyint(4) NOT NULL DEFAULT '0',
  `area_id` int(11) DEFAULT NULL COMMENT '所属区域id ，外键',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 公办 1 私立',
  `del` tinyint(4) NULL DEFAULT '0' COMMENT '0 未删除  1 逻辑删除',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
