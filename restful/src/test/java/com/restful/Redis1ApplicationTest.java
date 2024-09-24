package com.restful;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootTest
public class Redis1ApplicationTest {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    // 测试失效时间
    @Test
    void Test1() throws InterruptedException {
        redisTemplate.opsForValue().set("test1", "Test Timeout 5 seconds", 5, TimeUnit.SECONDS);
        System.out.println("第0秒取值：" + redisTemplate.opsForValue().get("test1"));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
        }
        System.out.println("第4秒取值：" + redisTemplate.opsForValue().get("test1"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        System.out.println("第6秒取值：" + redisTemplate.opsForValue().get("test1"));
    }

    // 测试getAndSet方法
    @Test
    void test2() throws InterruptedException {
        redisTemplate.opsForValue().set("test2", "Test getAndSet1");
        System.out.println(redisTemplate.opsForValue().getAndSet("test2", "Test getAndSet2"));
        System.out.println(redisTemplate.opsForValue().get("test2"));
    }

    // 测试append方法
    @Test
    void test3() {
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().append("test3", "test3");
        System.out.println(redisTemplate.opsForValue().get("test3"));
        redisTemplate.opsForValue().append("test3", " OK!");
        System.out.println(redisTemplate.opsForValue().get("test3"));
    }

    // 测试put方法，存入一个键值
    @Test
    void testHash1() {
        redisTemplate.opsForHash().put("book1", "bookname", "三国演义");
        redisTemplate.opsForHash().put("book1", "price", "69.0");
        System.out.println(redisTemplate.opsForHash().entries("book1")); // 读取整个hash类型（键与值）
    }

    // 测试Hash类型，putAll方法，将整个hashmap存入
    @Test
    void testHash2() {
        Map<String, Object> map = new HashMap<>();
        map.put("bookname", "西游记");
        map.put("category", "文学");
        redisTemplate.opsForHash().putAll("book2", map);
        System.out.println(redisTemplate.opsForHash().entries("book2")); // 读取整个hash类型
    }

    // 测试keys方法。获取所有键的集合
    @Test
    void testHash3() {
        redisTemplate.opsForHash().put("book3", "bookname", "红楼梦");
        redisTemplate.opsForHash().put("book3", "price", "89.0");
        System.out.println(redisTemplate.opsForHash().keys("book3")); // 读取所有键的集合
    }

    @Test
    void testHash4() {
        redisTemplate.opsForHash().put("book4", "bookname", "封神榜");
        redisTemplate.opsForHash().put("book4", "price", "79.0");
        System.out.println(redisTemplate.opsForHash().values("book4")); // 读取所有值的集合
    }

    // 测试delete方法。删除某个键的某个字段,hasKey方法，size方法
    @Test
    void testHash5() {
        redisTemplate.opsForHash().put("book5", "bookname", "封神榜");
        redisTemplate.opsForHash().put("book5", "price", "89.0");
        System.out.println(redisTemplate.opsForHash().entries("book5"));
        System.out.println(redisTemplate.opsForHash().size("book5"));// 字段个数
        System.out.println(redisTemplate.opsForHash().hasKey("book5", "price")); // 判断字段是否存在
        redisTemplate.opsForHash().delete("book5", "price");
        System.out.println(redisTemplate.opsForHash().hasKey("book5", "price"));// 再次判断
        System.out.println(redisTemplate.opsForHash().entries("book5"));
    }
}
