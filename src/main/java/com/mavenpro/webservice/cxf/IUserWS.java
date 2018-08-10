package com.mavenpro.webservice.cxf;

import com.mavenpro.webservice.entity.User;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author liuxiaoyuan
 * @Title: UserWS
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/1下午2:52
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IUserWS {

    public User getUserById(String id);

    public User createUser(User user);
}
