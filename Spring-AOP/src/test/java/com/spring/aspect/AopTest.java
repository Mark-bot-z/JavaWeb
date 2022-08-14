package com.spring.aspect;

import com.spring.aspect.annotation.User;
import com.spring.aspect.xml.Book;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    void userAopTest_annotation() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        User user = context.getBean("user", User.class);
        user.say();
    }

    @Test
    void bookAopTest_xml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bookXml.xml");
        Book book_ = context.getBean("book_", Book.class);
        book_.getName();
    }
}
