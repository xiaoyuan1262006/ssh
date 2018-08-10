package com.mavenpro.webservice.cxf;

import com.mavenpro.webservice.entity.User;

/**
 * @author liuxiaoyuan
 * @Title: UserWSImpl
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/1下午2:53
 */

public class UserWSImpl implements IUserWS {
    @Override
    public User getUserById(String id) {
        User user = new User();
        user.setId(id);
        user.setUserName("wangwu");
        user.setAge("14");
        user.setDescription("wangwu's age is 14");

        return user;
    }

    @Override
    public User createUser(User user) {
        User user1 = new User();
        user1.setId(user.getId());
        user1.setUserName(user.getUserName());
        user1.setAge(user.getAge());
        user1.setDescription(user.getDescription());
        return user1;
    }
}
