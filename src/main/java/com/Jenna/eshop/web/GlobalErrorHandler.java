package com.Jenna.eshop.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jenna C He
 * @date 2023/1/6 13:58
 */

@ControllerAdvice
class GlobalErrorHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	ErrorInfo<String> r = new ErrorInfo<String>();  
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("自定义的全局异常处理");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

}