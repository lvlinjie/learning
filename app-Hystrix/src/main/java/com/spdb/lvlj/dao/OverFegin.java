package com.spdb.lvlj.dao;


import com.spdb.lvlj.util.Configuration1;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;

@FeignClient(name = "app-ribbon",configuration = Configuration1.class)
public interface OverFegin {
}
