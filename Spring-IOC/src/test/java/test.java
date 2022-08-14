import com.spring.xml.Gather;
import com.spring.xml.T;
import com.spring.xml.User;
import com.spring.xml.beans.MyBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    void test_1(){
        Gather gather = new ClassPathXmlApplicationContext("application.xml")
                .getBean("gather", Gather.class);
        System.out.println(gather);
    }

    @Test
    void test_2(){
        T t = new ClassPathXmlApplicationContext("application.xml")
                .getBean("t", T.class);
        System.out.println(t);
    }

    @Test
    void test_3(){
        User myFactory_user = new ClassPathXmlApplicationContext("application.xml")
                .getBean("myFactory", User.class);
        System.out.println("myFactory_user = " + myFactory_user.getUserName());
    }

    @Test
    void test_4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        User test_user1 = context
                .getBean("testUser", User.class);
        User test_user2 = context
                .getBean("testUser", User.class);
        System.out.println(test_user1);
        System.out.println(test_user2);
    }
/*
*向下转型：一个已经向上转型的子类对象可以使用强制类型转换的格式，将父类引用类型转为子类引用各类型
          使用格式：子类类型 变量名=（子类类型） 父类类型的变量；
         适用场景：当要使用子类特有功能时。
* */
    @Test
    void test_5(){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        MyBean myBean = context.getBean("myBean", MyBean.class);
        System.out.println("6.已获取到myBean = " + myBean);
        context.close();
    }
}
