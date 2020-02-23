drop table t_order if exists;

CREATE TABLE `t_order` (
  `id` varchar(40) NOT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `last_modified_by` varchar(45) DEFAULT NULL,
  `last_modified_at` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `deleted` decimal(1,0) DEFAULT '0',
  `area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID1','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'hangzhou');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID10','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'Shanghai');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID11','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'hangzhou');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID12','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'Shanghai');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID13','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'hangzhou');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID14','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'Shanghai');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID15','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'hangzhou');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID16','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'Shanghai');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID17','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'hangzhou');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID18','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'Shanghai');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID19','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'hangzhou');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID2','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'Shanghai');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID3','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'hangzhou');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID4','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'Shanghai');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID5','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'hangzhou');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID6','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'Shanghai');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID7','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'hangzhou');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID8','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'Shanghai');
INSERT INTO `t_order` (`id`,`created_by`,`created_at`,`last_modified_by`,`last_modified_at`,`version`,`deleted`,`area`) VALUES ('ID9','admin','2020-02-04 00:38:27','admin','2020-02-04 00:38:27',0,0,'hangzhou');
