package com.spdb.lvlj.cont;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.spdb.lvlj.entity.CloudUser;
import com.spdb.lvlj.respory.UserRespory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    private UserRespory userRespory;

    @Autowired
    private EurekaClient discoveryClient;



    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/simple/{id}")
    public CloudUser Say(@PathVariable Integer id){
            return userRespory.findOne(id);
    }


    @RequestMapping("instance")
    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("app-ribbon", false);
        return instance.getHomePageUrl();
    }

}
