package org.seckill.exception;

/**
 * Created by mac on 2017/4/26.
 */

public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {

        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
