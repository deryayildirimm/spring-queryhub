package com.queryhub.spring_queryhub.repository;

import com.queryhub.spring_queryhub.entity.Course;
import com.queryhub.spring_queryhub.entity.Instructor;
import com.queryhub.spring_queryhub.view.CourseIndexView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {

    boolean existsByTitleAndInstructor(String title, Instructor instructor);

    List<CourseIndexView> findAllProjectedBy();
}
