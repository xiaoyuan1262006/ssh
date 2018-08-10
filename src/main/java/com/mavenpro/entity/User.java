package com.mavenpro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author liuxiaoyuan
 * @Title: User
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/7上午9:51
 */
@Entity
@Table(name="m_user")
public class User extends BaseEntity{

    private String userName ;

    private String passWord;

    private String description;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
