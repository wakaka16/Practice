/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-08-22 13:08:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `pwd` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `logo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', null, null);
INSERT INTO `t_user` VALUES ('2', 'zs', null, null);
INSERT INTO `t_user` VALUES ('3', 'lisi', null, null);
INSERT INTO `t_user` VALUES ('4', 'hello', null, null);
INSERT INTO `t_user` VALUES ('5', 'wangwu', null, null);
INSERT INTO `t_user` VALUES ('6', '张三', null, null);
INSERT INTO `t_user` VALUES ('7', '张三', null, null);
INSERT INTO `t_user` VALUES ('8', '张三', null, null);
INSERT INTO `t_user` VALUES ('9', '张三', null, null);
INSERT INTO `t_user` VALUES ('10', '李白', null, null);
INSERT INTO `t_user` VALUES ('11', '二哈', null, null);
INSERT INTO `t_user` VALUES ('12', '二哈', null, null);
INSERT INTO `t_user` VALUES ('13', '二哈', null, null);
INSERT INTO `t_user` VALUES ('14', '二哈', null, null);
INSERT INTO `t_user` VALUES ('15', '二哈', null, 'Http://127.0.0.1:8001/default_logo.jpg');
INSERT INTO `t_user` VALUES ('16', '二哈', null, 'Http://127.0.0.1:8001/default_logo.jpg');
INSERT INTO `t_user` VALUES ('17', '二哈', null, 'Http://127.0.0.1:8001/file/demo/images/3f2b74c41c1847d49bf4952f4570fa651530796402797.png');
INSERT INTO `t_user` VALUES ('18', '二哈', null, 'null/default_logo.jpg');
INSERT INTO `t_user` VALUES ('19', '二哈', null, 'null/default_logo.jpg');
INSERT INTO `t_user` VALUES ('20', '二哈', null, 'http://192.168.136:8001/default_logo.jpg');
INSERT INTO `t_user` VALUES ('21', '注册', '123', 'http://192.168.136:8001/file/demo/images/0d2ef7c1a6d14fddb5b3e081351db3dc1530860696674.jpg');
INSERT INTO `t_user` VALUES ('22', '注册2', '123', 'http://192.168.136:8001/default_logo.jpg');
