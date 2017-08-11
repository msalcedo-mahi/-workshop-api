package com.workshop.rest;

import com.workshop.rest.dto.FirstDTO;
import com.workshop.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@RestController
@ControllerAdvice
@RequestMapping("/api/first")
public class FirstController {

    @Autowired
    FirstService firstService;


    @RequestMapping(method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public FirstDTO simpleRequest(){
        return firstService.getLastUpdatesInfo();
    }

}
