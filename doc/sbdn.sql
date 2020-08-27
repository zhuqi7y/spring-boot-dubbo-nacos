create database sbdn;
create user 'sbdn'@'localhost' IDENTIFIED BY '123456';
grant all on sbdn.* to 'sbdn'@'localhost';

CREATE TABLE `sys_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `href` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `parent` int(11) NOT NULL DEFAULT '0',
  `level` int(2) NOT NULL DEFAULT '1',
  `type` int(2) NOT NULL DEFAULT '3',
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `add_userid` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_userid` int(11) DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  `delete_userid` int(11) DEFAULT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

INSERT INTO `sbdn`.`sys_info`(`id`, `title`, `href`, `image`, `icon`, `target`, `parent`, `level`, `type`, `add_time`, `add_userid`, `update_time`, `update_userid`, `delete_time`, `delete_userid`, `enabled`) VALUES (1, '首页', '/page/sys/welcome', NULL, NULL, NULL, 0, 1, 1, '2020-08-20 08:58:04', 1, NULL, NULL, NULL, NULL, b'1');
INSERT INTO `sbdn`.`sys_info`(`id`, `title`, `href`, `image`, `icon`, `target`, `parent`, `level`, `type`, `add_time`, `add_userid`, `update_time`, `update_userid`, `delete_time`, `delete_userid`, `enabled`) VALUES (2, 'LAYUI MINI', NULL, '/page/images/logo.png', NULL, NULL, 0, 1, 2, '2020-08-20 08:58:34', 1, NULL, NULL, NULL, NULL, b'1');
INSERT INTO `sbdn`.`sys_info`(`id`, `title`, `href`, `image`, `icon`, `target`, `parent`, `level`, `type`, `add_time`, `add_userid`, `update_time`, `update_userid`, `delete_time`, `delete_userid`, `enabled`) VALUES (3, '常规管理', NULL, NULL, 'fa fa-address-book', '_self', 0, 1, 3, '2020-08-20 09:00:13', 1, NULL, NULL, NULL, NULL, b'1');
INSERT INTO `sbdn`.`sys_info`(`id`, `title`, `href`, `image`, `icon`, `target`, `parent`, `level`, `type`, `add_time`, `add_userid`, `update_time`, `update_userid`, `delete_time`, `delete_userid`, `enabled`) VALUES (4, '主页模板', NULL, NULL, 'fa fa-home', '_self', 3, 2, 3, '2020-08-20 09:05:12', 1, NULL, NULL, NULL, NULL, b'1');
INSERT INTO `sbdn`.`sys_info`(`id`, `title`, `href`, `image`, `icon`, `target`, `parent`, `level`, `type`, `add_time`, `add_userid`, `update_time`, `update_userid`, `delete_time`, `delete_userid`, `enabled`) VALUES (5, '主页', '/page/sys/welcome', NULL, 'fa fa-tachometer', '_self', 4, 3, 3, '2020-08-20 09:05:56', 1, NULL, NULL, NULL, NULL, b'1');
INSERT INTO `sbdn`.`sys_info`(`id`, `title`, `href`, `image`, `icon`, `target`, `parent`, `level`, `type`, `add_time`, `add_userid`, `update_time`, `update_userid`, `delete_time`, `delete_userid`, `enabled`) VALUES (6, '表单示例', NULL, NULL, 'fa fa-calendar', '_self', 3, 2, 3, '2020-08-20 09:08:33', 1, NULL, NULL, NULL, NULL, b'1');
INSERT INTO `sbdn`.`sys_info`(`id`, `title`, `href`, `image`, `icon`, `target`, `parent`, `level`, `type`, `add_time`, `add_userid`, `update_time`, `update_userid`, `delete_time`, `delete_userid`, `enabled`) VALUES (7, '普通表单', '/page/example/list', NULL, 'fa fa-list-alt', '_self', 6, 3, 3, '2020-08-20 09:08:57', 1, NULL, NULL, NULL, NULL, b'1');

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `real_password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `add_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `remark` varchar(255) DEFAULT NULL,
  `orderby` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name_uniq` (`login_name`),
  UNIQUE KEY `phone_uniq` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `sbdn`.`sys_user`(`id`, `login_name`, `password`, `real_password`, `user_name`, `phone`, `last_login_time`, `add_time`, `update_time`, `delete_time`, `enabled`, `remark`, `orderby`) VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'admin', '18888888888', NULL, '2020-08-20 16:49:38', NULL, NULL, b'1', NULL, NULL);
INSERT INTO `sbdn`.`sys_user`(`id`, `login_name`, `password`, `real_password`, `user_name`, `phone`, `last_login_time`, `add_time`, `update_time`, `delete_time`, `enabled`, `remark`, `orderby`) VALUES (2, 'zhuqi', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'zhuqi', '18888888881', NULL, '2020-08-20 16:56:43', NULL, NULL, b'1', NULL, NULL);

CREATE TABLE `example` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `add_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `orderby` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (1, '标题1', 2, '内容1', '2020-08-03 15:34:17', '2020-08-27 10:03:41', NULL, b'1', '备注1', 1);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (2, '标题2', 1, '内容2', '2020-08-04 16:49:25', '2020-08-27 10:03:47', NULL, b'1', NULL, 2);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (3, '标题3', 3, '内容3', '2020-08-04 16:49:27', '2020-08-27 10:03:50', NULL, b'1', NULL, 3);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (4, '标题4', 1, '内容4', '2020-08-26 11:21:08', '2020-08-27 10:05:14', '2020-08-26 14:18:14', b'1', NULL, 4);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (5, '标题5', 3, '内容5', '2020-08-26 11:24:46', '2020-08-27 10:05:36', '2020-08-26 14:18:14', b'1', NULL, 5);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (6, '标题6', 1, '内容6', '2020-08-26 11:27:55', '2020-08-27 10:05:38', '2020-08-26 11:47:38', b'1', NULL, 6);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (7, '标题7', 1, '内容7', '2020-08-26 11:32:47', '2020-08-27 10:05:40', '2020-08-26 14:19:43', b'1', NULL, 7);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (8, '标题8', 3, '内容8', '2020-08-26 11:40:54', '2020-08-27 10:05:42', '2020-08-26 14:19:43', b'1', NULL, 8);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (9, '标题9', 2, '内容9', '2020-08-26 15:31:22', '2020-08-27 10:05:43', NULL, b'1', NULL, 9);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (10, '标题10', 1, '内容10', '2020-08-26 15:31:27', '2020-08-27 10:05:46', NULL, b'1', NULL, 10);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (11, '标题11', 1, '内容11', '2020-08-26 15:31:38', '2020-08-27 10:05:48', NULL, b'1', NULL, 11);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (12, '标题12', 1, '内容12', '2020-08-26 15:31:52', '2020-08-27 10:05:50', NULL, b'1', NULL, 12);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (13, '标题13', 1, '内容13', '2020-08-26 15:31:56', '2020-08-27 10:05:53', NULL, b'1', NULL, 13);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (14, '标题14', 1, '内容14', '2020-08-26 15:32:00', '2020-08-27 10:05:55', NULL, b'1', NULL, 14);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (15, '标题15', 1, '内容15', '2020-08-26 15:32:05', '2020-08-27 10:05:59', NULL, b'1', NULL, 15);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (16, '标题16', 2, '内容16', '2020-08-26 15:32:13', '2020-08-27 10:05:30', NULL, b'1', NULL, 16);
INSERT INTO `sbdn`.`example`(`id`, `title`, `type`, `content`, `addTime`, `updateTime`, `deleteTime`, `enabled`, `remark`, `orderby`) VALUES (17, '标题17', 1, '内容17', '2020-08-26 15:54:36', '2020-08-27 10:05:33', NULL, b'1', NULL, 17);
