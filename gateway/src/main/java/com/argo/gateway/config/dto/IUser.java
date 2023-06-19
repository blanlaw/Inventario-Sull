package com.argo.gateway.config.dto;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("commons-service")
public interface IUser {


    @GetMapping("user/getUser/{username}")
    public UserDTO getUser(@PathVariable("username") String user);


    @RequestMapping("/roles/prueba")
    public String roles();
}
