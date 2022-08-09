package com.mifdha.api.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @RequestMapping("/user-fallback")
    public String userFallBack(){
        return "user service is down";
    }
    @RequestMapping("/department-fallback")
    public String departmentFallBack(){
        return "department service is down";
    }

}
