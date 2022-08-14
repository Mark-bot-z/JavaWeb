#JDBC Template
    spring对jdbc进行封装、使用jdbctemplate方便实现对数据库的访问


###1.引入相关依赖
![img.png](template_md_img/img.png)

###2.配置数据库连接池
![img_1.png](template_md_img/img_1.png)

###3.创建JDBCTemplate对象并注入连接池
![img_2.png](template_md_img/img_2.png)

###4.创建测试类
![img_4.png](template_md_img/img_4.png)

(1)添加操作

- 单个添加

![img_5.png](template_md_img/img_5.png)
  
- 批量添加(batch)

  值得注意的是要用object对象数组封装一个user对象放入list集合

![img_12.png](template_md_img/img_12.png)

(2)修改操作

- 单个修改

![img_6.png](template_md_img/img_6.png)

- 批量修改(batch)

![img_14.png](template_md_img/img_14.png)


(3)删除操作

- 单个修改
  
  ![img_8.png](template_md_img/img_8.png)
  
- 批量删除(batch)

  ![img_15.png](template_md_img/img_15.png)

(4)查询操作 -- (在spring的jdbcTemplate的查询中RowMapper接口是关键)

        其中要通过RowMapper接口的映射器实现类来封装不同的数据类型

- 聚合查询(查询用户数量)
  
    ![img_9.png](template_md_img/img_9.png)
  
- 条件查询
    - 查询指定用户信息--返回单个对象
    
    ![img_10.png](template_md_img/img_10.png)
      
    - 查询指定用户信息--返回多个对象(集合)

    ![img_11.png](template_md_img/img_11.png)