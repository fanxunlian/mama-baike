/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : baike

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2018-07-10 17:33:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for a_article
-- ----------------------------
DROP TABLE IF EXISTS `a_article`;
CREATE TABLE `a_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `imge_uid` varchar(50) DEFAULT NULL,
  `content_uid` varchar(50) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'CURRENT_TIMESTAMP',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'CURRENT_TIMESTAMP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_article
-- ----------------------------

-- ----------------------------
-- Table structure for c_catalog
-- ----------------------------
DROP TABLE IF EXISTS `c_catalog`;
CREATE TABLE `c_catalog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `catalog_name` varchar(100) NOT NULL COMMENT '目录名称',
  `parent_id` int(11) NOT NULL COMMENT '父节点',
  `catalog_type` varchar(10) NOT NULL DEFAULT '1' COMMENT '是否目录 0 - 文章 1- 目录',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(10) NOT NULL DEFAULT '1' COMMENT '0-无效 1-有效',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='目录表格';

-- ----------------------------
-- Records of c_catalog
-- ----------------------------
INSERT INTO `c_catalog` VALUES ('1', '亲子', '0', '1', '2018-06-19 15:42:32', '2018-06-13 15:31:14', '1');
INSERT INTO `c_catalog` VALUES ('2', '教育', '0', '1', '2018-07-10 15:21:13', '2018-06-13 15:33:11', '1');
INSERT INTO `c_catalog` VALUES ('3', '疾病', '0', '1', '2018-06-19 15:42:33', '2018-06-13 15:33:26', '1');
INSERT INTO `c_catalog` VALUES ('4', '生活', '0', '1', '2018-07-10 15:21:21', '2018-06-13 15:33:43', '1');
INSERT INTO `c_catalog` VALUES ('5', '女性', '0', '1', '2018-07-10 15:22:31', '2018-06-13 15:33:43', '1');
INSERT INTO `c_catalog` VALUES ('6', '用品', '0', '1', '2018-07-10 15:22:33', '2018-06-13 15:33:43', '1');
INSERT INTO `c_catalog` VALUES ('7', '备孕', '1', '1', '2018-07-10 15:22:38', '2018-06-13 15:33:43', '1');
INSERT INTO `c_catalog` VALUES ('8', '怀孕', '1', '1', '2018-07-10 15:23:00', '2018-07-10 15:22:54', '1');
INSERT INTO `c_catalog` VALUES ('9', '分娩', '1', '1', '2018-07-10 15:23:41', '2018-07-10 15:23:41', '1');
INSERT INTO `c_catalog` VALUES ('10', '月子', '1', '1', '2018-07-10 15:23:50', '2018-07-10 15:23:50', '1');
INSERT INTO `c_catalog` VALUES ('11', '新生儿', '1', '1', '2018-07-10 15:24:11', '2018-07-10 15:24:11', '1');
INSERT INTO `c_catalog` VALUES ('12', '0-1岁', '1', '1', '2018-07-10 15:24:39', '2018-07-10 15:24:39', '1');
INSERT INTO `c_catalog` VALUES ('13', '1-3岁', '1', '1', '2018-07-10 15:24:40', '2018-07-10 15:24:40', '1');
INSERT INTO `c_catalog` VALUES ('14', '3-6岁', '1', '1', '2018-07-10 15:24:41', '2018-07-10 15:24:41', '1');
INSERT INTO `c_catalog` VALUES ('15', '女性孕前检查项目', '7', '1', '2018-07-10 15:36:06', '2018-07-10 15:36:06', '1');
INSERT INTO `c_catalog` VALUES ('16', '男性孕前检查项目', '7', '1', '2018-07-10 15:36:56', '2018-07-10 15:36:56', '1');
INSERT INTO `c_catalog` VALUES ('17', '孕前检查', '7', '1', '2018-07-10 15:37:00', '2018-07-10 15:37:00', '1');
INSERT INTO `c_catalog` VALUES ('18', '如何受孕', '7', '1', '2018-07-10 15:37:05', '2018-07-10 15:37:05', '1');
INSERT INTO `c_catalog` VALUES ('19', '月经排卵', '7', '1', '2018-07-10 15:37:09', '2018-07-10 15:37:09', '1');
INSERT INTO `c_catalog` VALUES ('20', '助孕饮食', '7', '1', '2018-07-10 15:37:15', '2018-07-10 15:37:15', '1');
INSERT INTO `c_catalog` VALUES ('21', '不孕不育', '7', '1', '2018-07-10 15:37:20', '2018-07-10 15:37:20', '1');
INSERT INTO `c_catalog` VALUES ('22', '验孕检查', '7', '1', '2018-07-10 15:37:25', '2018-07-10 15:37:25', '1');
INSERT INTO `c_catalog` VALUES ('23', '遗传优生', '7', '1', '2018-07-10 15:37:31', '2018-07-10 15:37:31', '1');
INSERT INTO `c_catalog` VALUES ('24', '生男生女', '7', '1', '2018-07-10 15:37:36', '2018-07-10 15:37:36', '1');
INSERT INTO `c_catalog` VALUES ('25', '备孕生活', '7', '1', '2018-07-10 15:37:36', '2018-07-10 15:37:36', '1');
INSERT INTO `c_catalog` VALUES ('26', '单纯疱疹病毒', '15', '1', '2018-07-10 15:41:06', '2018-07-10 15:41:06', '1');
INSERT INTO `c_catalog` VALUES ('27', '风疹', '15', '1', '2018-07-10 15:41:10', '2018-07-10 15:41:10', '1');
INSERT INTO `c_catalog` VALUES ('28', '胸透', '15', '1', '2018-07-10 15:41:16', '2018-07-10 15:41:16', '1');
INSERT INTO `c_catalog` VALUES ('29', '脱畸全套', '15', '1', '2018-07-10 15:41:16', '2018-07-10 15:41:16', '1');
INSERT INTO `c_catalog` VALUES ('30', '妇科内分泌', '15', '1', '2018-07-10 15:41:28', '2018-07-10 15:41:28', '1');
INSERT INTO `c_catalog` VALUES ('31', '白带常规', '15', '1', '2018-07-10 15:41:34', '2018-07-10 15:41:34', '1');
INSERT INTO `c_catalog` VALUES ('32', '染色体检查', '15', '1', '2018-07-10 15:41:39', '2018-07-10 15:41:39', '1');
INSERT INTO `c_catalog` VALUES ('33', '体格检查', '15', '1', '2018-07-10 15:41:49', '2018-07-10 15:41:49', '1');
INSERT INTO `c_catalog` VALUES ('34', '便常规检查', '15', '1', '2018-07-10 15:41:58', '2018-07-10 15:41:58', '1');
INSERT INTO `c_catalog` VALUES ('35', '尿常规检查', '15', '1', '2018-07-10 15:42:03', '2018-07-10 15:42:03', '1');
INSERT INTO `c_catalog` VALUES ('36', '血常规检查', '15', '1', '2018-07-10 15:42:09', '2018-07-10 15:42:09', '1');
INSERT INTO `c_catalog` VALUES ('37', 'abo溶血', '15', '1', '2018-07-10 15:42:17', '2018-07-10 15:42:17', '1');
INSERT INTO `c_catalog` VALUES ('38', '肝功能检查', '15', '1', '2018-07-10 15:42:24', '2018-07-10 15:42:24', '1');

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `user_pass` varchar(100) DEFAULT NULL,
  `nick_name` varchar(100) DEFAULT NULL,
  `user_type` varchar(100) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', 'fxl', '123', '樊训练', '1', null, '2018-07-03 11:01:17', '2018-07-03 11:01:19');
