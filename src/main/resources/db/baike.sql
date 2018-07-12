/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : baike

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2018-07-12 17:33:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_baby
-- ----------------------------
DROP TABLE IF EXISTS `b_baby`;
CREATE TABLE `b_baby` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '出生日期',
  `name` varchar(20) DEFAULT NULL COMMENT '名字',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_baby
-- ----------------------------

-- ----------------------------
-- Table structure for b_user_baby
-- ----------------------------
DROP TABLE IF EXISTS `b_user_baby`;
CREATE TABLE `b_user_baby` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `baby_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_user_baby
-- ----------------------------

-- ----------------------------
-- Table structure for c_article
-- ----------------------------
DROP TABLE IF EXISTS `c_article`;
CREATE TABLE `c_article` (
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
-- Records of c_article
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
INSERT INTO `c_catalog` VALUES ('82', '单纯疱疹是什么', '77', '0', '2018-07-12 09:20:58', '2018-07-12 09:20:58', '1');
INSERT INTO `c_catalog` VALUES ('83', '单纯疱疹的症状', '77', '0', '2018-07-12 09:20:57', '2018-07-12 09:20:57', '1');
INSERT INTO `c_catalog` VALUES ('84', '单纯疱疹是怎么引起的', '77', '0', '2018-07-12 09:20:56', '2018-07-12 09:20:56', '1');
INSERT INTO `c_catalog` VALUES ('85', '单纯胞疹怎么治', '77', '0', '2018-07-12 09:20:55', '2018-07-12 09:20:55', '1');
INSERT INTO `c_catalog` VALUES ('86', '单纯胞疹能治愈吗', '77', '0', '2018-07-12 09:20:53', '2018-07-12 09:20:53', '1');
INSERT INTO `c_catalog` VALUES ('87', '单纯疱疹传染吗', '77', '0', '2018-07-12 09:20:52', '2018-07-12 09:20:52', '1');

-- ----------------------------
-- Table structure for f_forum
-- ----------------------------
DROP TABLE IF EXISTS `f_forum`;
CREATE TABLE `f_forum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '圈子名称',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建人id',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `type` varchar(10) DEFAULT '0' COMMENT '0-普通贴 1-推荐贴 2-精华帖',
  `tag` varchar(10) DEFAULT NULL COMMENT '帖子标签 0-火爆 1-精华 3-带图片 分号分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_forum
-- ----------------------------

-- ----------------------------
-- Table structure for f_reply
-- ----------------------------
DROP TABLE IF EXISTS `f_reply`;
CREATE TABLE `f_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `forum_id` int(11) DEFAULT NULL,
  `reply_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content_uid` varchar(50) DEFAULT NULL COMMENT 'mongo存储的内容',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子回复';

-- ----------------------------
-- Records of f_reply
-- ----------------------------

-- ----------------------------
-- Table structure for s_admin
-- ----------------------------
DROP TABLE IF EXISTS `s_admin`;
CREATE TABLE `s_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '盐',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '全名',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_admin
-- ----------------------------

-- ----------------------------
-- Table structure for s_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `s_dictionary`;
CREATE TABLE `s_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for t_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_type` varchar(10) DEFAULT NULL COMMENT '1-妈妈圈 2-同城 3-同龄',
  `class_type` varchar(10) DEFAULT NULL COMMENT '1-亲子2-时尚',
  `name` varchar(50) DEFAULT NULL COMMENT '话题名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `topic_uid` varchar(50) DEFAULT NULL COMMENT '话题详细内容存储id',
  `manage_id` int(11) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_topic
