package com.queryhub.spring_queryhub.entity;

import java.time.LocalDateTime;

public record CourseCreateRequest(
        String title,
        String description,
        double price,
        CourseLevel level,
        int rating,
        LocalDateTime created,
        Long instructorId,
        Long categoryId
) {
}
