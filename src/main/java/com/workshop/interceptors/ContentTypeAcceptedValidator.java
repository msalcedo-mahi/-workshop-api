package com.workshop.interceptors;



public class ContentTypeAcceptedValidator implements Validation {

    private static final String HEADER_NAME = "Content-Type";
    private static final String CONTENT_TYPE_ACCEPTED = "application/json";
    private static final String ERROR_MESSAGE = "The content-type is not application/json";

    @Override
    public Boolean isValidate(String content) {
        return content.equals(CONTENT_TYPE_ACCEPTED);
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
