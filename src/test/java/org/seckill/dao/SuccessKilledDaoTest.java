package org.seckill.dao;

/**
 *
 */

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Administrator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successkilledDao;

    /**
     * Test method for {@link org.seckill.dao.SuccessKilledDao#insertSuccessKilled(long, long)}.
     */
    @Test
    public void testInsertSuccessKilled() {
        long seckillId = 1001L;
        long userPhone = 13502181181L;
        int insertCount = successkilledDao.insertSuccessKilled(seckillId, userPhone);
        System.out.println("insertCount=" + insertCount);

    }

    /**
     * Test method for {@link org.seckill.dao.SuccessKilledDao#queryByIdWithSeckill(long)}.
     */
    @Test
    public void testQueryByIdWithSeckill() {
        long seckillId = 1001L;
        long userPhone = 13502181181L;
        SuccessKilled successkilled = successkilledDao.queryByIdWithSeckill(seckillId, userPhone);
        System.out.println(successkilled);
        System.out.println(successkilled.getSeckill());
    }
}
