package com.mama.baike.config;


import com.mama.baike.intercepter.AuthenticationInterceptor;
import com.mama.baike.resolver.LoginUserHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * MVC Web端配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Autowired
    private LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;

    @Override
    public void setApplicationContext(ApplicationContext var1)
    {
        applicationContext = var1;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //web端权限校验和签名校验
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/**");
              //  .excludePathPatterns("/js/**","/imgs/**","/login/**");

        super.addInterceptors(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserHandlerMethodArgumentResolver);
    }

    // error page错误地址配置
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
      return new EmbeddedServletContainerCustomizer(){
        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
          container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
          container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
          container.addErrorPages(new ErrorPage(Throwable.class,"/error/500"));
        }
      };
    }
}