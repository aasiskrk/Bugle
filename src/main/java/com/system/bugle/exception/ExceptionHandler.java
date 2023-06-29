package com.system.bugle.exception;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgsNotValid(MethodArgumentNotValidException methodArgumentNotValidException){
        methodArgumentNotValidException.printStackTrace();
        return "werror handles";
    }
}
