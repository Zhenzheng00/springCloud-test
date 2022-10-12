package com.atguigu.consumer.controller;
import com.atguigu.common.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class HumanResourceHandler {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/consumer/get/employee")
    public Employee getEmployeeRemote() {
        // 远程调用方法的主机地址
//        String host = "http://localhost:1000";
        String host = "http://atguigu-provider";
        // 远程调用方法的具体 URL 地址
        String url = "/provider/get/ribbon/employee";
        return restTemplate.getForObject(host + url, Employee.class);
    }

    @RequestMapping("comsumer/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(System.err::println);
        return null;
    }

}