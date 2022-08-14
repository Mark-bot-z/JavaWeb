问题：GET http://localhost:8080/Spring_MVC/static/script/vue.js net::ERR_ABORTED 404

这个问题的解决方案：
	1、在spring-mvc.xml文件中进行如下配置：
		<!--开放资源（一般是静态资源）的访问-->
		<mvc:resourcesmapping="/js/**"location="/js/"/>
		或者
		<mvc:default-servlet-handler/>（推荐用这个）
	2、maven，clean清楚之前的编译
	3、maven， compile重新编译一下
	4、重新启动tomcat服务器


