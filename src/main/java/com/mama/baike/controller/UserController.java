package com.mama.baike.controller;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.common.ResultBody;
import com.mama.baike.common.constants.WebMvcConstant;
import com.mama.baike.entity.catalog.CatalogEntity;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.entity.user.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/go-login")
    @AuthIgnore
    public ModelAndView loginView(@LoginUser UserEntity userEntity,
                                  @RequestParam(value = "redirectUrl", required = false) String redirectUr)
    {
        ModelAndView mav = new ModelAndView("web/user/login");
        if (userEntity != null) {
            mav.setViewName("redirect:web/home/index");
            return mav;
        }
        mav.addObject("redirectUrl", redirectUr);
        mav.addObject("isLogined", true);
        return mav;
    }
    /**
     * 个人账户信息
     */
    @RequestMapping("/account")
    public ModelAndView accountInfo(@LoginUser UserEntity user) {
        ModelAndView mav = new ModelAndView("web/user/account");
        mav.addObject("isLogined", true);
        return mav;
    }
}
