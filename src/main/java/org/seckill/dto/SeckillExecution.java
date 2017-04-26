package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

/**
 * Created by mac on 2017/4/26.
 */
public class SeckillExecution {
    private long SeckillId;
    private int state;
    private String stateInfo;
    private SuccessKilled successKilled;

    public SeckillExecution(long seckillId, SeckillStatEnum state) {
        SeckillId = seckillId;
        this.state = state.getState();
        this.stateInfo = state.getInfo();
    }

    public SeckillExecution(long seckillId, SeckillStatEnum state, SuccessKilled successKilled) {
        SeckillId = seckillId;
        this.state = state.getState();
        this.stateInfo = state.getInfo();
        this.successKilled = successKilled;
    }

    public long getSeckillId() {
        return SeckillId;
    }

    public void setSeckillId(long seckillId) {
        SeckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
