package com.project.hibernate.utils;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


//public class Response<T> {
public class Reponse{

//    /**
//     * Status Message
//     */
//    private String status;
//
//    /**
//     * The Status Code
//     */
//    private int code;
//    /**
//     * The Data
//     */
//    private T data;
//
//    public Response(String status, int code, T data) {
//        this.status = status;
//        this.code = code;
//        this.data = data;
//    }
//
//    public static <T> ResponseEntity<Response<T>> success(T data) {
//        return new ResponseEntity<>(new Response<>("Success", 200, data), HttpStatus.OK);
//    }
//
//    public Response<T> success(String status, T data) {
//        return new Response<>(status, 200, data);
//    }
//
//    public Response<T> success(String status, int code, T data) {
//        return new Response<>(status, code, data);
//    }
//
//    public static <T> ResponseEntity<Response<T>> failure(String status) {
//        return new ResponseEntity<>(new Response<>(status, 500, null), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    public static <T> Response<T> failure(int code) {
//        return new Response<>("Internal Error", code, null);
//    }
//
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }

}