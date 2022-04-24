package com.gucardev.springbootmicroservice3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "course-service",
        path = "/api/course",
        //url = "http://localhost:8081",
        configuration = FeignConfiguration.class)
public interface CourseServiceRequest {

    @PostMapping
        // /api/course
    Object saveCourse(@RequestBody Object requestBody);

    @DeleteMapping("{courseId}")
        //api/course/{courseId}
    void deleteCourse(@PathVariable("courseId") Long courseId);

    @GetMapping
        // /api/course
    List<Object> getAllCourses();

}
