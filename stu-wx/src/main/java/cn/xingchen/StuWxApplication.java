package cn.xingchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * https://gitee.com/596392912/spring-boot-starter-weixin
 */
@SpringBootApplication
@EnableCaching
public class StuWxApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuWxApplication.class, args);
    }
}
