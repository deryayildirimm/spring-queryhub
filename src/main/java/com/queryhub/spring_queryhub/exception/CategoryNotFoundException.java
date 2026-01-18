package com.queryhub.spring_queryhub.exception;

import com.queryhub.spring_queryhub.common.ErrorMessages;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super(ErrorMessages.CATEGORY_NOT_FOUND);
    }
}
