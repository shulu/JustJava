/*
 * @Author: shulu
 * @Date: 2024-08-18 23:12:48
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-18 23:19:18
 * @Description: file content
 * @FilePath: \JustJava\restful\src\main\java\com\restful\config\OpenAPIConfig.java
 */
package com.restful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("swagger 3.0")
                                .description("3.0 swagger+springboot")
                                .version("1.0.0"))
                .externalDocs(new ExternalDocumentation().description("项目API文档").url("/"));

    }
}
