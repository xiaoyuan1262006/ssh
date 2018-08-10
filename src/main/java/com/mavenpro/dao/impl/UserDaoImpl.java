package com.mavenpro.dao.impl;

import com.mavenpro.dao.UserDao;
import com.mavenpro.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuxiaoyuan
 * @Title: UserDaoImpl
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/8下午12:34
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public User load(String id) {
        return (User) this.getCurrentSession().load(User.class,id);
    }

    @Override
    public User get(String id) {
        return (User) this.getCurrentSession().get(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void persist(User entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public String save(User entity) {
        return (String) this.getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(User entity) {
        getCurrentSession().saveOrUpdate(entity);

    }

    @Override
    public void delete(String id) {

        getCurrentSession().delete(id);
    }

    @Override
    public void flush(User entity) {

        getCurrentSession().flush();
    }

}
