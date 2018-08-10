package com.mavenpro.webservice.entity;

import java.io.Serializable;

/**
 * @author liuxiaoyuan
 * @Title: User
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/1下午2:46
 */
@SuppressWarnings("serial")
public class User implements Serializable{
    private String id;

    private String userName;

    private String password;

    private String age;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
