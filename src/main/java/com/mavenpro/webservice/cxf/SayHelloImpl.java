package com.mavenpro.webservice.cxf;

/**
 * @author liuxiaoyuan
 * @Title: SayHelloImpl
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/7/31下午4:02
 */
public class SayHelloImpl  implements ISayHello{
    @Override
    public String say() {
        return "hello, my name is liu";
    }

    @Override
    public void write(String s) {

        System.out.println("I'm write " + s);
    }
}
