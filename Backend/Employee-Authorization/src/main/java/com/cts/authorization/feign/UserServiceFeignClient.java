package com.cts.authorization.feign;

import com.cts.authorization.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserDetails-Microservice", url = "localhost:8082/users")
public interface UserServiceFeignClient {
    @GetMapping(value = "/loadUserByName/{userName}")
    public User loadUserByName(@PathVariable long userName);

}
