/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : baike

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2018-06-19 15:52:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_catalog
-- ----------------------------
DROP TABLE IF EXISTS `c_catalog`;
CREATE TABLE `c_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `catalog_name` varchar(100) NOT NULL COMMENT '目录名称',
  `parent_id` int(11) NOT NULL COMMENT '父节点',
  `catalog_type` varchar(10) NOT NULL COMMENT '是否目录 0 - 文章 1- 目录',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` varchar(10) NOT NULL DEFAULT '1' COMMENT '0-无效 1-有效',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='目录表格';

-- ----------------------------
-- Records of c_catalog
-- ----------------------------
INSERT INTO `c_catalog` VALUES ('1', '亲子', '0', '1', '2018-06-19 15:42:32', '2018-06-13 15:31:14', '1');
INSERT INTO `c_catalog` VALUES ('2', '饮食', '0', '1', '2018-06-19 15:42:33', '2018-06-13 15:33:11', '1');
INSERT INTO `c_catalog` VALUES ('3', '疾病', '0', '1', '2018-06-19 15:42:33', '2018-06-13 15:33:26', '1');
INSERT INTO `c_catalog` VALUES ('4', '生活用品', '0', '1', '2018-06-19 15:42:34', '2018-06-13 15:33:43', '1');
