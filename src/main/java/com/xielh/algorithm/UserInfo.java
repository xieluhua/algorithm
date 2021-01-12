package com.xielh.algorithm;

import java.util.Objects;

public class UserInfo {

    private Integer userId;
    private String userName;
    private Integer age;

    private String attribute1;

    private String attribute2;

    public UserInfo() {
    }

    public UserInfo(Integer userId, String userName, Integer age,String attribute1,String attribute2) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", age=" + age +
            ", attribute1='" + attribute1 + '\'' +
            ", attribute2='" + attribute2 + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInfo userInfo = (UserInfo) o;
        return userName.equals(userInfo.userName) &&
            age.equals(userInfo.age) &&
            attribute1.equals(userInfo.attribute1) &&
            attribute2.equals(userInfo.attribute2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, age, attribute1, attribute2);
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }
}
