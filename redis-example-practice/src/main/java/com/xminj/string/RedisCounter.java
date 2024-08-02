package com.xminj.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCounter {
    private final String counter_key = "counter";
    private final StringRedisTemplate redisTemplate;


    @Autowired
    public RedisCounter(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        if (Boolean.FALSE.equals(redisTemplate.hasKey(counter_key))) {
            redisTemplate.opsForValue().set(counter_key, "0");
        }else {
            redisTemplate.opsForValue().set(counter_key, "0");
        }
    }

    /**
     * 将键的值加1
     */
    public void increment() {
        redisTemplate.opsForValue().increment(counter_key);
    }

    /**
     * 将键的值增加指定值
     *
     * @param value 指定值
     */
    public void incrementBy(int value) {
        redisTemplate.opsForValue().increment(counter_key, value);
    }


    /**
     * 将键的值减1
     */
    public void decrement() {
        redisTemplate.opsForValue().decrement(counter_key);
    }


    /**
     * 将键的值减指定值
     *
     * @param value 指定值
     */
    public void decrementBy(int value) {
        redisTemplate.opsForValue().decrement(counter_key, value);
    }


    public String get() {
        return redisTemplate.opsForValue().get(counter_key);
    }
}