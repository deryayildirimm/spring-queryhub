package com.queryhub.spring_queryhub.dto.request;

import com.queryhub.spring_queryhub.entity.CourseLevel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CourseSearchRequest(
        String keyword,
        String titlePart,
        CourseLevel level,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        String categoryName,
        String instructorName,
        LocalDateTime createdFrom,
        LocalDateTime createdTo
) {
}
