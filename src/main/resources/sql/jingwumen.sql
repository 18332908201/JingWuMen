/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : jingwumen

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2020-03-15 21:45:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) DEFAULT NULL,
  `classIntroduction` varchar(255) DEFAULT NULL,
  `classPrice` varchar(255) DEFAULT NULL,
  `classStart` date DEFAULT NULL,
  `classNumber` int(11) DEFAULT NULL,
  `orderNumber` int(11) DEFAULT NULL,
  `updateTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '打', '嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻', '15', '2020-03-10', '2', '2', '2020-03-12');

-- ----------------------------
-- Table structure for classorder
-- ----------------------------
DROP TABLE IF EXISTS `classorder`;
CREATE TABLE `classorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classorder
-- ----------------------------
INSERT INTO `classorder` VALUES ('2', null, null, '2020-03-14', 'wdk', '打');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` varchar(255) NOT NULL,
  `development` varchar(255) DEFAULT NULL,
  `scale` varchar(255) DEFAULT NULL,
  `now` varchar(255) DEFAULT NULL,
  `fitnessKnowledge` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '威威', '威威', '威威', '额', '2020-03-01');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `createTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '全部九折', '好消息！！！！！！！\n全场9折', '2020-03-01');
INSERT INTO `notice` VALUES ('2', '45', '64564', '2020-02-12');
INSERT INTO `notice` VALUES ('4', 's', 'ddd', '2018-02-28');
INSERT INTO `notice` VALUES ('5', 's', 'ddd', '2018-02-28');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '在线报名');
INSERT INTO `permission` VALUES ('2', '活动公告');
INSERT INTO `permission` VALUES ('3', '俱乐部概况');
INSERT INTO `permission` VALUES ('4', '课程信息管理');
INSERT INTO `permission` VALUES ('5', '用户管理');
INSERT INTO `permission` VALUES ('6', '新闻管理');
INSERT INTO `permission` VALUES ('7', '活动公告管理');
INSERT INTO `permission` VALUES ('8', '权限管理');
INSERT INTO `permission` VALUES ('9', '课程预定列表');
INSERT INTO `permission` VALUES ('10', '角色管理');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员');
INSERT INTO `role` VALUES ('2', '管理员');
INSERT INTO `role` VALUES ('3', '用户');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `roleId` int(11) DEFAULT NULL,
  `permissionId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1');
INSERT INTO `role_permission` VALUES ('1', '2');
INSERT INTO `role_permission` VALUES ('1', '3');
INSERT INTO `role_permission` VALUES ('1', '4');
INSERT INTO `role_permission` VALUES ('1', '5');
INSERT INTO `role_permission` VALUES ('1', '6');
INSERT INTO `role_permission` VALUES ('1', '7');
INSERT INTO `role_permission` VALUES ('1', '8');
INSERT INTO `role_permission` VALUES ('2', '1');
INSERT INTO `role_permission` VALUES ('2', '2');
INSERT INTO `role_permission` VALUES ('2', '3');
INSERT INTO `role_permission` VALUES ('2', '4');
INSERT INTO `role_permission` VALUES ('2', '5');
INSERT INTO `role_permission` VALUES ('2', '6');
INSERT INTO `role_permission` VALUES ('2', '7');
INSERT INTO `role_permission` VALUES ('2', '9');
INSERT INTO `role_permission` VALUES ('1', '9');
INSERT INTO `role_permission` VALUES ('1', '10');
INSERT INTO `role_permission` VALUES ('3', '1');
INSERT INTO `role_permission` VALUES ('3', '2');
INSERT INTO `role_permission` VALUES ('3', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `idNumber` varchar(255) DEFAULT NULL,
  `career` varchar(255) DEFAULT NULL,
  `inTime` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', null, null, null, null, null, null, null, null, '0');
INSERT INTO `user` VALUES ('2', 'aaa', 'aaa', '男', '13831841566', '2020-03-03', '131121199704257415', '律师', '2020-03-04', '唐山幺零幺', 'wdwdwd', '管理员');
INSERT INTO `user` VALUES ('3', 'member1', '111', '男', '15987462155', '2020-03-11', '131121199704257415', '厨师', '2020-03-16', '唐山', null, '会员');
INSERT INTO `user` VALUES ('4', 'member2', '111', '女', '15987462154', '2020-03-31', '131121199704257415', '老司机', '2020-03-27', '唐山远洋城', null, '会员');
INSERT INTO `user` VALUES ('7', 'wdk', '111111', '男', '53453453', '2020-03-10', '4534534535', '34534', '2020-03-07', '3453', '5345345', '会员');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '2');
INSERT INTO `user_role` VALUES ('3', '3');
INSERT INTO `user_role` VALUES ('4', '3');
INSERT INTO `user_role` VALUES ('7', '3');
INSERT INTO `user_role` VALUES ('3', '1');
INSERT INTO `user_role` VALUES ('3', '2');
INSERT INTO `user_role` VALUES ('3', '3');
INSERT INTO `user_role` VALUES ('3', '4');
INSERT INTO `user_role` VALUES ('3', '1');
INSERT INTO `user_role` VALUES ('3', '2');
INSERT INTO `user_role` VALUES ('3', '3');
INSERT INTO `user_role` VALUES ('3', '1');
INSERT INTO `user_role` VALUES ('3', '2');
INSERT INTO `user_role` VALUES ('3', '3');
