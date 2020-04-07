package com.lxg.springcloud.controller;

import com.lxg.springcloud.entity.Employee;
import com.lxg.springcloud.entity.ResultObject;
import com.lxg.springcloud.service.EmployeeService;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider/dept")
@DefaultProperties(defaultFallback = "defaultFallback")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Object add(Employee employee){
        return employeeService.add(employee);
    }
    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") String id){
        return employeeService.delete(id);
    }
    @GetMapping("/{id}")
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
                                         @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
                                         @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
                                         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public Object get(@PathVariable("id") String id) throws InterruptedException {
        Employee employee = employeeService.get(id);
        if(employee==null){
            throw new RuntimeException();
        }
//        Thread.sleep(5000);
        return employee;
    }
    @GetMapping("/")
    public Object list(){
//        int t = 2/0;
        return employeeService.list();
    }
    @PutMapping("/")
    public Object update(Employee employee){
        return employeeService.update(employee);
    }
    @GetMapping("/serviceinfo")
    public Object getServiceInfo(){
        return new ResultObject(1,"provider-dept-8001",0,null);
    }
    public Object defaultFallback(){
        return new ResultObject(1,"defaultFallback",0,null);
    }
}
