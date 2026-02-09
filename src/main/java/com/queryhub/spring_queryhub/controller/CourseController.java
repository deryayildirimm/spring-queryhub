package com.queryhub.spring_queryhub.controller;

import com.queryhub.spring_queryhub.dto.request.CourseCreateRequest;
import com.queryhub.spring_queryhub.dto.request.CourseSearchWithPagingRequest;
import com.queryhub.spring_queryhub.dto.request.CustomPagingRequest;
import com.queryhub.spring_queryhub.dto.response.CourseListItem;
import com.queryhub.spring_queryhub.dto.response.CourseResponse;
import com.queryhub.spring_queryhub.dto.response.CustomPagingQuery;
import com.queryhub.spring_queryhub.dto.response.PaginatedResponse;
import com.queryhub.spring_queryhub.entity.Course;
import com.queryhub.spring_queryhub.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping
    public ResponseEntity<CourseResponse> createController(
            @RequestBody @Valid CourseCreateRequest courseCreateRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).
                body(courseService.createCourse(courseCreateRequest));
    }

    // /courses?pageNumber=1&pageSize=20&sortBy=createdAt&sortDirection=DESC
    @GetMapping
    public ResponseEntity<PaginatedResponse<CourseResponse>> list(@Valid CustomPagingQuery query) {
        CustomPagingRequest paging = query.toRequest();
        return ResponseEntity.ok(courseService.listCourses(paging));
    }

    @PostMapping("/search")
    public Page<CourseListItem> search(@Valid @RequestBody CourseSearchWithPagingRequest body) {
        Pageable pageable = body.pagingRequest().toPageable(Set.of("createdAt","price","rating","title"));
        return courseService.searchCourses(body.searchRequest(), pageable);
    }

}
