package com.huayu.ssm.exception;

public class MyExecption extends Exception{
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MyExecption{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
