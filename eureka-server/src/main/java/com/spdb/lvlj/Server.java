package com.spdb.lvlj;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer//表明自己是一个服务器，spring boot 要所息当服务器启动
@SpringBootApplication
public class Server {

    public static void main(String[] args) {

        new SpringApplicationBuilder(Server.class).web(true).run(args);

    }


}
