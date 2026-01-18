package com.queryhub.spring_queryhub.exception;

import com.queryhub.spring_queryhub.common.ErrorMessages;

public class InstructorNotFoundException extends RuntimeException {
    public InstructorNotFoundException() {
        super(ErrorMessages.INSTRUCTOR_NOT_FOUND);
    }
}