-- ----------------------------
INSERT INTO `t_topic` VALUES ('1', '1', '1', '健康养生馆', '年轻人，我劝你养生', null, null, '2018-07-12 17:19:55', '2018-07-12 17:19:55');
INSERT INTO `t_topic` VALUES ('2', '1', '1', '准备怀孕', '备孕经验大全，谁来谁怀孕', null, null, '2018-07-12 17:19:55', '2018-07-12 17:19:55');
INSERT INTO `t_topic` VALUES ('3', '1', '1', '0-1岁宝宝', '吃喝拉撒睡无小事', null, null, '2018-07-12 17:19:56', '2018-07-12 17:19:56');
INSERT INTO `t_topic` VALUES ('4', '1', '1', '早教幼教', '再不陪孩子早教，TA就长大了！', null, null, '2018-07-12 17:19:56', '2018-07-12 17:19:56');
INSERT INTO `t_topic` VALUES ('5', '1', '1', '时尚美容', '没有丑女人，只有懒女人~', null, null, '2018-07-12 17:19:57', '2018-07-12 17:19:57');
INSERT INTO `t_topic` VALUES ('6', '1', '1', '情感婚姻', '狗血故事天天在上演', null, null, '2018-07-12 17:19:57', '2018-07-12 17:19:57');
INSERT INTO `t_topic` VALUES ('7', '1', '1', '全球代购专场', '不费力气败遍全球', null, null, '2018-07-12 17:19:58', '2018-07-12 17:19:58');
INSERT INTO `t_topic` VALUES ('8', '1', '1', '婴童用品专场', '给孩子挑好货就来这', null, null, '2018-07-12 17:19:59', '2018-07-12 17:19:59');
INSERT INTO `t_topic` VALUES ('9', '1', '1', '辣妈晒照', '谁还不是小仙女！', null, null, '2018-07-12 17:19:59', '2018-07-12 17:19:59');
INSERT INTO `t_topic` VALUES ('10', '1', '1', '谈天说地', '想聊就聊，开心就好', null, null, '2018-07-12 17:20:00', '2018-07-12 17:20:00');
INSERT INTO `t_topic` VALUES ('11', '1', '1', '美食厨房', '唯有美食不可辜负', null, null, '2018-07-12 17:20:02', '2018-07-12 17:20:02');
INSERT INTO `t_topic` VALUES ('12', '1', '1', '职场女性', '事业家庭少一个都不行', null, null, '2018-07-12 17:20:03', '2018-07-12 17:20:03');
INSERT INTO `t_topic` VALUES ('13', '1', '1', '辣妈用品专场', '妈妈的线上百货超市', null, null, '2018-07-12 17:20:03', '2018-07-12 17:20:03');
INSERT INTO `t_topic` VALUES ('14', '1', '1', '非买不可·拼单团购', '省半个月工资', null, null, '2018-07-12 17:20:04', '2018-07-12 17:20:04');
INSERT INTO `t_topic` VALUES ('15', '1', '1', '待产包讨论', '实用划算清单照着买', null, null, '2018-07-12 17:20:05', '2018-07-12 17:20:05');
INSERT INTO `t_topic` VALUES ('16', '1', '1', '生男生女猜猜猜', '民间B超机性别任选', null, null, '2018-07-12 17:20:06', '2018-07-12 17:20:06');
INSERT INTO `t_topic` VALUES ('17', '1', '2', '宝宝名字怎么取', '取名专家常出没于此', null, null, '2018-07-12 17:20:07', '2018-07-12 17:20:07');
INSERT INTO `t_topic` VALUES ('18', '1', '2', '宝宝营养辅食', '让宝宝爱上辅食，一周7天辅食不重样', null, null, '2018-07-12 17:20:09', '2018-07-12 17:20:09');
INSERT INTO `t_topic` VALUES ('19', '1', '2', '坐月子', '月子餐产后护理经验', null, null, '2018-07-12 17:20:09', '2018-07-12 17:20:09');
INSERT INTO `t_topic` VALUES ('20', '1', '2', '幼儿园宝宝', '宝宝踏入小社会啦', null, null, '2018-07-12 17:20:25', '2018-07-12 17:20:25');
INSERT INTO `t_topic` VALUES ('21', '1', '2', '早教幼教', '再不陪孩子早教，TA就长大了！', null, null, '2018-07-12 17:20:27', '2018-07-12 17:20:27');
INSERT INTO `t_topic` VALUES ('22', '1', '2', '辣妈晒照', '谁还不是小仙女！', null, null, '2018-07-12 17:20:28', '2018-07-12 17:20:28');
INSERT INTO `t_topic` VALUES ('23', '1', '2', '瘦身大作战', '瘦下来才知道你多美', null, null, '2018-07-12 17:20:29', '2018-07-12 17:20:29');
INSERT INTO `t_topic` VALUES ('24', '1', '3', '母乳喂养', '轻松做奶牛，享受母乳时光', null, null, '2018-07-12 17:20:30', '2018-07-12 17:20:30');
INSERT INTO `t_topic` VALUES ('25', '1', '3', '母乳喂养', '轻松做奶牛，享受母乳时光', null, null, '2018-07-12 17:20:32', '2018-07-12 17:20:32');
INSERT INTO `t_topic` VALUES ('26', '1', '3', '母乳喂养', '轻松做奶牛，享受母乳时光', null, null, '2018-07-12 17:20:33', '2018-07-12 17:20:33');

-- ----------------------------
-- Table structure for t_topic_forum
-- ----------------------------
DROP TABLE IF EXISTS `t_topic_forum`;
CREATE TABLE `t_topic_forum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) DEFAULT NULL,
  `forum_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_topic_forum
-- ----------------------------

-- ----------------------------
-- Table structure for t_topic_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_topic_manager`;
CREATE TABLE `t_topic_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_topic_manager
-- ----------------------------

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `user_pass` varchar(100) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `nick_name` varchar(100) DEFAULT NULL,
  `user_type` varchar(100) DEFAULT '1' COMMENT '1-用户 ',
  `mobile` varchar(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `location` varchar(20) DEFAULT NULL COMMENT '地址',
  `location_id` int(11) DEFAULT NULL COMMENT '地址id',
  `points` int(11) DEFAULT NULL COMMENT '积分',
  `level` int(11) DEFAULT NULL COMMENT '等级',
  `verify` varchar(255) DEFAULT NULL COMMENT '认证',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', 'fxl', '123', null, '樊训练', '1', null, '2018-07-03 11:01:17', '2018-07-03 11:01:19', null, null, null, null, null);

-- ----------------------------
-- Table structure for u_user_fans
-- ----------------------------
DROP TABLE IF EXISTS `u_user_fans`;
CREATE TABLE `u_user_fans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fans_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user_fans
-- ----------------------------

-- ----------------------------
-- Table structure for u_user_focus
-- ----------------------------
DROP TABLE IF EXISTS `u_user_focus`;
CREATE TABLE `u_user_focus` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `focus_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user_focus
-- ----------------------------

-- ----------------------------
-- Table structure for u_user_topic
-- ----------------------------
DROP TABLE IF EXISTS `u_user_topic`;
CREATE TABLE `u_user_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `topic_id` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user_topic
-- ----------------------------
