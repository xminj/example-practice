package com.xminj.sorted_set;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * redis 实现排行榜 zset数据结构
 */
@Component
@RequiredArgsConstructor
public class RedisLeaderboard {
    private final static String LEADERBOARD_KEY = "leaderboard";

    private final RedisTemplate<String, Object> redisTemplate;
    private ZSetOperations<String, Object> zSetOperations;

    @PostConstruct
    private void init() {
        zSetOperations = redisTemplate.opsForZSet();
    }


    public void addScore(String player, double score) {
        zSetOperations.add(LEADERBOARD_KEY, player, score);
    }

    /**
     * 获取topN的运动员
     *
     * @param topN topN
     */
    public Set<ZSetOperations.TypedTuple<Object>> getTopPlayers(int topN) {
        return zSetOperations.reverseRangeWithScores(LEADERBOARD_KEY, 0, topN - 1);
    }

    public Set<ZSetOperations.TypedTuple<Object>> getPlayersInRange(int start, int end) {
        return zSetOperations.reverseRangeWithScores(LEADERBOARD_KEY, start, end);
    }

    public Double getScore(String player) {
        return zSetOperations.score(LEADERBOARD_KEY, player);
    }

    public void removePlayer(String player) {
        zSetOperations.remove(LEADERBOARD_KEY, player);
    }
}
