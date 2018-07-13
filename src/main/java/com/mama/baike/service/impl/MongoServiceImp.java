package com.mama.baike.service.impl;

import com.mama.baike.service.MongoService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


@Service("mongoService")
public class MongoServiceImp implements MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存数据
     */
    public void save(Object value ,String collectionName)
    {
        mongoTemplate.insert(value,collectionName);
    }

    /**
     * 查询对象
     */
    public T queryObject(Object id,Class<T> classType,String collectionName)
    {
        return  mongoTemplate.findById(id,classType,collectionName);
    }


}
