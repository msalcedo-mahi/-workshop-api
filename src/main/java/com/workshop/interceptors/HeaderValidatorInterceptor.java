package com.workshop.interceptors;

import com.workshop.exceptions.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;


@Component
public class HeaderValidatorInterceptor  extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<Validation> validations = Arrays.asList(new ContentTypeAcceptedValidator(), new AuthorizationPresentValidator());

        for (Validation validation: validations){
            String headerValue = request.getHeader(validation.getHeaderName());
            if(headerValue == null){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                throw new BadRequestException("The header " + validation.getHeaderName() + " does not exist!");
            }
            if(!validation.isValidate(headerValue)){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                throw new BadRequestException(validation.getErrorMessage());
            }
        }
        return true;
    }
}