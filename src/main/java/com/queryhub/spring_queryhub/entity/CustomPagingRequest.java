package com.queryhub.spring_queryhub.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Set;

public record CustomPagingRequest(
        @Min(1) int pageNumber,
        @Min(1) @Max(50) int pageSize,
        @NotBlank String sortBy,
        @NotNull SortDirection sortDirection
) {

    public Pageable toPageable(Set<String> allowedSortFields) {
        if (!allowedSortFields.contains(sortBy)) {
            throw new com.queryhub.spring_queryhub.exception.InvalidSortFieldException(
                    "Invalid sort field: " + sortBy
            );
        }

        int zeroBasedPage = pageNumber - 1;
        Sort.Direction dir = (sortDirection == SortDirection.DESC) ? Sort.Direction.DESC : Sort.Direction.ASC;

        return PageRequest.of(zeroBasedPage, pageSize, Sort.by(dir, sortBy));
    }
}