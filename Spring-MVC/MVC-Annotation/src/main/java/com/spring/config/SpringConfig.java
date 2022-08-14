package com.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/*
 * 作为application.xml的一部分
 * */
@Configuration
public class SpringConfig {

    @Bean
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        try {
            InputStream stream = SpringConfig.class
                    .getClassLoader()
                    .getResourceAsStream("static/pool_info.properties");
            Properties properties = new Properties();
            properties.load(stream);
            dataSource.setUrl(properties.getProperty("prop.url"));
            dataSource.setUsername(properties.getProperty("prop.username"));
            dataSource.setPassword(properties.getProperty("prop.password"));
            dataSource.setDriverClassName(properties.getProperty("prop.driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public JdbcTemplate setTemplate(DataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }
}
