package com.third.easyprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.third.easyprice")

public class EasypriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasypriceApplication.class, args);
    }
}
