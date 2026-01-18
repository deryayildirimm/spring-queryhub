package com.queryhub.spring_queryhub.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    // parent -> managed reference
    // why parent ?  -> has lots of child (courses)
    @OneToMany(mappedBy = "category")
    @JsonManagedReference("category-courses")
    List<Course> courses;


    protected Category() {}

    public static Category create(String name) {
        Category category = new Category();
        category.name = name;
        return category;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
