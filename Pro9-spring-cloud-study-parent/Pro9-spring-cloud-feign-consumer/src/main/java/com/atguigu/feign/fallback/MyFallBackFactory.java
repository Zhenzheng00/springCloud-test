package com.atguigu.feign.fallback;
import com.atguigu.common.Employee;
import com.atguigu.feign.service.EmployeeRemoteService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService> {
    @Override
    public EmployeeRemoteService create(Throwable throwable) {
        return new EmployeeRemoteService() {
            @Override
            public Employee getEmployeeRemote() {
                return new Employee(1,"fallback",1.0);
            }
        };
    }
}
