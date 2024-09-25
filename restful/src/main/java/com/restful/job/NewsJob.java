package com.restful.job;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NewsJob {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0 0/1 * * * ? ") // 每1分钟
    public void SaveNewsData() {
        Set<String> keys = redisTemplate.keys("news_*");
        for (String key : keys) {
            Map<String, String> map = redisTemplate.opsForHash().entries(key);
            String id = key.substring(5);
            String read = map.get("read");
            String zan = map.get("zan");
            logger.info("编号：" + id + ",阅读次数：" + read + ",点赞次数：" + zan);
        }
        logger.info("以上数据已保存到数据库");
    }
}
