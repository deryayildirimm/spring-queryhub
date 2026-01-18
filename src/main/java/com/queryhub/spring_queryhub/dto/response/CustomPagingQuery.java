package com.queryhub.spring_queryhub.dto.response;

import com.queryhub.spring_queryhub.dto.request.CustomPagingRequest;
import com.queryhub.spring_queryhub.entity.SortDirection;
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
