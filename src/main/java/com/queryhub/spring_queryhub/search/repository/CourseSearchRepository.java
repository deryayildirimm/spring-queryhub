package com.queryhub.spring_queryhub.search.repository;


import com.queryhub.spring_queryhub.search.document.CourseDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CourseSearchRepository extends ElasticsearchRepository<CourseDocument, Long> {

    List<CourseDocument> findByTitleContainingOrDescriptionContainingOrCategoryNameContainingOrInstructorNameContaining(
            String title,
            String description,
            String categoryName,
            String instructorName
    );

}
