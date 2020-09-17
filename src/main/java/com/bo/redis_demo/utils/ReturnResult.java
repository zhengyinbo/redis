package com.bo.redis_demo.utils;

/*
 ** 接口返回类
 ** create by bo
 ** 2019/5/14
 */

public class ReturnResult {

    public ReturnResult(){}

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return new ReturnResult().success(null);
    }

    public static Result success(Object object, Long count){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        result.setCount(count);
        return result;
    }

    public static Result success(Object object, Long count, Object o){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        result.setCount(count);
        result.setDesc(o);
        return result;
    }

    public static Result fail(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }


}
