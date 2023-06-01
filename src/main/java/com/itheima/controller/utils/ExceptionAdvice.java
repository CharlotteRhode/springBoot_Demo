package com.itheima.controller.utils;


import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//异常处理器
@RestControllerAdvice
public class ExceptionAdvice {


    //拦截所有的异常
    @ExceptionHandler
    public Result meetException(Exception ex) {
        //拦截到异常以后，可以做很多事情了，比如：
        //记录日志
        //通知运维
        //通知开发...

        ex.printStackTrace();
        return new Result(false, "服务器故障，请练习管理员");

    }


}
