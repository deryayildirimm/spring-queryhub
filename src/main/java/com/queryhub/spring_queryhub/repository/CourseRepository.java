package com.queryhub.spring_queryhub.repository;

import com.queryhub.spring_queryhub.entity.Course;
import com.queryhub.spring_queryhub.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {

    boolean existsByTitleAndInstructor(String title, Instructor instructor);

}
