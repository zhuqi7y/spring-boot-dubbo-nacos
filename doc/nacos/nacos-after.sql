#执行nacos\conf目录下nacos-mysql.sql文件之后，新建命名空间和权限
INSERT INTO `tenant_info`(`kp`, `tenant_id`, `tenant_name`, `tenant_desc`, `create_source`, `gmt_create`, `gmt_modified`)
VALUES ('1', 'dev', 'dev', '本地环境', 'nacos', 1595495517954, 1595495517954);
INSERT INTO `tenant_info`(`kp`, `tenant_id`, `tenant_name`, `tenant_desc`, `create_source`, `gmt_create`, `gmt_modified`)
VALUES ('1', 'test', 'test', '测试环境', 'nacos', 1595495517954, 1595495517954);
INSERT INTO `tenant_info`(`kp`, `tenant_id`, `tenant_name`, `tenant_desc`, `create_source`, `gmt_create`, `gmt_modified`)
VALUES ('1', 'prod', 'prod', '正式生产环境', 'nacos', 1595495517954, 1595495517954);

INSERT INTO `permissions`(`role`, `resource`, `action`) VALUES ('ROLE_ADMIN', ':*:*', 'rw');
INSERT INTO `permissions`(`role`, `resource`, `action`) VALUES ('ROLE_ADMIN', 'dev:*:*', 'rw');
INSERT INTO `permissions`(`role`, `resource`, `action`) VALUES ('ROLE_ADMIN', 'prod:*:*', 'rw');
INSERT INTO `permissions`(`role`, `resource`, `action`) VALUES ('ROLE_ADMIN', 'test:*:*', 'rw');
