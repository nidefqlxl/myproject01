package com.lxl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //告诉SpringBoot这是一个配置类 == 配置文件
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("main");
    }

    //自定义的国际化组件生效
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

    @Override
    //addPathPatterns("/**") 过滤所有请求; excludePathPatterns() 不用拦截的请求
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login","/index.html","/templates/*");
    }
}
