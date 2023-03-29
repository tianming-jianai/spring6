CREATE TABLE t_emp
(
    id   int(11) NOT NULL AUTO_INCREMENT,
    name varchar(20) DEFAULT NULL COMMENT '姓名',
    age  int(11)     DEFAULT NULL COMMENT '年龄',
    sex  varchar(2)  DEFAULT NULL COMMENT '性别',
    PRIMARY KEY (id)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4;


INSERT INTO t_emp
VALUES (NULL, ?, ?, ?);

UPDATE t_emp
SET name=?
WHERE id = ?;

DELETE
FROM t_emp
WHERE id = ?;

SELECT *
FROM t_emp
WHERE id = ?;

-- 事务

CREATE TABLE t_book
(
    book_id   int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    book_name varchar(20)      DEFAULT NULL COMMENT '图书名称',
    price     int(11)          DEFAULT NULL COMMENT '价格',
    stock     int(10) UNSIGNED DEFAULT NULL COMMENT '库存（无符号）',
    PRIMARY KEY (book_id)
) ENGINE = INNODB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE t_user
(
    user_id  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    username varchar(20)      DEFAULT NULL COMMENT '用户名',
    balance  int(10) UNSIGNED DEFAULT NULL COMMENT '余额（无符号）',
    PRIMARY KEY (user_id)
) ENGINE = INNODB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4;