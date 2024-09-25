package com.restful;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
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

    // 测试leftPush方法，leftPushAll方法，range方法,size方法
    @Test
    void TestList1() {
        redisTemplate.opsForList().leftPush("mylist1", "a");
        redisTemplate.opsForList().leftPush("mylist1", "b");
        redisTemplate.opsForList().leftPush("mylist1", "c");
        System.out.println(redisTemplate.opsForList().size("mylist1"));
        System.out.println(redisTemplate.opsForList().range("mylist1", 0, -1));
        redisTemplate.opsForList().leftPushAll("mylist1", "1", "2");
        String[] str = { "3", "4", "5" };
        redisTemplate.opsForList().leftPushAll("mylist1", str);
        System.out.println(redisTemplate.opsForList().size("mylist1"));
        System.out.println(redisTemplate.opsForList().range("mylist1", 0, -1));
    }

    // 测试rightPush方法，rightPushAll方法
    @Test
    void TestList2() {
        redisTemplate.opsForList().rightPush("mylist2", "a");
        redisTemplate.opsForList().rightPush("mylist2", "b");
        redisTemplate.opsForList().rightPush("mylist2", "c");
        System.out.println(redisTemplate.opsForList().size("mylist2"));
        System.out.println(redisTemplate.opsForList().range("mylist2", 0, -1));
        redisTemplate.opsForList().rightPushAll("mylist2", "1", "2");// 一次添加多个元素
        String[] str = { "3", "4", "5" };
        redisTemplate.opsForList().rightPushAll("mylist2", str);// 使用数组一次添加多个元素
        System.out.println(redisTemplate.opsForList().size("mylist2"));
        System.out.println(redisTemplate.opsForList().range("mylist2", 0, -1));
    }

    @Test
    void testList3() { // 测试remove
        String[] str = { "10", "20", "30", "10", "20", "30", "10", "20", "30" };
        redisTemplate.opsForList().rightPushAll("mylist3", str);
        System.out.println(redisTemplate.opsForList().range("mylist3", 0, -1));
        redisTemplate.opsForList().remove("mylist3", 0, "10");// 全部删除
        System.out.println(redisTemplate.opsForList().range("mylist3", 0, -1));
        redisTemplate.opsForList().remove("mylist3", 2, "20");// 从左到右删
        System.out.println(redisTemplate.opsForList().range("mylist3", 0, -1));
        redisTemplate.opsForList().remove("mylist3", -2, "30");// 从右到左删
        System.out.println(redisTemplate.opsForList().range("mylist3", 0, -1));
    }

    @Test
    void testList4() {// 测试leftPop,rightPop方法
        String[] str = { "a", "b", "c", "d", "e" };
        redisTemplate.opsForList().rightPushAll("mylist4", str);
        System.out.println(redisTemplate.opsForList().range("mylist4", 0, -1));
        System.out.println(redisTemplate.opsForList().leftPop("mylist4"));// 从左侧删
        System.out.println(redisTemplate.opsForList().range("mylist4", 0, -1));
        System.out.println(redisTemplate.opsForList().rightPop("mylist4"));// 从右侧删
        System.out.println(redisTemplate.opsForList().range("mylist4", 0, -1));

    }

    @Test
    void testList5() { // 测试set和index方法
        String[] str = { "a", "b", "c" };
        redisTemplate.opsForList().rightPushAll("mylist5", str);
        System.out.println(redisTemplate.opsForList().range("mylist5", 0, -1));
        System.out.println(redisTemplate.opsForList().index("mylist5", 1));// 获取索引1处的值
        redisTemplate.opsForList().set("mylist5", 1, "d");// 将索引1处的值改为b
        System.out.println(redisTemplate.opsForList().range("mylist5", 0, -1));
        System.out.println(redisTemplate.opsForList().index("mylist5", 1));

    }

    @Test
    void testSet1() { // 测试添加 删除，size,members方法

        redisTemplate.opsForSet().add("myset1", "a");
        redisTemplate.opsForSet().add("myset1", "b", "c");
        String[] str = { "1", "2" };
        redisTemplate.opsForSet().add("myset1", str);
        System.out.println("size:" + redisTemplate.opsForSet().size("myset1"));
        System.out.println(redisTemplate.opsForSet().members("myset1"));// 查看所有元素
        System.out.println(redisTemplate.opsForSet().remove("myset1", "a"));// 删除一个元素
        System.out.println(redisTemplate.opsForSet().members("myset1"));
        System.out.println(redisTemplate.opsForSet().remove("myset1", str));// 删除多个元素
        System.out.println(redisTemplate.opsForSet().members("myset1"));
        redisTemplate.opsForSet().add("myset1", str);// 重新添加
        System.out.println(redisTemplate.opsForSet().members("myset1")); // 再次查看
        System.out.println(redisTemplate.opsForSet().pop("myset1"));// 随机删除
        System.out.println(redisTemplate.opsForSet().members("myset1"));

    }

    @Test
    void testSet2() { // 测试移动
        String[] str1 = { "1", "2", "3" };
        String[] str2 = { "a", "b", "c" };
        System.out.println(redisTemplate.opsForSet().add("myset2", str1));
        System.out.println(redisTemplate.opsForSet().add("myset3", str2));
        System.out.println(redisTemplate.opsForSet().members("myset2"));
        System.out.println(redisTemplate.opsForSet().members("myset3"));
        redisTemplate.opsForSet().move("myset2", "1", "myset3");
        System.out.println(redisTemplate.opsForSet().members("myset2"));
        System.out.println(redisTemplate.opsForSet().members("myset3"));

    }

    @Test
    void testSet3() {
        String[] str = { "a", "b", "c" };
        redisTemplate.opsForSet().add("myset4", str);
        Cursor<Object> cursor = redisTemplate.opsForSet().scan("myset4", ScanOptions.NONE);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    @Test
    void testZset1() {
        redisTemplate.opsForZSet().add("zset1", "f1", 80);
        redisTemplate.opsForZSet().add("zset1", "f2", 70);
        redisTemplate.opsForZSet().add("zset1", "f3", 90);
        System.out.println("size:" + redisTemplate.opsForZSet().size("zset1"));
        System.out.println(redisTemplate.opsForZSet().range("zset1", 0, -1));
        System.out.println(redisTemplate.opsForZSet().rank("zset1", "f1"));

    }

    @Test
    void testZset2() {
        redisTemplate.opsForZSet().add("zset2", "f1", 80);
        redisTemplate.opsForZSet().add("zset2", "f2", 70);
        redisTemplate.opsForZSet().add("zset2", "f3", 90);
        redisTemplate.opsForZSet().add("zset2", "f4", 60);
        System.out.println(redisTemplate.opsForZSet().score("zset2", "f1"));
        System.out.println(redisTemplate.opsForZSet().range("zset2", 0, -1));

        System.out.println(redisTemplate.opsForZSet().rangeByScore("zset2", 70, 90));
        System.out.println(redisTemplate.opsForZSet().count("zset2", 70, 90));

    }

    @Test
    void testZset3() {
        redisTemplate.opsForZSet().add("zset3", "f1", 40);
        redisTemplate.opsForZSet().add("zset3", "f2", 50);
        redisTemplate.opsForZSet().add("zset3", "f3", 60);
        redisTemplate.opsForZSet().add("zset3", "f4", 70);
        redisTemplate.opsForZSet().add("zset3", "f5", 80);
        redisTemplate.opsForZSet().add("zset3", "f6", 90);
        redisTemplate.opsForZSet().add("zset3", "f7", 100);
        System.out.println(redisTemplate.opsForZSet().range("zset3", 0, -1));
        redisTemplate.opsForZSet().remove("zset3", "f1");
        System.out.println(redisTemplate.opsForZSet().range("zset3", 0, -1));
        redisTemplate.opsForZSet().removeRange("zset3", 0, 1);
        System.out.println(redisTemplate.opsForZSet().range("zset3", 0, -1));
        redisTemplate.opsForZSet().removeRangeByScore("zset3", 70, 80);
        System.out.println(redisTemplate.opsForZSet().range("zset3", 0, -1));

    }
}
