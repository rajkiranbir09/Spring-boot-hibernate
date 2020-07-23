package com.project.hibernate.config.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found")
public class NotFoundException extends Exception {

    private static final long serialVersionUID = 100L;

}