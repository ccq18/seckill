package org.seckill.entity;

import java.util.Date;

/**
 * Created by mac on 2017/4/26.
 */
/*
 `seckill_id` bigint NOT NULL   COMMENT '商品库存id',
    `user_phone` varchar(120) NOT NULL   COMMENT '用户手机号',
    `state` tinyint NOT NULL   COMMENT '状态：-1 无效 0 成功 1 已付款 2 已发货',
    `create_time` timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 */
public class SuccessKilled {

    private long seckillId;
    private long userPhone;
    private short state;

    private Date createTime;

    private Seckill seckill;

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
