package com.mama.baike.controller;

import com.mama.baike.common.ResultBody;
import com.mama.baike.entity.catalog.CatalogEntity;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/baike")
public class BaikeRestController {

    @Autowired
    private CatalogService catalogService;

    @RequestMapping("/test")
    public ResultBody wolcome()
    {
        ResultBody resultBody = new ResultBody();
        resultBody.setMessage("欢迎");
        resultBody.setData(200);
        return resultBody;
    }

    /**
     * 目录查询
     * @return
     */
    @RequestMapping("/catalog/index")
    public ResultBody indexCatalog(@RequestBody CatalogQuery catalogQuery)
    {
        List<CatalogEntity> catalogEntities =  catalogService.findCatalog(catalogQuery);
        ResultBody resultBody = new ResultBody();
        resultBody.setData(catalogEntities);
        return resultBody;
    }
}
