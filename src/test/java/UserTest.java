import com.mavenpro.dao.OtherUserDao;
import com.mavenpro.entity.User;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxiaoyuan
 * @Title: UserTest
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/9下午6:19
 */
public class UserTest {

    private ApplicationContext context;

    private User user;

    private OtherUserDao otherUserDao;

    /**
     * 在测试前先注入
     */
    @Before("")
    private void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        user = (User) context.getBean("user");
        otherUserDao = (OtherUserDao) this.context
                .getBean("userInfoDaoImpl");
    }

    /**
     * 测试保存
     */
    @Test
    public void testSave() {
        for (int i = 10000; i < 10010; i++) {
            //this.user.setId(i+"");
            this.user.setUserName("cnds"+i);
            this.user.setPassWord("cnds"+i);
            this.otherUserDao.save(user);
        }
    }

    /**
     * 测试根据ID删除
     */
    @Test
    public void testDeleteByIds() {
        this.otherUserDao.deleteByIds(10000, 10001);
    }

    /**
     * 测试根据集合删除
     */
    @Test
    public void testDeleteByList() {
        // 创建一个集合
        List<User> list = new ArrayList<User>();
        // 获取Id为10002的数据
        this.user = this.otherUserDao.getById(10002);
        // 向集合添加数据
        list.add(this.user);
        // 获取Id为10003的数据
        this.user = this.otherUserDao.getById(10003);
        // 向集合添加数据
        list.add(this.user);
        // 删除数据
        this.otherUserDao.deleteByList(list);
    }

    /**
     * 测试更新数据
     */
    @Test
    public void testUpate() {
        // 获取原有数据
        this.user = this.otherUserDao.getById(10004);
        System.out.println("更新前用户名：" + this.user.getUserName());
        this.user.setUserName("cnds.net");
        // 更新数据
        this.otherUserDao.update(this.user);
        // 查看更新后的数据
        this.user = this.otherUserDao.getById(10004);
        System.out.println("更新后用户名：" + this.user.getUserName());
    }

    /**
     * 测试根据ID查询
     */
    @Test
    public void testQueryById() {
        this.user = this.otherUserDao.getById(10004);
        System.out.println("更新前用户名：" + this.user.getUserName());
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testQueryAll() {
        List<User> list = this.otherUserDao.queryAll();
        for (User userInfo : list) {
            System.out.println("用户名：" + userInfo.getUserName());
        }
    }

    /**
     * 测试根据条件查询
     */
    @Test
    public void testQueryCondition() {
        // 这里注意设置条件的时候一定要加有and
        String condition = " and username=? ";
        Object[] params = { "cnds.net" };
        Map<String, String> orderby = new HashMap<String, String>();
        orderby.put(" id ", " DESC ");
        List<User> list = this.otherUserDao.queryCondition(
                condition, params, orderby);
        for (User userInfo : list) {
            System.out.println("用户名:" + userInfo.getUserName());
        }
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testQueryAllPage() {
        for (int i = 0; i < 10; i++) {
            List<User> list = this.otherUserDao.queryAllPage(
                    i * 2, 2);
            if (list.size() == 0) {
                break;
            } else {
                System.out.println("第 " + (i + 1) + " 页");
                for (User userInfo : list) {
                    System.out.println(userInfo.getUserName());
                }
            }
        }
    }
}
