package com.mama.baike.controller.api;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.common.ResultBody;
import com.mama.baike.common.constants.WebMvcConstant;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.entity.user.UserQuery;
import com.mama.baike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    /**
     * 登录（用户名和密码）
     */
    @ResponseBody
    @RequestMapping("/login-by-pass")
    @AuthIgnore
    public ResultBody loginByPass(HttpServletRequest request,
                                  HttpServletResponse response,
                                  @RequestParam(value = "userName") String userName,
                                  @RequestParam(value = "userPass") String userPass)  throws Exception
    {
        ResultBody resultBody = new ResultBody();
        UserQuery userQuery = new UserQuery();
        userQuery.setUserName(userName);
        userQuery.setUserPass(userPass);

        UserEntity userEntity = userService.login(userQuery);
        if(userEntity == null)
        {
            resultBody.setCode(0);
            resultBody.setMessage("用户名或密码错误！");
            return resultBody;
        }
        HttpSession session = request.getSession();
        session.setAttribute(WebMvcConstant.LOGIN_USER_SESSION_KEY, userEntity.getId());

        resultBody.setMessage("登录成功");
        return resultBody;
    }

    /*
     *登录（手机验证码）
     */
    @ResponseBody
    @RequestMapping("/login-by-mobile")
    @AuthIgnore
    public ResultBody login(HttpServletRequest request,
                            @RequestParam(value = "mobile") String mobile,
                            @RequestParam(value = "verifyCode") String verifyCode)
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
     * 退出
     */
    @ResponseBody
    @RequestMapping("/login-out")
    public ResultBody loginOut(HttpServletRequest request, @LoginUser UserEntity userEntity)
    {
        ResultBody resultBody = new ResultBody();
        HttpSession session = request.getSession();
        session.removeAttribute(WebMvcConstant.LOGIN_USER_SESSION_KEY);
        resultBody.setMessage("退出成功");
        return resultBody;
    }
}
