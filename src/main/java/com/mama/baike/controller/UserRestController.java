package com.mama.baike.controller;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.common.ResultBody;
import com.mama.baike.common.constants.WebMvcConstant;
import com.mama.baike.entity.catalog.CatalogEntity;
import com.mama.baike.entity.catalog.CatalogQuery;
import com.mama.baike.entity.user.UserEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @ResponseBody
    @RequestMapping("/test")
    public ResultBody test(@LoginUser UserEntity userEntity)
    {
        ResultBody resultBody = new ResultBody();
        return resultBody;
    }

    @ResponseBody
    @RequestMapping("/login")
    @AuthIgnore
    public ResultBody login(HttpServletRequest request,@RequestParam(value = "mobile") String mobile, @RequestParam(value = "verifyCode") String verifyCode)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1111);

        HttpSession session = request.getSession();
        System.out.println("login:"+session.getId());
        session.setAttribute(WebMvcConstant.LOGIN_USER_SESSION_KEY, userEntity.getId());

        ResultBody resultBody = new ResultBody();
        resultBody.setData(userEntity);
        return resultBody;
    }
    /**
     * 个人用户登录页面
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/login/show")
    @AuthIgnore
    public ModelAndView showLoginUser(@LoginUser UserEntity user,
                                              @RequestParam(value = "redirectUrl", required = false) String redirectUrl) {
        ModelAndView mav = new ModelAndView();
        if(user!=null) {
            mav.setViewName("redirect:/web/index");
            return mav;
        }
        mav.setViewName("/web/user/login");
        mav.addObject("redirectUrl", redirectUrl);
        mav.addObject("isLogined", true);
        return mav;
    }
}
