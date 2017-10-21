package com.spdb.lvlj.dao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
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
