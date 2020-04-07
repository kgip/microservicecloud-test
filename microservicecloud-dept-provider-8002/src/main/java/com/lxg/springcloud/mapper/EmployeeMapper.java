package com.lxg.springcloud.mapper;

import com.lxg.springcloud.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    public int add(Employee employee);
    public int deleteById(@Param("id") String id);
    public Employee get(@Param("id") String id);
    public int update(Employee employee);
    public List<Employee> list();
}
