package com.queryhub.spring_queryhub.exception;

import com.queryhub.spring_queryhub.common.ErrorMessages;

public class CourseAlreadyExistException extends RuntimeException {

    public CourseAlreadyExistException() {
        super(ErrorMessages.COURSE_ALREADY_EXISTS);
    }
}
