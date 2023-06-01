package com.itheima.controller.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Boolean flag;
    private Object data;
    private String msg;

    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }


}
