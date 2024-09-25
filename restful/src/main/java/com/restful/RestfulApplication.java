/*
 * @Author: shulu
 * @Date: 2024-08-08 22:01:25
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-30 14:49:25
 * @Description: file content
 * @FilePath: \restful\src\main\java\com\restful\RestfulApplication.java
 */
package com.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class RestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}

}
