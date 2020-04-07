package com.lxg.springcloud.service.impl;

import com.lxg.springcloud.entity.Employee;
import com.lxg.springcloud.mapper.EmployeeMapper;
import com.lxg.springcloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"employee_cache"})
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired(required = false)
    private EmployeeMapper employeeMapper;
    @Override
    @CachePut(key = "#result.id")
    public int add(Employee employee) {
        return employeeMapper.add(employee);
    }

    @Override
    @CacheEvict(key = "#id")
    public int delete(String id) {
        return employeeMapper.deleteById(id);
    }

    @Override
    @Cacheable(key = "#id")
    public Employee get(String id) {
        return employeeMapper.get(id);
    }

    @Override
    @Cacheable(key = "#root.methodName")
    public List<Employee> list() {
        return employeeMapper.list();
    }

    @Override
    @CachePut(key = "#employee.id")
    public int update(Employee employee) {
        return employeeMapper.update(employee);
    }
}
