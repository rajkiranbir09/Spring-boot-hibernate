package com.project.hibernate.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg, Throwable thro){
        super(msg,thro);
    }

    public BadRequestException(String msg){
        super(msg);
    }

}