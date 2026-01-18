package com.queryhub.spring_queryhub.exception;

import java.util.function.Supplier;

public class HandleThrow  {

    public static void throwIf(boolean condition, Supplier<RuntimeException> exceptionSupplier ){
        if (condition) {
            throw exceptionSupplier.get();
        }
    }
}
