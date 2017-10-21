package com.spdb.lvlj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient //这里是让spring boot把本程序当成一个   eureka 客户端来启动

public class RibbonTest {


    @Bean
    @LoadBalanced  //让ribbon来托管通过这个服务的访问的请求。
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonTest.class,args);
    }

}

