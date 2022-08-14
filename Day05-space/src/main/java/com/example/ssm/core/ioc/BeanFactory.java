package com.example.ssm.core.ioc;

import com.example.ssm.core.CoreController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class BeanFactory implements BeanFactoryNorm {

    //映射各种bean的容器
    private static final HashMap<String, Object> beanMap = new HashMap<>();

    //ioc配置文件位置
    public static String path;

    /*加载配置文件*/
    public BeanFactory(){
        InputStream resource = CoreController.class.getClassLoader().getResourceAsStream(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            try {
                Document document = builder.parse(resource);
                //获取所有的bean标签(节点)
                NodeList list = document.getElementsByTagName("bean");
                for (int i = 0; i < list.getLength(); i++) {
                    Node item = list.item(i);
                    if (item.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) item;
                        try {
                            //抓取对应的类的对象
                            Class<?> aClass = Class.forName(element.getAttribute("class"));
                            try {
                                try {
                                    beanMap.put(element.getAttribute("id"), aClass.getConstructor().newInstance());
                                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //根据xml链接各个bean
                //获取对应的所有的rely标签(子节点)
                for (int i = 0; i < list.getLength(); i++) {
                    Node item = list.item(i);
                    if (item.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) item;
                        NodeList childNodes = element.getChildNodes();
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            if (childNodes.item(j).getNodeName().equals("rely")
                                && childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                Element elementChild = (Element)childNodes.item(j);
                                String relyName = elementChild.getAttribute("name");//获取依赖名
                                String relyValueID = elementChild.getAttribute("ref");//获取依赖值id
                                try {
                                    //给当前父节点（bean）的依赖名 装载依赖值
                                    Field id = beanMap.get(element.getAttribute("id")).getClass().getDeclaredField(relyName);
                                    id.setAccessible(true);
                                    try {
                                        id.set(beanMap.get(element.getAttribute("id")), beanMap.get(relyValueID));
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                } catch (NoSuchFieldException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new RuntimeException("容器中没有对应的实体,可能是xml文件未加载！");
        }
        return bean;
    }
}
