package com.wxi.simplyclick.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    // 页面的重定向
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/homePage").setViewName("homePage");
        registry.addViewController("/searchPage").setViewName("searchPage");
        registry.addViewController("/developerPage").setViewName("developerPage");
        registry.addViewController("/registerPage").setViewName("registerPage");
        registry.addViewController("/filmEdit").setViewName("filmEdit");
        registry.addViewController("/castAdd").setViewName("castAdd");
        registry.addViewController("/forgetPassword").setViewName("forgetPassword");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/index.html", "/css/**", "/user/login", "/static/**","/images/**"
                        , "/user/register", "/user/forget", "/user/**", "/registerPage", "/forgetPassword");
    }

}
