package com.mama.baike.service;

import org.apache.poi.ss.formula.functions.T;

public interface MongoService {
    /**
     * 保存数据
     */
    public void save(Object value ,String collectionName);

    /**
     * 查询对象
     */
    public T queryObject(Object id,Class<T> classType,String collectionName);
}
