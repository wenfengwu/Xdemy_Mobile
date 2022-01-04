package com.xdemy.mobile_xdemy.utils;

public class JsonData {

    /**status code:
     * 0: success
     * 1:processing
     * -1: fails
     * */
    private Integer code;

    //object data
    private Object data;

    //information message
    private String msg;

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    //transaction successful
    public static JsonData bulidSuccess(){
        return new JsonData(0, null, null);
    }

    //transaction successful, return an object
    public static JsonData bulidSuccess(Object data){
        return new JsonData(0, data, null);
    }

    //transaction failed, return error message
    public static JsonData bulidError(String msg){
        return new JsonData(-1, null, msg);
    }

    //transaction failed, return status code and error message
    public static JsonData bulidError(Integer code, String msg){
        return new JsonData(code, null, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
