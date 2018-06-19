package com.mama.baike.dao.base;

import com.mama.baike.entity.page.PageQuery;

import java.util.List;
import java.util.Map;

public interface BaseDao<T,Q extends PageQuery> {

    void save(T t);

    void save(Map<String, Object> map);

    void saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int delete(Object id);

    int delete(Map<String, Object> map);

    int deleteBatch(Object[] id);

    T queryObject(Object id);

    List<T> queryList(Map<String, Object> map);

    List<T> queryList(Q q);

    int queryTotal(Map<String, Object> map);

    int queryTotal();
}

