package com.queryhub.spring_queryhub.mapper;

import com.queryhub.spring_queryhub.dto.request.CourseCreateRequest;
import com.queryhub.spring_queryhub.dto.response.CourseResponse;
import com.queryhub.spring_queryhub.entity.*;

public class CourseMapper {

    public static Course toEntity(CourseCreateRequest dto, Instructor instructor, Category category) {
        return Course.create(
                dto.title(),
                dto.description(),
                dto.price(),
                dto.level(),
                category,
                instructor
        );
    }

    public static CourseResponse toResponse(Course course) {
        return new CourseResponse(
                course.getTitle(),
                course.getDescription(),
                course.getPrice(),
                course.getLevel(),
                course.getRating(),
                course.getInstructor().getName(),
                course.getCategory().getName()
        );
    }
}

