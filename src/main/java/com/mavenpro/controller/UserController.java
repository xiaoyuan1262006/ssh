package com.mavenpro.controller;

import com.mavenpro.form.UserForm;
import com.mavenpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liuxiaoyuan
 * @Title: UserController
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/8下午1:02
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "saveCommonUser", method = RequestMethod.GET)
    public String CommonsaveUser() {
        UserForm user = new UserForm();
        user.setUserName("wangwu");
        user.setPassWord("000000");
        user.setDescription("wangwu's  pw is 000000");
        String id = userService.saveother(user);
        System.out.println("user  id  is  "+id);
        return "userManager";
    }

    @RequestMapping(value = "savePerson", method = RequestMethod.GET)
    public String saveUser() {
        UserForm user = new UserForm();
        user.setUserName("wangwu");
        user.setPassWord("000000");
        user.setDescription("wangwu's  pw is 000000");
        String id = userService.save(user);
        System.out.println("user  id  is  "+id);
        return "userManager";
    }

    @RequestMapping(value = "deleteByIds", method = RequestMethod.GET)
    public String deleteUser() {

        userService.deleteByIds();
        System.out.println("delete user by id");
        return "userManager";
    }



}
