package com.lxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MicroServiceCloudDeptProvider8002 {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudDeptProvider8002.class,args);
    }
}
