package com.mama.baike.service;

import com.mama.baike.entity.mongo.ContentEntity;
import org.apache.poi.ss.formula.functions.T;

public interface MongoService {
    /**
     * 保存数据
     */
    public void save(Object value ,String collectionName);

    /**
     * 查询对象
     */
    public <T>T queryObject(Object id,Class classType,String collectionName);
    /**
     * 查询对象
     */
    public ContentEntity queryObject(Object id);
}
