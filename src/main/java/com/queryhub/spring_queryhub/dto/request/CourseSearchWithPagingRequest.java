package com.queryhub.spring_queryhub.dto.request;

import jakarta.validation.Valid;

public record CourseSearchWithPagingRequest(
        @Valid CourseSearchRequest searchRequest,
        @Valid CustomPagingRequest pagingRequest
) {
}
