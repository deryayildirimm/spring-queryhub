package com.queryhub.spring_queryhub.search.service;

import com.queryhub.spring_queryhub.repository.CourseRepository;
import com.queryhub.spring_queryhub.search.document.CourseDocument;
import com.queryhub.spring_queryhub.search.repository.CourseSearchRepository;
import com.queryhub.spring_queryhub.view.CourseIndexView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSearchIndexservice {

    private final CourseRepository courseRepository;
    private final CourseSearchRepository courseSearchRepository;


    public CourseSearchIndexservice(CourseRepository courseRepository, CourseSearchRepository courseSearchRepository) {
        this.courseRepository = courseRepository;
        this.courseSearchRepository = courseSearchRepository;
    }

    public void reindexAllCourses() {
        List<CourseIndexView> courses = courseRepository.findAllProjectedBy();

        List<CourseDocument> documents = courses.stream()
                .map(this::toDocument)
                .toList();

        courseSearchRepository.deleteAll();
        courseSearchRepository.saveAll(documents);
    }


    private CourseDocument toDocument(CourseIndexView course) {
        return new CourseDocument(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getCategory() != null ? course.getCategory().getName() : null,
                course.getInstructor() != null ? course.getInstructor().getName() : null,
                course.getLevel(),
                course.getPrice()
        );
    }
}
