package com.spdb.lvlj.dao;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.spdb.lvlj.entity.User;

@RestController
public class UserController {

    @Autowired
    private UserFeginClient userFeginClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/simple/{id}")
    public User say(@PathVariable("id") Integer id) {
        return userFeginClient.findById(id);
    }


    public User findByIdFallback(Integer id) {
        User user = new User();
        user.setAge(10);
        user.setId(122);
        user.setBalance(300);
        user.setUsername("testing");
        user.setPassword("hello");
        return user;
    }
}