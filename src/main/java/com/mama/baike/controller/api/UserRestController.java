package com.mama.baike.controller.api;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.annotation.LoginUser;
import com.mama.baike.common.ResultBody;
import com.mama.baike.common.constants.WebMvcConstant;
import com.mama.baike.common.utils.RandomValidateCodeUtil;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.entity.user.UserQuery;
import com.mama.baike.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);


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

    /**
     * 生成验证码
     */
    @AuthIgnore
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>   ", e);
        }
    }

    /**
     * 忘记密码页面校验验证码
     */
    @AuthIgnore
    @RequestMapping(value = "/checkVerify")
    @ResponseBody
    public boolean checkVerify(HttpServletRequest request, HttpSession session) {
        try{
            //从session中获取随机数
            String inputStr = request.getParameter("verifyCode").toLowerCase();
            String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
            session.removeAttribute("RANDOMVALIDATECODEKEY");
            if (random == null) {
                return false;
            }
            if (random.toLowerCase().equals(inputStr)) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            logger.error("验证码校验失败", e);
            return false;
        }
    }
}
