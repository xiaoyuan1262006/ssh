package com.mavenpro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuxiaoyuan
 * @Title: HelloController
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/7/30下午4:27
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


    //映射一个action
    @RequestMapping("/index")
    public  String index(){
        //输出日志文件
        logger.info("the first jsp pages");
        System.out.print("======");
        //返回一个index.jsp这个视图
        return "hello";
    }

}
