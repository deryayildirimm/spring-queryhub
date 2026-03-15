package com.queryhub.spring_queryhub.search.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "courses")
public class CourseDocument {

    @Id
    private Long id;

    private String title;
    private String description;
    private String categoryName;
    private String instructorName;
    private String level;
    private Double price;

    public CourseDocument() {
    }

    public CourseDocument(
            Long id,
            String title,
            String description,
            String categoryName,
            String instructorName,
            String level,
            Double price
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryName = categoryName;
        this.instructorName = instructorName;
        this.level = level;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
