import com.mavenpro.webservice.cxf.IUserWS;
import com.mavenpro.webservice.entity.User;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author liuxiaoyuan
 * @Title: UserWSTest
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/1下午3:12
 */
public class UserWSTest {

    public static void main(String[] args) throws MalformedURLException {
        String nameSpace="http://cxf.webservice.mavenpro.com/";
        URL url=new URL("http://localhost:8080/mpp/webService/userWebservice?wsdl");

        //WebService服务类注解@WebService参数serviceName的值
        final QName SERVICE_NAME = new QName(nameSpace, "UserWSImplService");

        //WebService服务类注解@WebService参数name的值+”Port”
        final QName PORT_NAME = new QName(nameSpace, "UserWSImplPort");
        //获取接口实例类
        javax.xml.ws.Service service=javax.xml.ws.Service.create(url, SERVICE_NAME);
        IUserWS inface=service.getPort(PORT_NAME, IUserWS.class);
        User user = new User();
        user.setId("111");
        user.setUserName("xiaowang");
        user.setPassword("000000");
        user.setAge("10 years old");
        user.setDescription("xiaowang 10 years old !");

        User u = inface.createUser(user);
        System.out.println("u.Id = "+ u.getId() + " , u.description = "+u.getDescription());

        User u1 = inface.getUserById("110");
        System.out.println("u1.Id = "+ u1.getId() + " , u1.description = "+u1.getDescription());

    }
}
