package com.queryhub.spring_queryhub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;
    private String description;
    @NotNull
    private double price;
    @Enumerated(EnumType.STRING)
    private CourseLevel level;
    private int rating;
    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id" , nullable = false)
    @JsonBackReference("category-courses")
    Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", nullable = false)
    @JsonBackReference("instructor-courses")
    Instructor instructor;

    // for hibernate
    protected Course(){}

    // static factory method
    public static Course create(String title, String description, double price,
                                CourseLevel level, Category category, Instructor instructor) {
        Course course = new Course();
        course.title = title;
        course.description = description;
        course.price = price;
        course.level = level;
        course.rating = 0;
        course.created = LocalDateTime.now();
        course.category = category;
        course.instructor = instructor;

        return  course;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
       return title;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public CourseLevel getLevel() {
        return level;
    }
    public int getRating() {
        return rating;
    }
    public LocalDateTime getCreated() {
        return created;
    }
    public Instructor getInstructor() {
        return instructor;
    }
    public Category getCategory() {
        return category;
    }




}
