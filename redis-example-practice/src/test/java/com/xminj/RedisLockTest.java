package com.xminj;

import com.xminj.string.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
public class RedisLockTest {

    @Autowired
    public RedisLock redisLock;


    @Test
    void lock() {
        boolean lock = redisLock.tryLock("lock", "user_lock", 5, TimeUnit.MINUTES);
        if (lock) {
            new Thread(() -> {
                while (true) {
                    boolean syncLock = redisLock.tryLock("lock", "user_lock", 5, TimeUnit.MINUTES);
                    if (!syncLock) {
                        log.info("获取锁失败");
                        try {
                            TimeUnit.MILLISECONDS.sleep(1000);
                        } catch (InterruptedException e) {
                            redisLock.unlock("lock", "user_lock");
                        }
                    } else {
                        return;
                    }
                }
            }).start();
        }
    }
}