CREATE TABLE t_emp
(
    id   int(11) NOT NULL auto_increment,
    name varchar(20) DEFAULT NULL COMMENT '姓名',
    age  int(11) DEFAULT NULL COMMENT '年龄',
    sex  varchar(2)  DEFAULT NULL COMMENT '性别',
    PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;
