package com.bo.redis_demo.utils;
/*
 **
 ** create by bo
 ** 2018/12/4
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Result<T> {

    //状态码
    private int code;

    //描述
    private String msg;

    //数据
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long count;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object desc;

    public Result(){}
}
