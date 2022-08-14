package com.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mark-Z
 * @version 0.0.1
 * @date 2022/5/16
 * @implNote 作为工具类连接MySQL数据库-->微软那个一直报错，真就鸡鸡了
 */
public class ConnectionUtils {
    private static final Properties properties = new Properties();
    public static String properties_Path = "static/pool_info.properties";
    private static DataSource dataSource;

    //    .class.getClassLoader().getResourceAsStream("config/config.properties")
    static {
        try {
            InputStream stream = ConnectionUtils.class.getClassLoader().getResourceAsStream(properties_Path);
            properties.load(stream);
            //这种方式建议用于本地
//            properties.load(ClassLoader.getSystemResourceAsStream(properties_Path));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 悄悄地关闭
     *
     * @param connection 数据库连接对象
     */
    public static void close(java.sql.Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
