package com.xminj.list;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisTaskQueue {
    private final static String task_key = "task_queue";

    private final RedisTemplate<String, Object> redisTemplate;
    private ListOperations<String, Object> listOperations;


    @PostConstruct
    private void init() {
        listOperations = redisTemplate.opsForList();
    }

    public void addTask(String task) {
        listOperations.rightPush(task_key, task);
    }

    public String getTask() {
        return (String) listOperations.rightPop(task_key);
    }
}