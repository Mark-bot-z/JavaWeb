package com.admin.config;

import com.admin.intercepters.A_Intercepter;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    /**
     * 1、编写一个拦截器实现HandlerInterceptor接口
     * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
     * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
     */

    @Bean
    public WebMvcConfigurer WebMvcConfigurer(){

        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(@NotNull InterceptorRegistry registry) {
                registry.addInterceptor(new A_Intercepter())
                        .addPathPatterns("/**")  //所有请求都被拦截包括静态资源
                        .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**"); //放行的请求
            }
        };
    }


}
