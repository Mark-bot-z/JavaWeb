import com.spring.xml.Book;
import com.spring.xml.Head;
import com.spring.xml.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Beans {
    @Test
    void testXml_1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        User user = context.getBean("user", User.class);
        user.say();
    }

    @Test
    void testXml_2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Head  head =  context.getBean("head", Head.class);
        System.out.println(head.getEye());
    }

    @Test
    void testXml_3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Book book =  context.getBean("book", Book.class);
        System.out.println(book.getBookName());

    }


}
