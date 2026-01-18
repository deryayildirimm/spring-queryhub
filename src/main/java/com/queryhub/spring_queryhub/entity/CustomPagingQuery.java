package com.queryhub.spring_queryhub.entity;

import org.springframework.web.bind.annotation.RequestParam;

public record CustomPagingQuery(
        @RequestParam(defaultValue = "1") int pageNumber,
        @RequestParam(defaultValue = "20") int pageSize,
        @RequestParam(defaultValue = "createdAt") String sortBy,
        @RequestParam(defaultValue = "DESC") SortDirection sortDirection
) {
    public CustomPagingRequest toRequest() {
        return new CustomPagingRequest(pageNumber, pageSize, sortBy, sortDirection);
    }
}
