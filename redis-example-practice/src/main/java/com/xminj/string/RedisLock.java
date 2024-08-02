package com.xminj.string;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedisLock {
    private final StringRedisTemplate redisTemplate;

    /**
     * 分布式锁命令：SETNX：只有key不存在时设置key的值
     */
    public boolean tryLock(String key, String value, long timeout, TimeUnit unit) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
        return Objects.nonNull(success) && success;
    }


    public void unlock(String key, String value) {
        String currentValue = redisTemplate.opsForValue().get(key);
        if (Objects.nonNull(currentValue) && Objects.equals(value, currentValue)) {
            redisTemplate.delete(key);
        }
    }
}
