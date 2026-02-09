package com.queryhub.spring_queryhub.service;

import com.queryhub.spring_queryhub.dto.request.CourseCreateRequest;
import com.queryhub.spring_queryhub.dto.request.CourseSearchRequest;
import com.queryhub.spring_queryhub.dto.response.CourseListItem;
import com.queryhub.spring_queryhub.dto.response.CourseResponse;
import com.queryhub.spring_queryhub.dto.request.CustomPagingRequest;
import com.queryhub.spring_queryhub.dto.response.PaginatedResponse;
import com.queryhub.spring_queryhub.entity.*;
import com.queryhub.spring_queryhub.exception.*;
import com.queryhub.spring_queryhub.mapper.CourseMapper;
import com.queryhub.spring_queryhub.repository.CategoryRepository;
import com.queryhub.spring_queryhub.repository.CourseRepository;
import com.queryhub.spring_queryhub.repository.InstructorRepository;
import com.queryhub.spring_queryhub.specification.CourseSpecBuilder;
import com.queryhub.spring_queryhub.view.CourseListView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CourseService {

    // saveCourse
    // getAllCourse

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final CategoryRepository categoryRepository;

    private static final Set<String> ALLOWED_SORT_FIELDS =
            Set.of("id", "title", "price", "rating", "createdAt");

    public CourseService(CourseRepository courseRepository,
                         InstructorRepository instructorRepository,
                         CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.categoryRepository = categoryRepository;
    }

    public CourseResponse createCourse(CourseCreateRequest courseRequest) {

        Instructor instructor = instructorRepository.findById(courseRequest.instructorId())
                .orElseThrow(InstructorNotFoundException::new);
        Category category = categoryRepository.findById(courseRequest.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        boolean check = courseRepository.existsByTitleAndInstructor(courseRequest.title(), instructor);
        HandleThrow.throwIf(check, CourseAlreadyExistException::new);

        Course course = CourseMapper.toEntity(courseRequest, instructor, category);

        courseRepository.save(course);

        return CourseMapper.toResponse(course);

    }

    public PaginatedResponse<CourseResponse> listCourses(CustomPagingRequest paging) {

        Pageable pageable = paging.toPageable(ALLOWED_SORT_FIELDS);

        Page<Course> page = courseRepository.findAll(pageable);

        List<CourseResponse> items = page.getContent()
                .stream()
                .map(CourseMapper::toResponse)
                .toList();

        PaginatedResponse.PageMeta meta = new PaginatedResponse.PageMeta(
                page.getNumber() + 1,               // tekrar 1-based'e çeviriyoruz
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.hasNext(),
                page.hasPrevious(),
                paging.sortBy(),
                paging.sortDirection()
        );

        return new PaginatedResponse<>(items, meta);
    }

    public Page<CourseListItem> searchCourses(CourseSearchRequest req,  Pageable pageable) {

        Specification<Course> spec = CourseSpecBuilder.build(req);

        return courseRepository.findBy(spec, q ->
                q.as(CourseListView.class)
                        .page(pageable))
                .map(v -> new CourseListItem(
                        v.getId(),
                        v.getTitle(),
                        v.getPrice(),
                        v.getCategory() != null ? v.getCategory().getName() : null ,
                        v.getInstructor() != null ? v.getInstructor().getName() : null
                ));

    }


}
