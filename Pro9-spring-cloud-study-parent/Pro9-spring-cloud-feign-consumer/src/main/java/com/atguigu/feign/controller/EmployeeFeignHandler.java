package com.atguigu.feign.controller;

import com.atguigu.common.Employee;
import com.atguigu.feign.service.EmployeeRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeFeignHandler {
    @Autowired
    private EmployeeRemoteService employeeRemoteService;

    @RequestMapping("/feign")
    public Employee getEmployeeRemote() {

        return employeeRemoteService.getEmployeeRemote();
    }
    @RequestMapping("/test")
    public String test(){
        return "ok";
    }
}