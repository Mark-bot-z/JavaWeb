import com.spring.mvc.daos.pojo.User;
import com.spring.mvc.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

public class Trans {

    static UserService userService;

    static {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        userService = context.getBean("userService", UserService.class);
    }

    @Test
    void test1() throws Exception{
        userService.transfer(new User(1),100,new User(4));
    }

    @Test
    void test2() throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationXml.xml");
        userService = context.getBean("userService", UserService.class);
        userService.transfer(new User(1),100,new User(4));
    }
}
