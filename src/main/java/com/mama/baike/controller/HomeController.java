package com.mama.baike.controller;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.entity.user.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Controller
public class HomeController {

    @AuthIgnore
    @RequestMapping(value = { "/index", "/" })
    public ModelAndView index(@LoginUser UserEntity user , HttpServletRequest request) throws ParseException {

        ModelAndView mav = new ModelAndView("web/home/index");
        mav.addObject("redirect", "/index");
        mav.addObject("hometitle","你好");
        return mav;
    }
}
