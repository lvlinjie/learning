package com.spdb.lvlj.cont;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    private EurekaClient discoveryClient;


    @RequestMapping("/instance")
    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("APP-CONSUMER-USER", false);
        return instance.getHomePageUrl();
    }
}
