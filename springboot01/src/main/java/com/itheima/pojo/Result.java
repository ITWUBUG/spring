package com.itheima.pojo;

public class Result {
    private Integer code;
    private String mes;
    private String data;

    public Result() {
    }

    public Result(Integer code, String mes, String data) {
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

    public String getData() {
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
}
