package com.spring.aspect.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class UserProxy {

    @Pointcut(value = "execution(* com.spring.aspect.annotation.User.say(..))")
    void point(){
    }

    //前置通知
    @Before(value = "point()")
    public void beforeSay() {
        System.out.println("你刚才说啥？");
    }

    //后置通知 -- 被增强方法执行完后，这个方法就会接着执行
    @AfterReturning(value = "point()")
    public void afterReturningSay() {
        System.out.println("好吧！");
    }

    //环绕通知
    @Around(value = "point()")
    public void aroundSay(ProceedingJoinPoint p) throws Throwable {
        System.out.println("对话开始时间：" + LocalDateTime.now().getYear() + "年-"
                           + LocalDateTime.now().getMonth() + "月-"
                           + LocalDateTime.now().getDayOfMonth() + "天"
        );
        p.proceed();
        System.out.println("对话结束时间：" + LocalDateTime.now().getYear() + "年-"
                           + LocalDateTime.now().getMonth() + "月-"
                           + LocalDateTime.now().getDayOfMonth() + "天"
        );
    }

    //异常通知
    @AfterThrowing(value = "point()")
    public void exceptionSay() {
        System.out.println("电话怎么挂了？算了");
    }

    //最终通知 -- finally
    @After(value = "point()")
    public void finallySay() {
        System.out.println("-------------");
    }
}
