package com.queryhub.spring_queryhub.entity;

import java.util.List;

public record PaginatedResponse<T>(
        List<T> items,
        PageMeta metaData

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
