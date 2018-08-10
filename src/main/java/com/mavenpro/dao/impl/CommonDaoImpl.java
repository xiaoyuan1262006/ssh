package com.mavenpro.dao.impl;

import com.mavenpro.dao.CommonDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author liuxiaoyuan
 * @Title: OtherBaseDaoImpl
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/9下午3:18
 */
public class CommonDaoImpl<T> extends HibernateDaoSupport implements CommonDao<T> {

    /**
     * 注入SessionFactory
     *
     * @param sessionFactory
     */
    @Resource
    public final void setSessionFactoryDi(SessionFactory sessionFactory) {
//        this.getHibernateTemplate().setCheckWriteOperations(false);
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void save(Object entity) {
        this.getHibernateTemplate().save(entity);
    }

    @Override
    public void deleteByIds(Serializable... ids) {
        if (ids != null && ids.length > 0) {
            for (Serializable id:ids) {
                Object entity = this.getById(id);
                if (entity != null) {
                    this.getHibernateTemplate().delete(entity);
                }

            }
        }

    }

    @Override
    public void deleteByList(List list) {
        this.getHibernateTemplate().deleteAll(list);
    }

    @Override
    public void update(Object entity) {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public T getById(Serializable id) {
        return (T) this.getHibernateTemplate().get(this.getEntityClass(), id);
    }

    @Override
    public List queryAll() {
        return this.getHibernateTemplate().find(
                "from " + this.getEntityClass().getName());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<T> queryAllPage(final int offset,final int length) {
        // 获取类的名字
        final String className = this.getEntityClass().getName();
        return (List) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
            public Object doInHibernate(org.hibernate.Session session)
                    throws HibernateException {
                Query query = session.createQuery("from " + className);
                query.setFirstResult(offset);
                query.setMaxResults(length);
                return query.list();
            }
        });

    }

    /**
     * 根据条件查找多个对象并按照一定规则排序 这个方法拼接了一个HQL语句，要注意HQL语句的格式 参数介绍 String condition
     * 是预设的筛选条件的属性名 Object[] params 是对应预设的筛选条件的属性值，这里设置为Object数组是为了方便传参
     * Map<String, String> orderby 是存储设置的排序方式的信息的Map集合
     */
    @Override
    public List queryCondition(String condition, Object[] params, Map<String, String> orderby) {
        String hqlHeader = "from " + this.getEntityClass().getName() + " where 1=1";
        // 创建一个StringBuffer用来存储遍历Map的数据
        StringBuffer buffer = new StringBuffer("");
        if (orderby != null &&   orderby.size() > 0) {
            buffer.append(" order by ");
            for (Map.Entry<String, String> map : orderby.entrySet()) {
                buffer.append(" " + map.getKey() + " " + map.getValue() + ",");
            }
            // 遍历Map之后要删除最后一个逗号
            buffer.deleteCharAt(buffer.length() - 1);
        }
        // 拼接成完整的HQL语句
        String wholeHql = hqlHeader + condition + buffer.toString();

        return this.getHibernateTemplate().find(wholeHql,params);
    }

    /**
     * 这是一个获取当前元素真实类的方法 原理是通过反射机制 在下面的各项查找方法中都有应用
     *
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
    public Class getEntityClass() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        return (Class) pt.getActualTypeArguments()[0];
    }
}
