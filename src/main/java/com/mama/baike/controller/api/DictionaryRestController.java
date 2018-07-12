package com.mama.baike.controller.api;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.common.ResultBody;
import com.mama.baike.entity.system.DictionaryEntity;
import com.mama.baike.entity.system.DictionaryQuery;
import com.mama.baike.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary")
public class DictionaryRestController {

    @Autowired
    private DictionaryService dictionaryService;

    @AuthIgnore
    @RequestMapping("/index")
    public ResultBody indexDictionary(@RequestBody DictionaryQuery dictionaryQuery)
    {
        ResultBody resultBody = new ResultBody();
        List<DictionaryEntity> dictionaryEntityList = dictionaryService.findDictionaryList(dictionaryQuery);
        resultBody.setData(dictionaryEntityList);
        return resultBody;
    }

    @AuthIgnore
    @RequestMapping("/code")
    public ResultBody indexDictionary(String code)
    {
        ResultBody resultBody = new ResultBody();
        String value= dictionaryService.findDictionaryByCode(code);
        resultBody.setData(value);
        return resultBody;
    }

}
