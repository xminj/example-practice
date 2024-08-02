package com.xminj.hash;

import com.xminj.entity.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class RedisObject {
    private final static String user_key = "user";

    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, User> hashOperations;

    @PostConstruct
    public void init() {
        hashOperations = redisTemplate.opsForHash();
    }


    public void saveUser(User user) {
        hashOperations.put(user_key, user.getId(), user);
    }

    public User findUserById(Long id) {
        return hashOperations.get(user_key, id);
    }

    public Map<Long, User> findAllUsers() {
        return hashOperations.entries(user_key);
    }

    public void deleteUser(Long id) {
        hashOperations.delete(user_key, id);
    }
}