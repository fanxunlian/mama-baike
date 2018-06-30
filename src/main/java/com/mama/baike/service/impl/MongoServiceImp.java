package com.mama.baike.service.impl;

import com.mama.baike.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service("mongoService")
public class MongoServiceImp implements MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;




}
