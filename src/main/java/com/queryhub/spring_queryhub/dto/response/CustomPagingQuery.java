package com.queryhub.spring_queryhub.dto.response;

import com.queryhub.spring_queryhub.dto.request.CustomPagingRequest;
import com.queryhub.spring_queryhub.entity.SortDirection;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomPagingQuery {
    @Min(1)
    private int pageNumber = 1;

    @Min(1)
    @Max(50)
    private int pageSize = 20;

    @NotBlank
    private String sortBy = "created";

    @NotNull
    private SortDirection sortDirection = SortDirection.DESC;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }

    public CustomPagingRequest toRequest() {
        return new CustomPagingRequest(getPageNumber(), getPageSize(), getSortBy(), getSortDirection());
    }
}
