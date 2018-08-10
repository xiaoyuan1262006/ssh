package com.mavenpro.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author liuxiaoyuan
 * @Title: BaseDaoSupper
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/8/8下午9:20
 */
public interface CommonDao<T>{
    public void save(T entity);

    public void deleteByIds(Serializable ... ids);

    public void deleteByList(List<T> list);

    public void update(T entity);

    public T getById(Serializable id);

    public List<T> queryAll();

    /**
     * 根据条件查询 并且按照指定的排序方式排序
     *
     * @param condition
     * @param params
     * @param orderby
     * @return
     */
    public List<T> queryCondition(String condition, Object[] params,
                                  Map<String, String> orderby);


    /**
     * 分页查询全部
     *
     * @param offset
     * @param length
     * @return
     */
    public List<T> queryAllPage(int offset, int length);
}
