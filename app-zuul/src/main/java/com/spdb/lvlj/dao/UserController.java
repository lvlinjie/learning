package com.spdb.lvlj.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spdb.lvlj.entity.User;

@RestController
public class UserController {

  /*  @Autowired
    private UserFeginClient userFeginClient;

    @GetMapping("/simple/{id}")
    public User say(@PathVariable("id") Integer id){
        return userFeginClient.findById(id);
    }
*/
}
