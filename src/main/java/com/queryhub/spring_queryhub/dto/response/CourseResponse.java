package com.queryhub.spring_queryhub.dto.response;

import com.queryhub.spring_queryhub.entity.CourseLevel;

public record CourseResponse(
        String title,
        String description,
        double price,
        CourseLevel level,
        int rating,
        String instructorName,
        String categoryName
) { }
