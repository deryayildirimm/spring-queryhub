package com.queryhub.spring_queryhub.specification;

import com.queryhub.spring_queryhub.entity.Course;
import com.queryhub.spring_queryhub.entity.CourseLevel;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class CourseSpecification {

    private CourseSpecification() {}

    public static Specification<Course> titleLike(String title) {

        return (root, query, cb) ->
                cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Course> hasLevel(CourseLevel level) {
        return ((root, query, cb) -> cb.equal(root.get("level") , level));
    }

    public static Specification<Course> priceGte(BigDecimal min) {
        return (root, query, cb) -> cb.ge(root.get("price"), min.doubleValue());
    }

    public static Specification<Course> priceLte(BigDecimal max) {
        return (root, query, cb) -> cb.le(root.get("price"), max.doubleValue());
    }

    public static Specification<Course> createdAfter(LocalDateTime from) {
        return (root, q, cb) -> cb.greaterThanOrEqualTo(root.get("created"), from);
    }

    public static Specification<Course> createdBefore(LocalDateTime to) {
        return (root, q, cb) -> cb.lessThanOrEqualTo(root.get("created"), to);
    }

    // ManyToOne: category.name
    public static Specification<Course> hasCategoryName(String name) {
        return (root, q, cb) ->
                cb.equal(cb.lower(root.get("category").get("name")), name.toLowerCase());
    }

    // ManyToOne: instructor.name
    public static Specification<Course> hasInstructorName(String fullName) {
        return (root, q, cb) ->
                cb.equal(cb.lower(root.get("instructor").get("name")), fullName.toLowerCase());
    }

    public static Specification<Course> search (String keyword) {
        return (root, query, cb) -> {
            String like = "%" + keyword.toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("title")) , like),
                    cb.like(cb.lower(root.get("instructor").get("name")), like),
                    cb.like(cb.lower(root.get("category").get("name")), like)
            );
        };
    }


}
