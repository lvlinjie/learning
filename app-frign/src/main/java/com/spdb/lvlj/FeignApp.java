package com.spdb.lvlj.dao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient  //声明这是一个eureka 的客户端。
@EnableFeignClients    //声明这是一个fegin客户端。
@RestController
public class FeignApp {

    public static void main(String[] args) {
        SpringApplication.run(FeignApp.class,args);
    }



    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
