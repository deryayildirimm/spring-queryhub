package com.queryhub.spring_queryhub.dto.response;

import com.queryhub.spring_queryhub.entity.SortDirection;

import java.util.List;

public record PaginatedResponse<T>(
        List<T> items,
        PageMeta meta

) {

    public record PageMeta(
            int pageNumber,      // 1-based
            int pageSize,
            long totalElements,
            int totalPages,
            boolean hasNext,
            boolean hasPrevious,
            String sortBy,
            SortDirection sortDirection
    ) {}
}
