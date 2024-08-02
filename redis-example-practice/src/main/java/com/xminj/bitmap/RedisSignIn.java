package com.xminj.bitmap;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RedisSignIn {
    private final static String SIGN_IN_KEY_PREFIX = "user:signIn:";
    private final RedisTemplate<String, Object> redisTemplate;


    /**
     * 用户签到
     *
     * @param userId 用户Id
     * @param day    当天时当年的第几天（1-365/366）
     */
    public void signIn(String userId, int day) {
        String key = SIGN_IN_KEY_PREFIX + userId;
        redisTemplate.opsForValue().setBit(key, day, true);
    }

    /**
     * 检查用户是否在某天签到
     *
     * @param userId 用户ID
     * @param day    当天是当年的第几天 (1 - 365/366)
     * @return 是否签到
     */
    public boolean checkSignIn(String userId, int day) {
        String key = SIGN_IN_KEY_PREFIX + userId;
        Boolean signedIn = redisTemplate.opsForValue().getBit(key, day);
        return Objects.nonNull(signedIn) && signedIn;
    }


    /**
     * 计算用户累计签到天数
     *
     * @param userId 用户ID
     * @return 签到天数
     */
    public long countSignInDays(String userId) {
        String key = SIGN_IN_KEY_PREFIX + userId;
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitPos(key.getBytes(StandardCharsets.UTF_8), Boolean.TRUE));
    }
}
