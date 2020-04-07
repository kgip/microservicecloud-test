package com.lxg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystixDashBoard {
    public static void main(String[] args) {
        SpringApplication.run(HystixDashBoard.class,args);
    }

}
