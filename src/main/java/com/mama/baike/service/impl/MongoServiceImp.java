package com.mama.baike.service.impl;

import com.mama.baike.entity.mongo.ContentEntity;
import com.mama.baike.service.MongoService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public <T>T queryObject(Object id,Class classType,String collectionName)
    {
        Query query = Query.query(Criteria.where("uuid").is(id));
        List<T> list = mongoTemplate.find(query,classType,collectionName);;
        if(list.isEmpty())
        {
            return null;
        }
        return  list.get(0);
    }

    /**
     * 查询对象
     */
    public ContentEntity queryObject(Object id)
    {
        Query query = Query.query(Criteria.where("uuid").is(id));
        List<ContentEntity> list = mongoTemplate.find(query, ContentEntity.class,"content");;
        if(list.isEmpty())
        {
            return null;
        }
        return  list.get(0);
    }


}
