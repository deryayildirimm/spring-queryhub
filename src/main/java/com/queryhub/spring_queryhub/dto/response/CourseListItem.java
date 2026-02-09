package com.queryhub.spring_queryhub.dto.response;

import java.math.BigDecimal;

public record CourseListItem (
        Long id,
        String title,
        BigDecimal price,
        String categoryName,
        String instructorName
){
}
