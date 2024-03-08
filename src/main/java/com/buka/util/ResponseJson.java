package com.buka.util;

public class ResponseJson {
    private int code;
    private String msg;
    private Object data;

    public ResponseJson() {
    }

    public ResponseJson(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseJson getOK(String msg, Object o) {
        return new ResponseJson(200, msg, o);
    }

    public static ResponseJson getOK(Object o) {
        return new ResponseJson(200, "", o);
    }

    public static ResponseJson getOK() {
        return new ResponseJson(200,"成功", null);
    }

    public static ResponseJson getOK(int code, String msg) {
        return new ResponseJson(code, msg, null);
    }

    public static ResponseJson getOK(String msg) {
        return new ResponseJson(200, msg, null);
    }

    public static ResponseJson getError(String msg) {
        return new ResponseJson(-1, msg, null);
    }

    public static ResponseJson getError(int code, String msg) {
        return new ResponseJson(code, msg, null);
    }

    public static ResponseJson getError() {
        return new ResponseJson(-1, "请求错误", null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
