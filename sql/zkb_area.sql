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

 Date: 07/01/2016 15:23:41 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `zkb_area`
-- ----------------------------
DROP TABLE IF EXISTS `zkb_area`;
CREATE TABLE `zkb_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) NOT NULL DEFAULT '' COMMENT '区域名称',
  `parent_id` int(11) DEFAULT -1 COMMENT '所属区域id 父id',
  `level` int(11) NOT NULL DEFAULT -1 COMMENT '三级分类, 1 市级， 2 区县， 3 乡镇',
  `del` tinyint(4) DEFAULT '0' COMMENT '0 未删除 1 已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
