package com.argo.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class pruebacontroller {

    @GetMapping("")
    public String hola(){
        return "ola";
    }
}
