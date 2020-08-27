CREATE TABLE `adjust_salary` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `as_date` date DEFAULT NULL COMMENT '调薪日期',
  `before_salary` int DEFAULT NULL COMMENT '调前薪资',
  `after_salary` int DEFAULT NULL COMMENT '调后薪资',
  `reason` varchar(255) DEFAULT NULL COMMENT '调薪原因',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
);