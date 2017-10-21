package com.spdb.lvlj.cont;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.spdb.lvlj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient discoveryClient;

    /*@Autowired
    private EurekaClient discoveryClient;*/

   /* @Value("${userServicePath}")
    private String userServicePath;*/

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Integer id){
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("APP-RIBBON", false);
        String url= instance.getHomePageUrl();
        System.out.println("come from this:==========>"+url);
//        用的是虚拟ip happ-ribbon  服务提供者的service id  也就是applucation id
        return this.restTemplate.getForObject(url+"/simple/"+id,User.class);
    }


 /*   @RequestMapping("/testing")
    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("APP-CONSUMER-USER", false);
        return instance.getHomePageUrl();
    }

*/

}
