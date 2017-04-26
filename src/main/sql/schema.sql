
CREATE database seckill;
USE seckill;
CREATE TABLE seckill(
    `seckill_id` bigint NOT NULL AUTO_INCREMENT  COMMENT '商品库存id',
    `name` varchar(120) NOT NULL   COMMENT '商品名称',
    `number` int NOT NULL   COMMENT '商品数量',
    `start_time` timestamp NOT NULL   COMMENT '秒杀开始时间',
    `end_time` timestamp NOT NULL   COMMENT '秒杀结束时间',
    `create_time` timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (seckill_id),
    key idx_start_time(start_time),
    key idx_end_time(end_time),
    key idx_create_time(create_time)

)
ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '秒杀库存表';
INSERT INTO seckill(name,number,start_time,end_time)VALUES
                    ('2500秒杀iphone6',100,'2017-04-23 00:00:00','2017-04-24 00:00:00'),
                    ('2000秒杀IPAD',200,'2017-04-23 00:00:00','2017-04-24 00:00:00'),
                    ('2000秒杀mi6',300,'2017-04-23 00:00:00','2017-04-24 00:00:00');


-- 秒杀成功明细表
CREATE TABLE success_killed(
    `seckill_id` bigint NOT NULL   COMMENT '商品库存id',
    `user_phone` varchar(120) NOT NULL   COMMENT '用户手机号',
    `state` tinyint NOT NULL   COMMENT '状态：-1 无效 0 成功 1 已付款 2 已发货',
    `create_time` timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (seckill_id,user_phone),
    key idx_create_time(create_time)

)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '秒杀明细';
-- 用户登录认证信息
CREATE TABLE user_login(
    `user_login_id` bigint NOT NULL AUTO_INCREMENT  COMMENT '商品库存id',
    `user_phone` varchar(120) NOT NULL   COMMENT '用户手机号',
    `create_time` timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (user_login_id),
    key idx_user_phone(user_phone),
    key idx_create_time(create_time)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '秒杀明细';

ALTER TABLE seckill DROP INDEX idx_create_time,ADD INDEX idx_c_s(create_time,start_time);