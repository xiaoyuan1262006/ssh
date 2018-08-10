package com.mavenpro.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuxiaoyuan
 * @Title: BaseDao
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/8下午12:27
 */
public interface BaseDao<T,PK extends Serializable> {


    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush(T entity);

}
