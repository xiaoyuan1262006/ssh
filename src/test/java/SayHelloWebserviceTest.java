import com.mavenpro.webservice.cxf.ISayHello;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * @author liuxiaoyuan
 * @Title: SayHelloWebserviceTest
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/7/31下午5:06
 */
public class SayHelloWebserviceTest {

    public static void main(String[] args) throws MalformedURLException{
        String nameSpace="http://cxf.webservice.mavenpro.com/";
        URL url=new URL("http://localhost:8080/mpp/webService/sayHello?wsdl");

        //WebService服务类注解@WebService参数serviceName的值
        final QName SERVICE_NAME = new QName(nameSpace, "SayHelloImplService");

        //WebService服务类注解@WebService参数name的值+”Port”
        final QName PORT_NAME = new QName(nameSpace, "SayHelloImplPort");
        //获取接口实例类
        javax.xml.ws.Service service=javax.xml.ws.Service.create(url, SERVICE_NAME);
        ISayHello inface=service.getPort(PORT_NAME, ISayHello.class);
        inface.write("nihao");

        String ss = inface.say();
        System.out.println(ss);
    }
}
