/*
package com.example.trade.advice;


import com.example.trade.exception.StudentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(StudentException.class)
    @ResponseBody
    public Response handleStudentException(HttpServletRequest request, StudentException ex) {
        Response response;
        log.error("StudentException code:{},msg:{}",ex.getResponse().getCode(),ex.getResponse().getMsg());
        response = new Response(ex.getResponse().getCode(),ex.getResponse().getMsg());
        return response;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleException(HttpServletRequest request, Exception ex) {
        Response response;
        log.error("exception error:{}",ex);
        response = new Response(ErrorCodeAndMsg.Network_error.getCode(),
                ErrorCodeAndMsg.Network_error.getMsg());
        return response;
    }
}
*/
