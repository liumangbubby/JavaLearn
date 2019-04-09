package com.xpand.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/4/8 22:10
 * @Modified
 */
@SpringBootApplication
@EnableJpaRepositories
public class SpringBootAppStarter {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppStarter.class, args);
    }
}
