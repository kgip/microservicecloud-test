package com.lxg.springcloud.service;

import com.lxg.springcloud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public int add(Employee employee);
    public int delete(String id);
    public Employee get(String id);
    public List<Employee> list();
    public int update(Employee employee);
}
