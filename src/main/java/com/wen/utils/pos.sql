/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : pos

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-11-16 17:09:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '信息id',
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `account` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '微信公众号',
  `content` varchar(10000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '内容',
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片链接',
  `like_count` int(10) DEFAULT NULL COMMENT '喜欢',
  `comment_count` int(10) DEFAULT NULL COMMENT '评论',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `user_id` int(10) DEFAULT '1' COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_crm_member
-- ----------------------------
DROP TABLE IF EXISTS `t_crm_member`;
CREATE TABLE `t_crm_member` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT '123456' COMMENT '密码',
  `sex` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT '123456' COMMENT '地址',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `idcard` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `resume` varchar(10000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '个人简介',
  `photo` varchar(10000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '照片',
  `state` tinyint(1) DEFAULT '1' COMMENT '状态 1:正常 2:禁用 0:删除',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=211 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `mname` varchar(255) DEFAULT NULL COMMENT '权限名',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for t_module_role
-- ----------------------------
DROP TABLE IF EXISTS `t_module_role`;
CREATE TABLE `t_module_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `mid` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `mid` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='权限-角色中间表';

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `u_fk` (`uid`),
  KEY `r_fk` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

-- ----------------------------
-- Procedure structure for removeReturnNums
-- ----------------------------
DROP PROCEDURE IF EXISTS `removeReturnNums`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `removeReturnNums`(IN `n_id` int,OUT `nums` int)
BEGIN
	DELETE FROM news WHERE id = n_id;
  SELECT COUNT(id) FROM news INTO nums;

END
;;
DELIMITER ;
