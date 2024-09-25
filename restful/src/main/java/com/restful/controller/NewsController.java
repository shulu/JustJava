package com.restful.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/indexRedis")
    public String index() {
        return "indexRedis";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        Map<String, String> map = redisTemplate.opsForHash().entries("news_" + id);
        String countRead = map.get("read");
        if (countRead == null || countRead.equals("")) {
            countRead = "1";
        } else {
            countRead = (Integer.parseInt(countRead) + 1) + "";
        }
        map.put("read", countRead);
        redisTemplate.opsForHash().putAll("news_" + id, map);
        model.addAllAttributes(map);
        return "news" + id;
    }

    @RequestMapping("/addZan")
    @ResponseBody
    public String addZan(int id) {
        Map<String, String> map = redisTemplate.opsForHash().entries("news_" + id);
        String countZan = map.get("zan");
        if (countZan == null || countZan.equals("")) {
            countZan = "1";
        } else {
            countZan = (Integer.parseInt(countZan) + 1) + "";
        }
        redisTemplate.opsForHash().put("news_" + id, "zan", countZan);
        return countZan;
    }

}
