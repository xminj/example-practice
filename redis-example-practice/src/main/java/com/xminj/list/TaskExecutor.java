package com.xminj.list;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class TaskExecutor {

    private final RedisTaskQueue redisTaskQueue;


    @Scheduled(fixedRate = 5000)
    public void executeTasks() {
        String task = redisTaskQueue.getTask();
        if (StringUtils.hasLength(task)) {
            System.out.println(task);
            // 任务执行，可以配合监听器模式，实现不同任务有不同的处理类。避免过长的if else语句
        }
    }
}
