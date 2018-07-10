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
import java.util.List;

@Controller
@RequestMapping("/baike")
public class BaikeController {

    @Autowired
    private CatalogService catalogService;

    @AuthIgnore
    @RequestMapping(value = "/catalog")
    public ModelAndView index(@LoginUser UserEntity user , HttpServletRequest request) throws ParseException {

        ModelAndView mav = new ModelAndView("web/baike/baike2");
        mav.addObject("hometitle","你好");
        return mav;
    }
    @AuthIgnore
    @RequestMapping(value = "/baby")
    public ModelAndView baby(@LoginUser UserEntity user , HttpServletRequest request) throws ParseException {

        ModelAndView mav = new ModelAndView("web/baike/baby2");

        CatalogQuery catalogQuery = new CatalogQuery();
        catalogQuery.setParentId(1);
        List<CatalogEntity> catalogEntities =  catalogService.findCatalog(catalogQuery);
        mav.addObject("titlelist","你好");
        return mav;
    }
}
