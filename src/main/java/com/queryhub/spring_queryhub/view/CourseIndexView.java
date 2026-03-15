package com.queryhub.spring_queryhub.view;

public interface CourseIndexView {

    Long getId();
    String getTitle();
    String getDescription();
    Double getPrice();
    String getLevel();

    CategoryView getCategory();
    InstructorView getInstructor();

    interface CategoryView {
        String getName();
    }

    interface InstructorView {
        String getName();
    }
}
