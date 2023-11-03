package com.itheima.pojo;

import java.util.Objects;

public class Result {
    private Integer code;
    private String mes;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String mes, Object data) {
        this.code = code;
        this.mes = mes;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Object getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", mes='" + mes + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    //增删改查 成功响应(不需要响应数据返回前端)
    public static Result success() {
        return new Result(1, "success", null);
    }

    //增删改查 成功响应(需要响应数据返回前端)
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }
    //增删改查 失败响应(失败的具体原因需要响应给前端)
    public static Result error(String msg) {
        return new Result(0, msg,null );
    }
}
