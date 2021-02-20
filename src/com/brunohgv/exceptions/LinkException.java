package com.brunohgv.exceptions;

public class LinkException extends Exception {
    private static final String LINK_EXCEPTION_FOR_CLASS_MESSAGE = "Missing @Link annotation to handle dependencies in %s";

    public LinkException(Class<?> clazz) {
        super(String.format(LINK_EXCEPTION_FOR_CLASS_MESSAGE, clazz.getName()));
    }
}
