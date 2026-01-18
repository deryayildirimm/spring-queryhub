package com.queryhub.spring_queryhub.dto.request;

import com.queryhub.spring_queryhub.entity.CourseLevel;
import jakarta.validation.constraints.*;


public record CourseCreateRequest(
       @NotBlank String title,
        String description,
       @PositiveOrZero double price,
       @NotNull CourseLevel level,
       @Min(0) @Max(5) int rating,
        Long instructorId,
        Long categoryId
) {
}
