import com.spring.annotation.config.SpringConfig;
import com.spring.annotation.mvc.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test2 {

    @Test
    void test_1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationAnnotation.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.login();
    }

    /*
    * 完全注解开发测试
    * */
    @Test
    void test_2(){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.login();
    }
}
