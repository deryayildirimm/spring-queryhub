package com.queryhub.spring_queryhub.search.controller;

import com.queryhub.spring_queryhub.search.document.CourseDocument;
import com.queryhub.spring_queryhub.search.service.CourseExploreService;
import com.queryhub.spring_queryhub.search.service.CourseSearchIndexservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseSearchController {

    private final CourseSearchIndexservice courseSearchIndexservice;
    private final CourseExploreService courseExploreService;


    public CourseSearchController(CourseSearchIndexservice courseSearchIndexservice, CourseExploreService courseExploreService) {
        this.courseSearchIndexservice = courseSearchIndexservice;
        this.courseExploreService = courseExploreService;
    }

    @PostMapping("/reindex")
    public String reindexAllCourses(){
        courseSearchIndexservice.reindexAllCourses();
        return "corses indexed successfully";
    }

    @GetMapping("/explore")
    public List<CourseDocument> exploreCourses(@RequestParam String q){
        return courseExploreService.explore(q);
    }




}
