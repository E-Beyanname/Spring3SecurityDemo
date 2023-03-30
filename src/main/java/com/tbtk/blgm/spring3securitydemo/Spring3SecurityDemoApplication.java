package com.tbtk.blgm.spring3securitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Spring3SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring3SecurityDemoApplication.class, args);
    }

}
