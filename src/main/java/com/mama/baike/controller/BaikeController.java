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
@RequestMapping("/baike")
public class BaikeController {
    @AuthIgnore
    @RequestMapping(value = "/catalog")
    public ModelAndView index(@LoginUser UserEntity user , HttpServletRequest request) throws ParseException {

        ModelAndView mav = new ModelAndView("web/baike/baike2");
        mav.addObject("hometitle","你好");
        return mav;
    }
}
