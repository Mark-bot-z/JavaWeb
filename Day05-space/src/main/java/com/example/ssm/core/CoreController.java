package com.example.ssm.core;

import com.example.ssm.UnableFindException;
import com.example.ssm.core.ioc.BeanFactory;
import com.example.ssm.core.view.ViewBaseServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author Mark-Z
 * @version 0.0.1
 * @date 2022/7/7
 * @implNote 核心控制器：处理各种请求和视图的转发
 */
@WebServlet(name = "CoreController", value = "*.do")
public class CoreController extends ViewBaseServlet {

    private final ThreadLocal<BeanFactory> beanFactory = new ThreadLocal<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        beanFactory.set((BeanFactory) context.getAttribute("ioc"));
        /*
         * 1.将拦截到的请求传给对应的控制器处理,在这之前需要加载配置文件
         * 2.同意获取参数以及视图处理
         * */
        String path = req.getServletPath();
        path = path.replace('/', ' ').trim().substring(0, path.indexOf(".do") - 1);

        Object beanController = beanFactory.get().getBean(path);

        /*
         * 根据携带的operator的值来对应各个方法
         * 1.获取这个controller的所有方法,根据请求携带的operator来调用的对应的方法
         * 2.根据这个方法所需要的一些参数来获取请求所有的携带的参数,传入这个方法并invoke,求得返回值
         * */
        String result = null;
        String operator = req.getParameter("operator");
        Method[] methods = beanController.getClass().getDeclaredMethods();
        boolean isFlag = true;
        for (Method method : methods) {

            if (method.getName().equals(operator)) {

                isFlag = false;
                method.setAccessible(true);
                Object[] valuesParameter = new Object[method.getParameters().length];
                int index = 0;
                for (Parameter parameter : method.getParameters()) {
                    String name = parameter.getName();//获取参数名
                    //获取参数类型名
                    switch (parameter.getType().getName()) {
                        case "java.lang.Integer":
                            if (req.getParameter(name) != null) {
                                valuesParameter[index] = Integer.parseInt(req.getParameter(name));
                                break;
                            }
                            valuesParameter[index] = 1;
                            break;
                        case "java.lang.String":
                            if (req.getParameter(name) != null) {
                                valuesParameter[index] = req.getParameter(name);
                                break;
                            }
                            valuesParameter[index] = "";
                            break;
                        case "javax.servlet.http.HttpServletRequest":
                            valuesParameter[index] = req;
                            break;
                        default:
                            throw new ServletException();
                    }
                    index++;
                }

                try {
                    result = (String) method.invoke(beanController, valuesParameter);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException();
                }
                break;
            }
        }
        if (isFlag){
            throw new UnableFindException("没有这样的方法 ---> " + operator);
        }
        review(req, resp, result);
    }

    private void review(HttpServletRequest req, HttpServletResponse resp, String result) throws IOException {
        /*
         * 根据返回的值来确定是怎么样的视图处理
         * */
        if (result != null) {
            int i = result.indexOf(":");
            String s = result.substring(0, i);
            switch (s) {
                case "html":
                    this.processTemplate(result.substring(i + 1), req, resp);
                    break;
                case "redirect":
                    resp.sendRedirect(result.substring(i + 1));
                    break;
                default:
                    throw new RuntimeException("页面转发无法执行！");
            }
        } else {
            throw new RuntimeException("result是空的！");
        }
    }
}
