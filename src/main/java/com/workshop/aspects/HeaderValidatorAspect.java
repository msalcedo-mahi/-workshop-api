package com.workshop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 *
 */
@Aspect
@Component
public class HeaderValidatorAspect {


    @Before("execution(* com.pabisapi.module..*Controller.*(..))")
    public void createContextAndValidatePermissions(JoinPoint joinpoint) throws Throwable {


    }

}
