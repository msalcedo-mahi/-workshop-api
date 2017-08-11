package com.workshop.interceptors;

public interface Validation {

    Boolean isValidate(String content);
    String getHeaderName();
    String getErrorMessage();
}
