package com.huayu.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user")
public class User {
    @TableId(value = "userId",type = IdType.AUTO)
    private Integer userId;
    @TableField("userName")
    private String userName;

    private String userSFZ;

    private String userPhone;

    private String userPassWord;

    private String userSex;

    private Integer userAge;

    private String userImg;

    private String userAddress;

    private Integer userStateId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSFZ() {
        return userSFZ;
    }

    public void setUserSFZ(String userSFZ) {
        this.userSFZ = userSFZ;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getUserStateId() {
        return userStateId;
    }

    public void setUserStateId(Integer userStateId) {
        this.userStateId = userStateId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSFZ='" + userSFZ + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userImg='" + userImg + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userStateId=" + userStateId +
                '}';
    }
}