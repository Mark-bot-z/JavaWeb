
import com.spring.mvc.daos.pojo.User;
import com.spring.mvc.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class UserTest {
    static UserService userService;

    static {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        userService = context.getBean("userService", UserService.class);
    }

    @Test
    void test_add(){
        userService.newUsers(new User("mark","在线"));
    }

    @Test
    void test_update(){
        userService.modifyUserInfo(1,new User("mark","离线"));
    }

    @Test
    void test_del(){
        userService.deleteTheSpecifiedUser(new User(2));
    }

    @Test
    void test_select_all_1(){
        userService.findNumberOfUser();
    }

    @Test
    void test_select_single_2(){
        userService.findUserInfo();
    }

    @Test
    void test_select_list_3(){
        for (User user : userService.findAllUserInfo()) {
            System.out.println(user);
        }
    }

    @Test
    void test_batch_add(){

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("张三","离线"));
        users.add(new User("李四","离线"));
        userService.newUsers(users);

    }

    @Test
    void test_batch_update(){

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(5,"张三","在线"));
        users.add(new User(6,"李四","在线"));
        userService.modifyUserInfo(users);

    }

    @Test
    void test_batch_del(){

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(5));
        users.add(new User(6));

        userService.deleteTheSpecifiedUser(users);
    }





}
