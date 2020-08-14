package com.huayu.ssm;

import org.apache.shiro.crypto.hash.SimpleHash;


public class test {
    public static void main(String[] args) {
        Object result = new SimpleHash("MD5","a123456");
        System.out.println(result);
    }
}
