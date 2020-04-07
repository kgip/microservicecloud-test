package com.lxg.springcloud.service;

import com.lxg.springcloud.entity.ConstomFallBackFactory;
import com.lxg.springcloud.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "dept-provider",fallbackFactory = ConstomFallBackFactory.class)
@RequestMapping("/provider/dept")
public interface EmployeeService {
    @PostMapping("/")
    public Object add(Employee employee);
    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") String id);
    @GetMapping("/{id}")
    public Object get(@PathVariable("id") String id);
    @GetMapping("/")
    public Object list();
    @PutMapping("/")
    public Object update(Employee employee);
    @GetMapping("/serviceinfo")
    public Object serviceinfo();
}
