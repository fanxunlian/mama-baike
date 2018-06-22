package com.mama.baike.intercepter;


import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.common.constants.WebMvcConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

/**
 *  登录 验证
 * @author chenyingyi
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	/*
	@Autowired
	private CcoopfsProperty ccoopfsProperty;
	*/
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AuthIgnore annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthIgnore.class);
        }else{
            return true;
        }

        //如果有@IgnoreAuth注解，则不验证
        if(annotation != null){
            return true;
        }
      
        HttpSession session = request.getSession();
		Object loginUserId =  session.getAttribute(WebMvcConstant.LOGIN_USER_SESSION_KEY);
		if(loginUserId == null){
			//throw new GlobalException("请登录系统");
				
			StringBuffer url = new StringBuffer(request.getRequestURI());
			if(StringUtils.isNotEmpty(request.getQueryString())){
				url.append("?");
				url.append(request.getQueryString());
			}

			response.sendRedirect("/user/personal/login?redirectUrl="+URLEncoder.encode(url.toString(), "utf-8"));
			return false;
		}else{
			return true;
		}
    }
}