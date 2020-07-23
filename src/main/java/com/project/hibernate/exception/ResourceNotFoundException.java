package com.project.hibernate.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException {

    public ResourceNotFoundException(String msg, Throwable thro){

        super(msg,thro);

    }

    public ResourceNotFoundException(String msg){

        super(msg);

    }

}