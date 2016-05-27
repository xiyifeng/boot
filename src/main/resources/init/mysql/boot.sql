/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-05-27 10:20:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for h_fmt_code
-- ----------------------------
DROP TABLE IF EXISTS `h_fmt_code`;
CREATE TABLE `h_fmt_code` (
  `uuid` varchar(40) NOT NULL,
  `tranCode` varchar(40) NOT NULL,
  `msgSeq` int(11) NOT NULL,
  `requestTime` varchar(20) DEFAULT NULL,
  `responseTime` varchar(20) DEFAULT NULL,
  `status` varchar(2) NOT NULL,
  `diffCode` varchar(1) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_fmt_code
-- ----------------------------
INSERT INTO `h_fmt_code` VALUES ('11110', '1001', '1', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11111', '1001', '2', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11112', '1001', '3', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11113', '1001', '4', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11114', '1001', '5', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11115', '1001', '6', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11116', '1001', '7', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11117', '1001', '8', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11118', '1001', '9', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11119', '1001', '10', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11121', '1001', '11', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('11122', '1001', '12', '10101010', '100101011', '1', '1');
INSERT INTO `h_fmt_code` VALUES ('22222', '1001', '13', '10101010', '100101011', '1', '1');

-- ----------------------------
-- Table structure for h_right
-- ----------------------------
DROP TABLE IF EXISTS `h_right`;
CREATE TABLE `h_right` (
  `right_id` int(11) NOT NULL COMMENT '角色代码',
  `right_name` varchar(100) NOT NULL COMMENT '角色名称',
  `super_right_id` int(11) NOT NULL COMMENT '上级目录代码(为0时，表示主目录)',
  `super_right_name` varchar(100) DEFAULT NULL COMMENT '父节点名称',
  `sort` int(11) DEFAULT NULL COMMENT '顺序号',
  `right_type` varchar(2) NOT NULL COMMENT '权限类型(1-目录 2-交易)',
  `icon_cls` varchar(30) DEFAULT NULL COMMENT '目录显示图标',
  `url` varchar(300) DEFAULT NULL COMMENT 'URL连接',
  `status` varchar(2) DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `creater` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `modifyer` varchar(30) DEFAULT NULL COMMENT '修改人',
  `modify_time` varchar(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`right_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_right
-- ----------------------------

-- ----------------------------
-- Table structure for h_role
-- ----------------------------
DROP TABLE IF EXISTS `h_role`;
CREATE TABLE `h_role` (
  `roleCode` int(11) NOT NULL COMMENT '角色代码',
  `roleName` varchar(100) NOT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '角色说明',
  `creater` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `modifyer` varchar(30) DEFAULT NULL COMMENT '修改人',
  `modify_time` varchar(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`roleCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_role
-- ----------------------------

-- ----------------------------
-- Table structure for h_role_right
-- ----------------------------
DROP TABLE IF EXISTS `h_role_right`;
CREATE TABLE `h_role_right` (
  `role_code` int(11) NOT NULL COMMENT '角色代码',
  `right_id` int(11) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_role_right
-- ----------------------------

-- ----------------------------
-- Table structure for h_user
-- ----------------------------
DROP TABLE IF EXISTS `h_user`;
CREATE TABLE `h_user` (
  `user_code` varchar(30) NOT NULL COMMENT '用户代码',
  `user_name` varchar(100) NOT NULL COMMENT '用户名称',
  `password` varchar(250) NOT NULL COMMENT '密码',
  `position` varchar(50) DEFAULT NULL COMMENT '职位',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `mobil_phone` varchar(20) DEFAULT NULL COMMENT '移动号码',
  `status` varchar(2) NOT NULL COMMENT '状态(1-正常 2-锁定 3-失效)',
  `lang` varchar(20) DEFAULT NULL COMMENT '语言',
  `theme` varchar(20) DEFAULT NULL COMMENT '主题',
  `error_login_times` int(11) DEFAULT NULL COMMENT '登陆错误连续失败次数',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_user
-- ----------------------------

-- ----------------------------
-- Table structure for h_user_role
-- ----------------------------
DROP TABLE IF EXISTS `h_user_role`;
CREATE TABLE `h_user_role` (
  `user_code` varchar(30) DEFAULT NULL COMMENT '用户代码',
  `role_code` varchar(30) DEFAULT NULL COMMENT '角色代码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h_user_role
-- ----------------------------
