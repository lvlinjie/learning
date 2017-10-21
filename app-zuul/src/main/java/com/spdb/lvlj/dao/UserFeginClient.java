package com.spdb.lvlj.dao;


import com.spdb.lvlj.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient("app-ribbon")  //映射到注册中心的服务提供者,他创建了一个子容器。
public interface UserFeginClient {

    //映射这个服务提供者的某一个业务。这里必须的这个业务对打应的参数返回值一样。
    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    //这里不可以用@GerMapping  @PostMapping ，因为Fegin客户端不支持
    public User findById(@PathVariable("id") Integer id);
    //这里的@PathVariable 括号中一定要制定对应的参数，要不然方法只会调用他的默认参数

}
