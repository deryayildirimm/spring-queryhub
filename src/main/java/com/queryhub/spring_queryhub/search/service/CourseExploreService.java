package com.queryhub.spring_queryhub.search.service;

import com.queryhub.spring_queryhub.search.document.CourseDocument;
import com.queryhub.spring_queryhub.search.repository.CourseSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseExploreService {

    private final CourseSearchRepository courseSearchRepository;


    public CourseExploreService(CourseSearchRepository courseSearchRepository) {
        this.courseSearchRepository = courseSearchRepository;
    }

    public List<CourseDocument> explore (String query) {
        return courseSearchRepository.
                findByTitleContainingOrDescriptionContainingOrCategoryNameContainingOrInstructorNameContaining(
                        query, query, query, query
                );
    }

}
