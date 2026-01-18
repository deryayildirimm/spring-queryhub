package com.queryhub.spring_queryhub.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleNotFound(CategoryNotFoundException ex, HttpServletRequest request) {

        return err(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(InstructorNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleNotFound(InstructorNotFoundException ex, HttpServletRequest request) {
        return err(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(CourseAlreadyExistException.class)
    public ResponseEntity<ProblemDetail> handleCourseAlreadyExist(CourseAlreadyExistException ex, HttpServletRequest request) {
        return err(HttpStatus.CONFLICT, ex.getMessage(), request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> globalExceptionHandler(Exception ex, HttpServletRequest request) {
        return err(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request);
    }

    private ResponseEntity<ProblemDetail> err(HttpStatus status, String message, HttpServletRequest request) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, message);
        problemDetail.setInstance(URI.create(request.getRequestURI()));
        return ResponseEntity.status(status).body(problemDetail);
    }

}
