DROP PROCEDURE IF EXISTS seckill.execute_seckill;
DELIMITER $$ -- 修改sql分隔符
CREATE PROCEDURE `seckill`.`execute_seckill`(
    IN  v_seckill_id BIGINT,
    IN  v_phone      BIGINT,
    IN  v_kill_time  TIMESTAMP,
    OUT r_result     INT
  )
  BEGIN
    DECLARE insert_count INT DEFAULT 0;
    START TRANSACTION;
    INSERT IGNORE INTO success_killed (seckill_id, user_phone, create_time)
    VALUES (v_seckill_id, v_phone, v_kill_time);
    SELECT ROW_COUNT() INTO insert_count;
    IF (insert_count = 0) THEN
      ROLLBACK;
      SET r_result = -1;
    ELSEIF (insert_count < 0)THEN
      ROLLBACK;
      SET r_result = -2;
    ELSE
      UPDATE seckill
      SET number = number - 1
      WHERE seckill_id = v_seckill_id
            AND start_time <= v_kill_time
            AND end_time >= v_kill_time
            AND number > 0;
      SELECT ROW_COUNT() INTO insert_count;
      IF (insert_count = 0) THEN
        ROLLBACK;
        SET r_result = -1;
      ELSEIF (insert_count < 0) THEN
        ROLLBACK;
        SET r_result = -2;
      ELSE
        COMMIT;
        SET r_result = 1;
      END IF;
    END IF;
  END;
$$
-- 存储过程结束
DELIMITER ; -- 还原sql分隔符 为 ;

-- 显示定义的存储过程
SHOW CREATE PROCEDURE execute_seckill\G;
-- 调用
SET @r_result = -3;
CALL execute_seckill(1000, 13333, now(), @r_result);
SELECT @r_result;
