package com.mama.baike.controller.api;

import com.mama.baike.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoRestController {

    @Autowired
    private MongoService mongoService;


}