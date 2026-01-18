package com.queryhub.spring_queryhub.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String email;

    // has lots of course
    // that's why this is parent and it is manage their child (courses)
    @OneToMany(mappedBy = "instructor")
    @JsonManagedReference("instructor-courses")
    List<Course> courses;

    protected Instructor() {}

    public static Instructor create(String name, String email) {
        Instructor instructor = new Instructor();
        instructor.name = name;
        instructor.email = email;
        return instructor;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}
