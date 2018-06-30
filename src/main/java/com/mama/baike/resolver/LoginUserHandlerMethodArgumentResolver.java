package com.mama.baike.resolver;


import com.mama.baike.annotation.LoginUser;
import com.mama.baike.common.constants.WebMvcConstant;
import com.mama.baike.entity.user.UserEntity;
import com.mama.baike.entity.user.UserQuery;
import com.mama.baike.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * 解析器
 * 有@LoginUser注解的方法参数，注入当前登录用户
 * @author chenzhenyi
 */
@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserHandlerMethodArgumentResolver.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(UserEntity.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {

        //获取用户ID
        Object sessionLoginUserId = request.getAttribute(WebMvcConstant.LOGIN_USER_SESSION_KEY, RequestAttributes.SCOPE_SESSION);
        Object tokenLoginUserId = request.getAttribute(WebMvcConstant.LOGIN_USER_TOKEN_KEY, RequestAttributes.SCOPE_REQUEST);
        Object loginUserId = null;

        if(sessionLoginUserId == null && tokenLoginUserId == null){
            return null;
        }

        if(sessionLoginUserId != null){
        	loginUserId = sessionLoginUserId;
        }

        if(tokenLoginUserId != null){
        	loginUserId = tokenLoginUserId;
        }

        //获取用户信息
        UserQuery userQuery = new UserQuery();
        userQuery.setId((Integer) loginUserId);
        UserEntity userEntity = userService.findUser(userQuery);
        return userEntity;
    }
}
