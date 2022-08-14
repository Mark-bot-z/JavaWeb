package com.spring.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/*
* 代替web.xml
* */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * @return 返回spring的配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * @return 返回servlet（spring mvc）的配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }


    /**
     * @return 返回dispartcherservlet的turl的映射
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }

    /**
     * 默认的拦截规则是以上面的url的映射为标准
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new CharacterEncodingFilter("utf-8",true,true),
                new HiddenHttpMethodFilter()
        };
    }
}
