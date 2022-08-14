                        public  >   protected   >   (default)   >   private
    同一个类（我自己）        YES         YES             YES             YES
    同一个包（我邻居）        YES         YES             YES             NO
     不同包子类（我儿子）       YES         YES            NO              NO
    不同包非子类（陌生人）      YES         NO              NO              NO



    注意版本号！
    <!-- Spring依赖 -->
        <!-- 1.Spring核心依赖 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>4.3.7.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>4.3.7.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.3.7.RELEASE</version>
        </dependency>

    <!-- 2.Spring dao依赖 -->
    <!-- spring-jdbc包括了一些如jdbcTemplate的工具类 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>4.3.7.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>4.3.7.RELEASE</version>
        </dependency>

        <!-- 3.Spring web依赖 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>4.3.7.RELEASE</version>
        </dependency>

        <dependency>

            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>4.3.7.RELEASE</version>
        </dependency>

        <!-- 4.Spring test依赖：方便做单元测试和集成测试 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>4.3.7.RELEASE</version>
    　　</dependency>

    创建beans的方式有配置文件和注解的方式
    （1）配置文件（写法较为固定）：
           <?xml version="1.0" encoding="UTF-8"?>
           <beans xmlns="http://www.springframework.org/schema/beans"
                  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www
                                          .springframework.org/schema/beans/spring-beans.xsd">
           <!-- 类似于自定义ssm框架的兵工厂   -->
               <bean id="user" class="com.spring.xml.User"/>
           </beans>
    　　步骤：加载配置文件，获取到对象
