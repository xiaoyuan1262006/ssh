package com.mavenpro.service;

import com.mavenpro.form.UserForm;

import java.io.Serializable;

/**
 * @author liuxiaoyuan
 * @Title: UserService
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/8下午12:51
 */
public interface UserService {

    String save(UserForm user);

    String saveother(UserForm user);

    String deleteByIds(Serializable... ids);

}
