package com.atguigu.feign.service;

import com.atguigu.common.Employee;
import com.atguigu.feign.fallback.MyFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "atguigu-provider", fallbackFactory = MyFallBackFactory.class)
public interface EmployeeRemoteService {
    @RequestMapping("/provider/get/employee/remote")
    Employee getEmployeeRemote();
}
