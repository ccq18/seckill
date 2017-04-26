package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;

import java.util.List;

/**
 * Created by mac on 2017/4/26.
 */
public interface SuccessKilledDao {
    /**
     *
     * @param seckillId
     * @param userPhone
     * @return
     * 插入的行数
     */
    int insertSuccessKilled(@Param("seckillId")long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId, @Param("userPhone") long userPhone);


}
