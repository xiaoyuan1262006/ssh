package com.mavenpro.webservice.cxf;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author liuxiaoyuan
 * @Title: ISayHello
 * @ProjectName mavenproject
 * @Description: webservice接口
 * @date 2018/7/31下午3:58
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ISayHello {

    public String say();

    public void write(String s);


}
