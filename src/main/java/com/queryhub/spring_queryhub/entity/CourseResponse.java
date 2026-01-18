package com.queryhub.spring_queryhub.entity;

public record CourseResponse(
        String title,
        String description,
        double price,
        CourseLevel level,
        int rating,
        String instructorName,
        String categoryName
) { }
