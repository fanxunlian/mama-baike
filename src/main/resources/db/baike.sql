/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : baike

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2018-07-11 17:57:43
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
) ENGINE=MyISAM AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COMMENT='目录表格';

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
INSERT INTO `c_catalog` VALUES ('39', '怀孕反应', '8', '1', '2018-07-11 15:20:34', '2018-07-11 15:20:34', '1');
INSERT INTO `c_catalog` VALUES ('40', '孕早期', '8', '1', '2018-07-11 15:20:46', '2018-07-11 15:20:46', '1');
INSERT INTO `c_catalog` VALUES ('41', '孕中期', '8', '1', '2018-07-11 15:20:54', '2018-07-11 15:20:54', '1');
INSERT INTO `c_catalog` VALUES ('42', '孕晚期', '8', '1', '2018-07-11 15:21:02', '2018-07-11 15:21:02', '1');
INSERT INTO `c_catalog` VALUES ('43', '孕期饮食', '8', '1', '2018-07-11 15:21:12', '2018-07-11 15:21:12', '1');
INSERT INTO `c_catalog` VALUES ('44', '孕期营养', '8', '1', '2018-07-11 15:21:19', '2018-07-11 15:21:19', '1');
INSERT INTO `c_catalog` VALUES ('45', '孕妇保健', '8', '1', '2018-07-11 15:21:27', '2018-07-11 15:21:27', '1');
INSERT INTO `c_catalog` VALUES ('46', '孕期检查', '8', '1', '2018-07-11 15:21:35', '2018-07-11 15:21:35', '1');
INSERT INTO `c_catalog` VALUES ('47', '孕期疾病', '8', '1', '2018-07-11 15:21:43', '2018-07-11 15:21:43', '1');
INSERT INTO `c_catalog` VALUES ('48', '孕期生活', '8', '1', '2018-07-11 15:21:50', '2018-07-11 15:21:50', '1');
INSERT INTO `c_catalog` VALUES ('49', '胎教', '8', '1', '2018-07-11 15:21:57', '2018-07-11 15:21:57', '1');
INSERT INTO `c_catalog` VALUES ('50', '胎儿发育', '8', '1', '2018-07-11 15:22:05', '2018-07-11 15:22:05', '1');
INSERT INTO `c_catalog` VALUES ('51', '怀孕须知', '8', '1', '2018-07-11 15:22:13', '2018-07-11 15:22:13', '1');
INSERT INTO `c_catalog` VALUES ('52', '终止妊娠', '8', '1', '2018-07-11 15:22:22', '2018-07-11 15:22:22', '1');
INSERT INTO `c_catalog` VALUES ('53', '孕妇饮食禁忌', '8', '1', '2018-07-11 15:22:29', '2018-07-11 15:22:29', '1');
INSERT INTO `c_catalog` VALUES ('54', '产前检查', '9', '1', '2018-07-11 15:40:13', '2018-07-11 15:40:13', '1');
INSERT INTO `c_catalog` VALUES ('55', '音乐', '2', '1', '2018-07-11 16:44:56', '2018-07-11 16:44:56', '1');
INSERT INTO `c_catalog` VALUES ('56', '英语', '2', '1', '2018-07-11 16:44:59', '2018-07-11 16:44:59', '1');
INSERT INTO `c_catalog` VALUES ('57', '玩具', '2', '1', '2018-07-11 16:45:02', '2018-07-11 16:45:02', '1');
INSERT INTO `c_catalog` VALUES ('58', '绘画', '2', '1', '2018-07-11 16:45:05', '2018-07-11 16:45:05', '1');
INSERT INTO `c_catalog` VALUES ('59', '妇科疾病', '3', '1', '2018-07-11 16:46:20', '2018-07-11 16:46:20', '1');
INSERT INTO `c_catalog` VALUES ('60', '男性疾病', '3', '1', '2018-07-11 16:46:20', '2018-07-11 16:46:20', '1');
INSERT INTO `c_catalog` VALUES ('61', '孕期疾病', '3', '1', '2018-07-11 16:46:27', '2018-07-11 16:46:27', '1');
INSERT INTO `c_catalog` VALUES ('62', '儿童疾病', '3', '1', '2018-07-11 16:46:32', '2018-07-11 16:46:32', '1');
INSERT INTO `c_catalog` VALUES ('63', '生活疾病', '3', '1', '2018-07-11 16:46:38', '2018-07-11 16:46:38', '1');
INSERT INTO `c_catalog` VALUES ('64', '理财', '4', '1', '2018-07-11 16:47:12', '2018-07-11 16:47:12', '1');
INSERT INTO `c_catalog` VALUES ('65', '饮食', '4', '1', '2018-07-11 16:47:17', '2018-07-11 16:47:17', '1');
INSERT INTO `c_catalog` VALUES ('66', '健身', '4', '1', '2018-07-11 16:47:22', '2018-07-11 16:47:22', '1');
INSERT INTO `c_catalog` VALUES ('67', '旅游', '4', '1', '2018-07-11 16:47:27', '2018-07-11 16:47:27', '1');
INSERT INTO `c_catalog` VALUES ('68', '摄影', '4', '1', '2018-07-11 16:47:28', '2018-07-11 16:47:28', '1');
INSERT INTO `c_catalog` VALUES ('69', '护理', '5', '1', '2018-07-11 16:47:56', '2018-07-11 16:47:56', '1');
INSERT INTO `c_catalog` VALUES ('70', '美甲', '5', '1', '2018-07-11 16:48:02', '2018-07-11 16:48:02', '1');
INSERT INTO `c_catalog` VALUES ('71', '情感', '5', '1', '2018-07-11 16:48:02', '2018-07-11 16:48:02', '1');
INSERT INTO `c_catalog` VALUES ('72', '美发', '5', '1', '2018-07-11 16:48:08', '2018-07-11 16:48:08', '1');
INSERT INTO `c_catalog` VALUES ('73', '服饰', '5', '1', '2018-07-11 16:48:23', '2018-07-11 16:48:23', '1');
INSERT INTO `c_catalog` VALUES ('74', '妈妈用品', '6', '1', '2018-07-11 16:48:38', '2018-07-11 16:48:38', '1');
INSERT INTO `c_catalog` VALUES ('75', '宝宝用品', '6', '1', '2018-07-11 16:48:52', '2018-07-11 16:48:52', '1');
INSERT INTO `c_catalog` VALUES ('76', '家庭用品', '6', '1', '2018-07-11 16:48:58', '2018-07-11 16:48:58', '1');
INSERT INTO `c_catalog` VALUES ('77', '单纯疱疹是什么', '26', '1', '2018-07-11 17:48:19', '2018-07-11 17:48:19', '1');
INSERT INTO `c_catalog` VALUES ('78', '单纯疱疹病毒1型', '26', '1', '2018-07-11 17:48:43', '2018-07-11 17:48:43', '1');
INSERT INTO `c_catalog` VALUES ('79', '单纯疱疹病毒2型', '26', '1', '2018-07-11 17:48:57', '2018-07-11 17:48:57', '1');
INSERT INTO `c_catalog` VALUES ('80', '单纯疱疹是怎么引起的', '26', '1', '2018-07-11 17:49:02', '2018-07-11 17:49:02', '1');
INSERT INTO `c_catalog` VALUES ('81', '单纯疱疹病毒能怀孕吗', '26', '1', '2018-07-11 17:49:08', '2018-07-11 17:49:08', '1');
INSERT INTO `c_catalog` VALUES ('82', '单纯疱疹是什么', '77', '1', '2018-07-11 17:49:51', '2018-07-11 17:49:51', '1');
INSERT INTO `c_catalog` VALUES ('83', '单纯疱疹的症状', '77', '1', '2018-07-11 17:50:01', '2018-07-11 17:50:01', '1');
INSERT INTO `c_catalog` VALUES ('84', '单纯疱疹是怎么引起的', '77', '1', '2018-07-11 17:50:24', '2018-07-11 17:50:24', '1');
INSERT INTO `c_catalog` VALUES ('85', '单纯胞疹怎么治', '77', '1', '2018-07-11 17:50:26', '2018-07-11 17:50:26', '1');
INSERT INTO `c_catalog` VALUES ('86', '单纯胞疹能治愈吗', '77', '1', '2018-07-11 17:50:37', '2018-07-11 17:50:37', '1');
INSERT INTO `c_catalog` VALUES ('87', '单纯疱疹传染吗', '77', '1', '2018-07-11 17:50:47', '2018-07-11 17:50:47', '1');

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
