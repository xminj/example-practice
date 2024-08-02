package com.xminj;

import com.xminj.string.RedisCounter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Objects;

@Slf4j
@SpringBootTest
public class RedisCounterTests {

    @Autowired
    private RedisCounter redisCounter;


    @Test
    void increment() {
        redisCounter.increment();
        String value_auto_increment = redisCounter.get();
        Assert.isTrue(!Objects.equals(value_auto_increment, "1"), "值错误");

        redisCounter.incrementBy(2);
        String value_specify_value = redisCounter.get();
        Assert.isTrue(!Objects.equals(value_specify_value, "2"), "值错误");
    }


    @Test
    void decrement() {
        redisCounter.incrementBy(3);
        redisCounter.decrement();
        String decreasing = redisCounter.get();
        Assert.isTrue(!Objects.equals(decreasing, "1"), "值错误");

        redisCounter.decrementBy(2);
        String value_specify_value = redisCounter.get();
        Assert.isTrue(!Objects.equals(decreasing, "0"), "值错误");
    }
}
