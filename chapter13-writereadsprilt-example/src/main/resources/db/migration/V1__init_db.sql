DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_date` date NOT NULL DEFAULT '1970-01-01',
  `to_date` date NOT NULL DEFAULT '1970-01-01',
  `product_id` bigint(20) NOT NULL DEFAULT '0',
  `product_name` varchar(100) NOT NULL DEFAULT '',
  `channel_id` bigint(20) NOT NULL DEFAULT '0',
  `channel_name` varchar(100) NOT NULL DEFAULT '',
  `settlement_type` tinyint(4) NOT NULL DEFAULT '0',
  `settlement_price` decimal(11,2) DEFAULT '0.00',
  `settlement_count` decimal(11,2) NOT NULL DEFAULT '0.00',
  `settlement_amount` decimal(11,2) NOT NULL DEFAULT '0.00',
  `summary_amount` decimal(11,2) NOT NULL DEFAULT '0.00',
  `tax_point` decimal(11,2) NOT NULL DEFAULT '0.00',
  `tax_amount` decimal(11,2) NOT NULL DEFAULT '0.00',
  `bill_status` tinyint(4) NOT NULL DEFAULT '1',
  `state` varchar(100) NOT NULL DEFAULT 'N',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `bill_detail`;
CREATE TABLE `bill_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `related_date` date NOT NULL DEFAULT '1970-01-01',
  `upstream_package_name` varchar(100) NOT NULL DEFAULT '',
  `product_id` bigint(20) NOT NULL DEFAULT '0',
  `product_name` varchar(100) NOT NULL DEFAULT '',
  `channel_id` bigint(20) NOT NULL DEFAULT '0',
  `channel_name` varchar(100) NOT NULL DEFAULT '',
  `settlement_type` tinyint(4) NOT NULL DEFAULT '0',
  `settlement_price` decimal(11,2) NOT NULL DEFAULT '0.00',
  `settlement_count` decimal(11,2) NOT NULL DEFAULT '0.00',
  `settlement_amount` decimal(11,2) NOT NULL DEFAULT '0.00',
  `tax_point` decimal(11,2) NOT NULL DEFAULT '0.00',
  `tax_amount` decimal(11,2) NOT NULL DEFAULT '0.00',
  `summary_amount` decimal(11,2) NOT NULL DEFAULT '0.00',
  `bill_id` bigint(20) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=581 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `bill_review_log`;
CREATE TABLE `bill_review_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bill_id` bigint(20) NOT NULL DEFAULT '0',
  `origin_status` tinyint(4) NOT NULL DEFAULT '1',
  `current_status` tinyint(4) NOT NULL DEFAULT '1',
  `operate_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `operate_user_account` varchar(100) NOT NULL DEFAULT '',
  `operate_user_name` varchar(100) NOT NULL DEFAULT '',
  `operate_reason` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;



