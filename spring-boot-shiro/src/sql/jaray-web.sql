/*
Navicat MySQL Data Transfer

Source Server         : Jaray
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : jaray-web

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-28 00:04:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `ID` varchar(255) DEFAULT NULL COMMENT '编号',
  `KYD` varchar(255) DEFAULT NULL COMMENT '可用的',
  `XM` varchar(255) DEFAULT NULL COMMENT '姓名',
  `FID` varchar(255) DEFAULT NULL COMMENT '父编号',
  `QX` varchar(255) DEFAULT NULL COMMENT '权限',
  `ZYLX` varchar(255) DEFAULT NULL COMMENT '资源类型',
  `URL` varchar(255) DEFAULT NULL COMMENT 'URL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '0', '用户管理', '0/', 'userInfo:view', 'menu', 'userInfo/userList');
INSERT INTO `sys_permission` VALUES ('2', '0', '用户添加', '0/1', 'userInfo:add', 'button', 'userInfo/userAdd');
INSERT INTO `sys_permission` VALUES ('3', '0', '用户删除', '0/1', 'userInfo:del', 'button', 'userInfo/userDel');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` varchar(255) DEFAULT NULL COMMENT '角色编号',
  `KYD` varchar(255) DEFAULT NULL COMMENT '可用的',
  `MS` varchar(255) DEFAULT NULL COMMENT '描述',
  `JS` varchar(255) DEFAULT NULL COMMENT '角色'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '0', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('2', '0', 'VIP会员', 'vip');
INSERT INTO `sys_role` VALUES ('3', '1', 'test', 'test');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `PID` varchar(255) DEFAULT NULL COMMENT '权限编号',
  `RID` varchar(255) DEFAULT NULL COMMENT '角色编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('3', '2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `RID` varchar(255) DEFAULT NULL COMMENT '角色编号',
  `UID` varchar(255) DEFAULT NULL COMMENT '用户编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for table_user
-- ----------------------------
DROP TABLE IF EXISTS `table_user`;
CREATE TABLE `table_user` (
  `BH` varchar(255) DEFAULT NULL,
  `XM` varchar(255) DEFAULT NULL,
  `SFZ` varchar(255) DEFAULT NULL,
  `NL` varchar(255) DEFAULT NULL,
  `MM` varchar(255) DEFAULT NULL,
  `SJH` varchar(255) DEFAULT NULL,
  `JTZZ` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_user
-- ----------------------------
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '8');
INSERT INTO `table_user` VALUES ('2', '3', '4', '5', '6', '7', '8');
INSERT INTO `table_user` VALUES ('3', '4', '5', '6', '7', '8', '9');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');
INSERT INTO `table_user` VALUES ('1', '2', '3', '4', '5', '6', '7');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `UID` varchar(255) DEFAULT NULL COMMENT '编号',
  `XM` varchar(255) DEFAULT NULL COMMENT '姓名',
  `YHM` varchar(255) DEFAULT NULL COMMENT '用户名',
  `MM` varchar(255) DEFAULT NULL COMMENT '密码',
  `YZ` varchar(255) DEFAULT NULL COMMENT '盐值',
  `ZT` varchar(255) DEFAULT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0');
