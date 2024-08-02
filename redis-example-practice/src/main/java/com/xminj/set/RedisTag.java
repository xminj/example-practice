package com.xminj.set;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class RedisTag {
    private final static String tag_key = "tag:";
    private final RedisTemplate<String, Object> redisTemplate;
    private SetOperations<String, Object> setOperations;

    @PostConstruct
    private void init() {
        setOperations = redisTemplate.opsForSet();
    }

    public void addTag(String entityId, String tag) {
        String key = tag_key + entityId;
        setOperations.add(key, tag);
    }

    public Set<Object> getTags(String entityId) {
        String key = tag_key + entityId;
        return setOperations.members(key);
    }

    public void removeTag(String entityId, String tag) {
        String key = tag_key + entityId;
        setOperations.remove(key, tag);
    }

    public Set<Object> getCommonTags(String entityId1, String entityId2) {
        String key1 = tag_key + entityId1;
        String key2 = tag_key + entityId2;
        return setOperations.intersect(key1, key2);
    }
}