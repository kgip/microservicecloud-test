package com.lxg.springcloud.entity;

import com.lxg.springcloud.service.EmployeeService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ConstomFallBackFactory implements FallbackFactory<EmployeeService> {
    @Override
    public EmployeeService create(Throwable throwable) {
        return new EmployeeService(){

            @Override
            public Object add(Employee employee) {
                return new ResultObject(1,"server failed",0,null);
            }

            @Override
            public Object delete(String id) {
                return new ResultObject(1,"server failed",0,null);
            }

            @Override
            public Object get(String id) {
                return new ResultObject(1,"server failed",0,null);
            }

            @Override
            public Object list() {
                return new ResultObject(1,"server failed",0,null);
            }

            @Override
            public Object update(Employee employee) {
                return new ResultObject(1,"server failed",0,null);
            }

            @Override
            public Object serviceinfo() {
                return new ResultObject(1,"server failed",0,null);
            }
        };
    }
}
