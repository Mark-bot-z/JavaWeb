package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.servlet.http.HttpServletRequest;

//@Import({User.class, SimpleDateFormat.class})//默认组件的名字就是全类名，这个注解要加在配置注解和组件注解上才有效
@SpringBootApplication
/*
* 原因分析： @SpringBootApplication --> @EnableAutoConfiguration
*
* --> @AutoConfigurationPackage(加载该程序类所在的包的所有（用户的）配置类（里头的方法进行组件注入）)
*
* --> @Import({AutoConfigurationImportSelector.class}) 加载spring-boot自己规定的自动配置类（选择性的加载）
*
* 注意：其中配置类所要注入的组件应该要满足先决条件：@ConditonalXXX的约定,包括配置类自己，才能将这个对象注入
*
* 总的来说：(优先加载用户自己的、然后就是spring的，然而这一切发生在容器创建之后)加载配置类--->创建组件
* （被@EnableConfigurationProperties修饰的属性配置绑定类也会在application.properties找到对应的值完成赋值，放入容器）
* --> 结束
* */
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);





//        AppConfig appConfig = run.getBean(AppConfig.class);
//
//        System.out.println(appConfig.joinUser(null));
//        System.out.println(appConfig.joinUser(null));
//
//        System.out.println(run.getBean(User.class));
//        System.out.println(run.getBean(User.class));


//        System.out.println(run.getBean(Pet.class));

//        System.out.println(run.getBean(SimpleDateFormat.class));
//        System.out.println(run.getBean(User.class));

//        System.out.println(run.containsBean("pet"));



    }

}
