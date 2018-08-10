package com.mavenpro.service.impl;

import com.mavenpro.dao.OtherUserDao;
import com.mavenpro.dao.UserDao;
import com.mavenpro.entity.User;
import com.mavenpro.form.UserForm;
import com.mavenpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;


/**
 * @author liuxiaoyuan
 * @Title: UserServiceImpl
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/8下午12:52
 */
@Service
class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private OtherUserDao otherUserDao;


    @Override
    public String save(UserForm userForm) {
        User user = new User();
        user.setUserName(userForm.getUserName());
        user.setPassWord(userForm.getPassWord());
        user.setDescription(userForm.getDescription());
        return userDao.save(user);//;
    }

    @Override
    public String saveother(UserForm userForm) {

        for (int i = 10000; i < 10010; i++) {
            User user = new User();
            //this.user.setId(i+"");
            user.setUserName("cnds"+i);
            user.setPassWord("cnds"+i);
            this.otherUserDao.save(user);
        }

        return "success";
    }

    @Override
    public String deleteByIds(Serializable... ids) {

        otherUserDao.deleteByIds("402881856519a709016519a7e3ef0000","402881856519a709016519a8112f0001");
        return null;
    }


}
