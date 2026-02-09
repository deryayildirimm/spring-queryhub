package com.queryhub.spring_queryhub.specification;

import com.queryhub.spring_queryhub.dto.request.CourseSearchRequest;
import com.queryhub.spring_queryhub.entity.Course;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class CourseSpecBuilder {

    private CourseSpecBuilder() {}

    public static Specification<Course> build (CourseSearchRequest req) {
        List<Specification<Course>> specs = new ArrayList<>();

        if (hasText(req.keyword())) specs.add(CourseSpecification.search(req.keyword()));
        if (hasText(req.titlePart())) specs.add(CourseSpecification.titleLike(req.titlePart()));
        if (req.level() != null) specs.add(CourseSpecification.hasLevel(req.level()));
        if (req.minPrice() != null) specs.add(CourseSpecification.priceGte(req.minPrice()));
        if (req.maxPrice() != null) specs.add(CourseSpecification.priceLte(req.maxPrice()));
        if (hasText(req.categoryName())) specs.add(CourseSpecification.hasCategoryName(req.categoryName()));
        if (hasText(req.instructorName())) specs.add(CourseSpecification.hasInstructorName(req.instructorName()));
        if (req.createdFrom() != null) specs.add(CourseSpecification.createdAfter(req.createdFrom()));
        if (req.createdTo() != null) specs.add(CourseSpecification.createdBefore(req.createdTo()));

        return specs.stream()
                .reduce(Specification.unrestricted(), Specification::and);
    }

    private static boolean hasText(String s) {
        return s != null && !s.isBlank();
    }


}
