package com.mama.baike.controller.api;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.common.ResultBody;
import com.mama.baike.common.constants.WebMvcConstant;
import com.mama.baike.entity.user.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @ResponseBody
    @RequestMapping("/login")
    @AuthIgnore
    public ResultBody login(HttpServletRequest request, @RequestParam(value = "mobile") String mobile, @RequestParam(value = "verifyCode") String verifyCode)
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
}
