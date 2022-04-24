package com.gucardev.springbootmicroservice3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "purchase-service", path = "/api/purchase", url = "http://localhost:8082", configuration = FeignConfiguration.class)
public interface PurchaseServiceRequest {

    @PostMapping  //api/purchase
    Object savePurchase(@RequestBody Object requestBody);

    @GetMapping("{userId}")  //api/purchase/{userId}
    List<Object> getAllPurchasesOfUser(@PathVariable("userId") Long userId);

}
