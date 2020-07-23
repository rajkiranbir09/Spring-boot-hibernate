package com.project.hibernate.exception;


import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class APIException extends ResponseException {

    private static final long serialVersionUID = -5962051580036174595L;

    private Integer errorCode;

    private HttpStatus httpStatus;

    private String APIPath;

    private String errorMessage;



}