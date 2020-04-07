package com.lxg.springcloud.controller;

import com.lxg.springcloud.entity.Employee;
import com.lxg.springcloud.entity.ResultObject;
import com.lxg.springcloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider/dept")
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
    public Object get(@PathVariable("id") String id){
        return employeeService.get(id);
    }
    @GetMapping("/")
    public Object list(){
        return employeeService.list();
    }
    @PutMapping("/")
    public Object update(Employee employee){
        return employeeService.update(employee);
    }
    @GetMapping("/serviceinfo")
    public Object getServiceInfo(){
        return new ResultObject(1,"provider-dept-8002",0,null);
    }
}
