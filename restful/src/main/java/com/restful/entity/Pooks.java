package com.restful.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "student", timeToLive = 60)
public class Pooks {

    @Id
    private int id;
    private String name;
    private String category;
    private String author;
    private double price;
}
