package com.xdemy.mobile_xdemy.exception;

//customize exception
public class CusException extends RuntimeException{
    //status code
    private Integer code;

    private String msg;

    public CusException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
