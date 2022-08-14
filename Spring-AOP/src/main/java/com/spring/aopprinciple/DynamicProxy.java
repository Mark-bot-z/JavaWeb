package com.spring.aopprinciple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DynamicProxy {

    static ProxyFactory proxyFactory;

    static {
        proxyFactory = new ProxyFactory();
    }

//    @Deprecated
    public static <T> T createProxy(T t){
        return proxyFactory.getProxyInstance(t);
    }

    private DynamicProxy(){
    }
}

@SuppressWarnings("unchecked")
class ProxyFactory{
    private static Object object;

    public <T> T getProxyInstance(T o){
        object = o;
        MethodImplementHandler methodHandler = new MethodImplementHandler();
        //返回一个对应的代理对象：这个对象不管执行什么方法，它都会执行方法处理器中的invoke方法，也是唯一的
        return (T) Proxy.newProxyInstance(
                o.getClass().getClassLoader(),//获取被代理对象的类加载器
                o.getClass().getInterfaces(),//获取被代理对象所实现的接口
                methodHandler//针对于被代理对象的方法执行处理器
        );
    }
    /*
     * 通过代理工厂中的方法处理器实现方法的增强
     * */
    public static class MethodImplementHandler implements InvocationHandler{
        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            Object methodResult = method.invoke(object, objects);//需要增强的方法
            /*
             * 加入的增强逻辑写在了需要增强的方法的后面，并且改写了返回值
             * */
            methodResult = true;
            System.out.println("现在是登录成功的 <-----");
            return methodResult;
        }
    }
}