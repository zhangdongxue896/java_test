package com.example.feign;

import com.example.feign.impl.UserFeignImpl;
import com.example.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = UserFeignImpl.class)
public interface UserFeign {

    /**
     * 伪装访问请求的方法
     * @GetMapping("/user/{id}") 与服务提供者的地址一致
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
