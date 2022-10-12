package com.atguigu.provider.controller;

import com.atguigu.common.Employee;
import com.netflix.client.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EmployeeHandler {
    @RequestMapping("/provider/get/ribbon/employee")
    public Employee getEmployeeRemote(HttpServletRequest request) {
        int serverPort = request.getServerPort();
        return new Employee(555, "tom555-"+serverPort, 555.55);
    }
    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote2(HttpServletRequest request) {
        int serverPort = request.getServerPort();
        return new Employee(555, "tom555-"+serverPort, 555.55);
    }
}