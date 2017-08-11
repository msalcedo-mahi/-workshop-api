package com.workshop.interceptors;



public class AuthorizationPresentValidator implements Validation {


    private static final String HEADER_NAME = "Authorization";
    private static final String ERROR_MESSAGE = "Authorization does not contain Basic or Bearer token";

    @Override
    public Boolean isValidate(String content) {
        return content.contains("Basic") || content.contains("Bearer");
    }

    @Override
    public String getHeaderName() {
        return HEADER_NAME;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
