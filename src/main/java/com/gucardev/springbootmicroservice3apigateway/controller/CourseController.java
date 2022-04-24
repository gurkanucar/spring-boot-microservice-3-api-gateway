package com.gucardev.springbootmicroservice3apigateway.controller;

import com.gucardev.springbootmicroservice3apigateway.request.CourseServiceRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gateway/course")
public class CourseController {

    private final CourseServiceRequest courseServiceRequest;


    public CourseController(CourseServiceRequest courseServiceRequest) {
        this.courseServiceRequest = courseServiceRequest;
    }


    @PostMapping //gateway/course
    public ResponseEntity<?> saveCourse(@RequestBody Object course)
    {
        return new ResponseEntity<>(courseServiceRequest.saveCourse(course), HttpStatus.CREATED);
    }

    @DeleteMapping("{courseId}")//gateway/course/{courseId}
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId)
    {
        courseServiceRequest.deleteCourse(courseId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping//gateway/course
    public ResponseEntity<?> getAllCourses()
    {
        return ResponseEntity.ok(courseServiceRequest.getAllCourses());
    }

}
