package com.geekkk.springdemo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMsg productNotFoundHandler(ProductNotFoundException e) {
        ErrorMsg errorMsg = new ErrorMsg(HttpStatus.NOT_FOUND, e.getMessage());
        return errorMsg;
    }
}
