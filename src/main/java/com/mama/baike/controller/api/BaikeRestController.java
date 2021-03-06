package com.mama.baike.controller.api;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.common.ResultBody;
import com.mama.baike.entity.catalog.CatalogEntity;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/baike")
public class BaikeRestController {

    @Autowired
    private CatalogService catalogService;

    /**
     * 目录查询
     * @return
     */
    @AuthIgnore
    @RequestMapping("/catalog/index")
    public ResultBody indexCatalog(@RequestBody CatalogQuery catalogQuery)
    {
        ResultBody resultBody = new ResultBody();
        List<CatalogEntity> catalogEntities =  catalogService.findCatalog(catalogQuery);
        resultBody.setData(catalogEntities);
        return resultBody;
    }
}
