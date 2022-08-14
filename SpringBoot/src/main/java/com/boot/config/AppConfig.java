package com.boot.config;

import com.boot.daos.pojo.Car;
import com.boot.daos.pojo.Pet;
import com.boot.daos.pojo.User;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.util.List;

//配置类==xxx.xml
// 也是组件也会加入到容器中
/*
 * boolean proxyBeanMethods() default true;
 * 默认开启对该类的代理对象，使得方法获取的对象在容器中只存在对应的单实例，
 * 反之内部手动调用方法，则会是普通方法，会有多实例
 * 设置为true能够保证组件依赖的时容器中的唯一存在
 * */

@Configuration(proxyBeanMethods = false)
//@ConditionalOnMissingBean 条件注解也可修饰在配置类上对整个类起决定性作用：当不存在某个指定的对象时才进行下一步
//@ImportResource() 导入配置文件
@EnableConfigurationProperties(Car.class)
//给指定的类开启配置绑定功能,并且将这个类注入容器
public class AppConfig {

    /*
     * 方法名就是组件的id
     * @Bean("pet")也可作为组件id
     * */
//    @ConditionalOnBean(value = Pet.class)//条件注解：ConditionalOnBean：当存在某个指定的对象时才进行下一步
    @Bean
    public User joinUser(Pet pet) {
//        内部组件依赖：proxyBeanMethods为false的情况下（代理对象没有产生），spring不会去容器中找pet
//        return new User("mark", joinPet());被@Bean标注的方法返回值最终还是会进入容器的
        return new User("mark", null);
    }

    @Bean("pet")
    public Pet joinPet() {
        return new Pet("tom");
    }

//    WebMvcConfigurer 定制化MVC的功能
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {

            //            自定义的内容协商
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//                configurer 中添加两种协商策略：基于请求参数、基于请求头的
                WebMvcConfigurer.super.configureContentNegotiation(configurer);
            }
            /*
            * 在解析被@ResponseBody修饰的返回值的过程中，看有没有能够匹配的协商策略
            *   1.遍历循环所有当前系统的 MessageConverter 找到支持操作的报文转换器，列出所有支持转换的媒体类型
            *   2.看哪一个MessageConverter能够转换这个策略，然后调用此方法
            * */
            //            对响应报文转换器的扩展
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//                converters中添加HttpMessageConverter的扩展类
                WebMvcConfigurer.super.extendMessageConverters(converters);
            }

//            请求转换器的扩展
            @Override
            public void addFormatters(FormatterRegistry registry) {
//                registry.addConverter(new Converter<Object, Object>() {
//                    @Override
//                    public Object convert(Object source) {
//                        return null;
//                    }
//                });
                WebMvcConfigurer.super.addFormatters(registry);
            }
        };
    }

}
