package com.jll.zoro.rxjava_retrofit.info;

/**
 * Created by Administrator on 2016/1/21.
 */
public class ResultModle {
    private String code;
    private String message;
    private String number;
    private ResultModle_1 data;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ResultModle_1 getData() {
        return data;
    }

    public void setData(ResultModle_1 data) {
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
