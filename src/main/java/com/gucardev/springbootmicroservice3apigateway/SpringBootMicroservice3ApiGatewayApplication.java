package com.gucardev.springbootmicroservice3apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootMicroservice3ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroservice3ApiGatewayApplication.class, args);
    }

}
