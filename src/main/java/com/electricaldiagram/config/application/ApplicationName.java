package com.electricaldiagram.config.application;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 定义服务名称，redis的key使用
 * @author: Zkl
 * @create: 2010-10-09
 **/
@Getter
@Configuration
public class ApplicationName {

    @Value("${spring.application.name}")
    private String ApplicationName;
}
