package com.queryhub.spring_queryhub.view;

import java.math.BigDecimal;

public interface CourseListView {

    Long getId();
    String getTitle();
    BigDecimal getPrice();

    CategoryView getCategory();

    InstructorView getInstructor();

    interface CategoryView {
        String getName();
    }
    interface InstructorView {
        String getName();
    }

}
