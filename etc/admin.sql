/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-15 15:27:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data` (
  `num` int(50) NOT NULL AUTO_INCREMENT,
  `introduce` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES ('1', 'test', 'this is the test!~~~');
INSERT INTO `data` VALUES ('12', 'this is test', 'fuck');
INSERT INTO `data` VALUES ('13', 'tmep', 'temptmemtej');
INSERT INTO `data` VALUES ('14', '关于', 'joke');
INSERT INTO `data` VALUES ('15', '介绍', '脚本');
INSERT INTO `data` VALUES ('16', 'long', '123456781212121212123424323dewdfsfwegferfaedfsdafjowekfopwe[kmdsglkerhgfksdmgfjerigndsfm,;kdowekqflkejkldjnsgkdfhjiogjrelgk\'lf[lewqgjdjng0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000');
INSERT INTO `data` VALUES ('17', 'fd', 'fdfd');
INSERT INTO `data` VALUES ('18', 'safd', 'fasdfsaf');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(50) NOT NULL,
  `label` varchar(20) NOT NULL,
  `path` varchar(200) DEFAULT '0',
  `order` smallint(6) DEFAULT '1',
  `level` smallint(6) DEFAULT '1' COMMENT '层级，方便根据层级查询',
  `url` varchar(200) DEFAULT NULL,
  `type` smallint(6) DEFAULT '1' COMMENT '扩展不同菜单时用',
  `style` varchar(50) DEFAULT NULL COMMENT 'ui 样式',
  `disabled` smallint(6) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('data', '数据处理', '0,system', '4', '2', '/data', '1', null, '0');
INSERT INTO `menu` VALUES ('graph', '数据展示', '0,system', '10', '2', '/graph', '1', null, '0');
INSERT INTO `menu` VALUES ('menu', '菜单管理', '0,system', '2', '1', '/menu', '1', null, '0');
INSERT INTO `menu` VALUES ('role', '角色管理', '0,system', '3', '3', '/role', '1', null, '0');
INSERT INTO `menu` VALUES ('show', '脚本展示', '0,system', '6', '2', '/show', '0', null, '0');
INSERT INTO `menu` VALUES ('system', '系统管理', '0', '1', '1', '', '1', null, '0');
INSERT INTO `menu` VALUES ('user', '用户管理', '0,system', '3', '2', '/user', '0', null, '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(30) NOT NULL COMMENT '角色',
  `disabled` smallint(6) NOT NULL DEFAULT '0',
  `description` varchar(60) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `rolename` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '0', '管理员');
INSERT INTO `role` VALUES ('f1d07c8f-57e9-4e00-a03f-348a96cd54e2', 'user', '0', '普通用户');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` varchar(50) DEFAULT NULL,
  `menu_id` varchar(50) DEFAULT NULL,
  KEY `role_id_rm` (`role_id`),
  KEY `menu_code_rm` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', 'menu');
INSERT INTO `role_menu` VALUES ('1', 'role');
INSERT INTO `role_menu` VALUES ('1', 'system');
INSERT INTO `role_menu` VALUES ('1', 'user');
INSERT INTO `role_menu` VALUES ('f1d07c8f-57e9-4e00-a03f-348a96cd54e2', 'menu');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `username` varchar(20) NOT NULL COMMENT '登录名称',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `salt` varchar(50) DEFAULT '0' COMMENT '密码的盐',
  `disabled` smallint(6) NOT NULL DEFAULT '1' COMMENT '0、禁用 1、正常',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `lastTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginname` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('09f8a6d4-93c8-459e-935e-a0c58cc8e9ba', 'e', '5a561f39fe104d53748c88b9172dbea7', 'e@gmial.com', 'W2Cc]~M0oF', '0', '2017-11-14 08:28:29', null);
INSERT INTO `user` VALUES ('1', 'root', '5442b02dabc5ed9401be4dfe1ca8adb9', 'jonsychen@hotmail.com', 'r', '0', '2016-09-27 19:53:20', '2016-09-27 19:53:22');
INSERT INTO `user` VALUES ('56c7743f-575a-477b-bde7-798a8e2aac25', 'lll3', 'f5eb142c9ae081fa846787f681b487ff', 'lll3@gmail.com', 'SlvmLhe`C5', '0', '2017-11-09 13:55:27', null);
INSERT INTO `user` VALUES ('71da3fc5-76fd-4ca3-83ea-6a7279f7f1a1', 'lll4', '62f378965d9a57f876abcfd020b406b9', 'lll4@gmail.com', '_BJ(Z^KeVC', '1', '2017-11-09 14:50:28', null);
INSERT INTO `user` VALUES ('794bf2c2-9634-4585-975c-bd67892a7373', 'jk1', '98271fe6b5b1cc7f58a56429702af6b6', 'jk1@gmail.com', 'q=Wjo0-J8B', '0', '2017-11-09 14:56:34', null);
INSERT INTO `user` VALUES ('826d61dc-e39c-4a04-92c5-83300a36d3df', 'gg', '894f541c1a6a104b260f4b728469938e', 'gg@gmail.com', 's[T\"(k&ohD', '0', '2017-11-13 16:42:39', null);
INSERT INTO `user` VALUES ('8891e12f-81a7-43cd-8ab8-4accdf141f96', 'jonsy', '2e9ca4d0b1a586fd80bc2ba782ac36bc', 'jonsychen@hotmail.com', '0', '0', '2016-10-31 21:16:47', null);
INSERT INTO `user` VALUES ('89b38187-2654-45b8-b824-f892b5d42a07', 'lll2', 'e773e6fa1430c1a9141a7a17a25bef66', 'lll2@gmial.com', 'M)DA]$]XNp', '0', '2017-11-09 10:14:53', null);
INSERT INTO `user` VALUES ('c42d7006-fece-4eca-9643-b6a813c2795f', 'lll', '796042edc18d6b77720bcc0ab585a17e', 'lllbupt@gmail.com', '$koKw*]/:%', '0', '2017-11-09 10:14:04', null);
INSERT INTO `user` VALUES ('d65b3446-1627-46ef-9847-7cf51264e179', 'jj', '0e56525f714754a79b583379d13fe4ca', 'jj@gmail.com', '3`d[{W~Jn1', '0', '2017-11-09 15:03:54', null);
INSERT INTO `user` VALUES ('f9a66242-4758-4f49-9f26-7ca024b63305', 'ok', '2fbfca5b674721656fa5deb9803c19ed', 'ok@gmail.com', 's:%E2!z5L|', '1', '2017-11-09 15:11:16', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` varchar(50) NOT NULL,
  `role_id` varchar(50) NOT NULL,
  KEY `uid` (`uid`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('8891e12f-81a7-43cd-8ab8-4accdf141f96', '1');
