-- 参数配置表
CREATE TABLE `t_sys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `config_code` varchar(30) NOT NULL COMMENT '参数编号',
  `config_name` varchar(50) NOT NULL COMMENT '参数名称',
  `config_desc` varchar(300) DEFAULT '' COMMENT '参数描述',
  `busi_type` tinyint(4) DEFAULT '0' COMMENT '业务类型:1系统',
  `child_type` tinyint(4) DEFAULT '0' COMMENT '子业务类型',
  `config_type` tinyint(4) DEFAULT '1' COMMENT '参数类型 1:文本输入框 2:数字输入框',
  `config_vlaue` varchar(500) NOT NULL COMMENT '参数值',
  `config_default_value` varchar(500) DEFAULT '' COMMENT '参数默认值',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `create_user` varchar(50) DEFAULT '' COMMENT '创建人',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否有效 1:有效 2:无效',
  PRIMARY KEY (`id`),
  UNIQUE KEY `config_code` (`config_code`)
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='【系统】参数配置信息表';

-- 用户菜单表
CREATE TABLE `t_sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `menu_code` varchar(10) NOT NULL COMMENT '功能代号',
  `up_menu_code` varchar(10) NOT NULL COMMENT '上级功能代号',
  `channel_code` varchar(10) NOT NULL COMMENT '渠道',
  `menu_name` varchar(30) NOT NULL COMMENT '功能名称',
  `menu_desc` varchar(30) DEFAULT '' COMMENT '功能描述',
  `permission` varchar(100) DEFAULT '' COMMENT '权限',
  `is_active` tinyint(4) NOT NULL COMMENT '是否有效 1:有效 2:无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【系统】功能权限表';
