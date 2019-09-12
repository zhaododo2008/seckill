package com.seckill.analysis.web;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhaododo
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.seckill.analysis","com.seckill.analysis.web.config"})
@EnableTransactionManagement
@MapperScan("com.seckill.analysis.**.mapper")
@EnableSwagger2
public class SecKillApplication {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SecKillApplication.class)
                .properties("spring.profiles.active=nacos")
                .run(args);
    }

}
