package com.mama.baike.controller;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.entity.catalog.CatalogEntity;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/baike")
public class BaikeController {

    @Autowired
    private CatalogService catalogService;

    @AuthIgnore
    @RequestMapping(value = "/catalog/baby")
    public ModelAndView baby(@LoginUser UserEntity user , CatalogQuery catalogQuery) throws ParseException {

        List<Map<String,Object>>  catalogMapList = new LinkedList<>();
        ModelAndView mav = new ModelAndView("/web/baike/baby2");

        List<CatalogEntity> catalogList = catalogService.findCatalog(catalogQuery);
        mav.addObject("cataloglist", catalogList);

        CatalogQuery catalogQueryTitle = new CatalogQuery();
        catalogQueryTitle.setParentId(catalogQuery.getId());
        List<CatalogEntity> catalogEntities = catalogService.findCatalog(catalogQueryTitle);
        mav.addObject("titlelist", catalogEntities);

        for (CatalogEntity catalogEntity : catalogEntities)
        {
            Map<String,Object> catalogMap = new HashMap<>();
            catalogMap.put("catalog",catalogEntity);

            catalogQueryTitle = new CatalogQuery();
            catalogQueryTitle.setParentId(catalogEntity.getId());
            catalogEntities = catalogService.findCatalog(catalogQueryTitle);

            catalogMap.put("catalogsublist",catalogEntities);

            catalogMapList.add(catalogMap);
        }
        mav.addObject("catalogmaplist", catalogMapList);

        //导航
        List<CatalogEntity> navList = catalogService.findNavList(catalogQuery);
        mav.addObject("navlist", navList);

        //宝宝导航
        CatalogQuery navCatalogQuery = new CatalogQuery();
        navCatalogQuery.setParentId(1);
        navList = catalogService.findCatalog(navCatalogQuery);
        mav.addObject("babynavlist", navList);

        navCatalogQuery = new CatalogQuery();
        navCatalogQuery.setParentId(2);
        navList = catalogService.findCatalog(navCatalogQuery);
        mav.addObject("edunavlist", navList);

        navCatalogQuery = new CatalogQuery();
        navCatalogQuery.setParentId(3);
        navList = catalogService.findCatalog(navCatalogQuery);
        mav.addObject("deseasenavlist", navList);

        navCatalogQuery = new CatalogQuery();
        navCatalogQuery.setParentId(4);
        navList = catalogService.findCatalog(navCatalogQuery);
        mav.addObject("lifenavlist", navList);

        navCatalogQuery = new CatalogQuery();
        navCatalogQuery.setParentId(5);
        navList = catalogService.findCatalog(navCatalogQuery);
        mav.addObject("ladynavlist", navList);

        navCatalogQuery = new CatalogQuery();
        navCatalogQuery.setParentId(6);
        navList = catalogService.findCatalog(navCatalogQuery);
        mav.addObject("useagenavlist", navList);



        return mav;
    }
}
