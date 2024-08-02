package com.xminj.list;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisMessageQueue {
    private final static String queue_key = "message_queue";
    private final RedisTemplate<String, Object> redisTemplate;

    private ListOperations<String, Object> listOperations;

    @PostConstruct
    private void init() {
        listOperations = redisTemplate.opsForList();
    }


    public void enqueueMessage(String message) {
        listOperations.rightPush(queue_key, message);
    }

    public Object dequeueMessage() {
        return listOperations.leftPop(queue_key);
    }
}
