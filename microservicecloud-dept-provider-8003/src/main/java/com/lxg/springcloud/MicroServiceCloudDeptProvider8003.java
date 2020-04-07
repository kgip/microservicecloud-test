package com.lxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MicroServiceCloudDeptProvider8003 {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudDeptProvider8003.class,args);
    }
}
