package com.queryhub.spring_queryhub.controller;

import com.queryhub.spring_queryhub.entity.*;
import com.queryhub.spring_queryhub.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping
    public ResponseEntity<CourseResponse> createAccount(
            @RequestBody @Valid CourseCreateRequest courseCreateRequest) {

        return ResponseEntity.ok(courseService.createCourse(courseCreateRequest));
    }

    // /courses?pageNumber=1&pageSize=20&sortBy=createdAt&sortDirection=DESC
    @GetMapping
    public ResponseEntity<PaginatedResponse<CourseResponse>> list(@Valid CustomPagingQuery query) {
        CustomPagingRequest paging = query.toRequest();
        return ResponseEntity.ok(courseService.listCourses(paging));
    }

}
