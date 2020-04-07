package com.lxg.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Employee implements Serializable {
    private String id;
    private String name;
    private String gender;
    private Date birth;
    private String dbSource;
}
