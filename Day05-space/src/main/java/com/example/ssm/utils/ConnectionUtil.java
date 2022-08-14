package com.example.ssm.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mark-Z
 * @version 0.0.1
 */
public final class ConnectionUtil {
    private static final Properties properties = new Properties();
    //用于保存不同线程的连接对象,即不同用户的一次事务中的连接对象应该是相同的
    /*他的底层就是用当前用户线程来保存数据的*/
    private static final ThreadLocal<Connection> local = new ThreadLocal<>();
    public static String properties_Path = "static/pool_info.properties";
    private static DataSource dataSource;

    static {

        try {
            InputStream stream = ConnectionUtil.class.getClassLoader().getResourceAsStream(properties_Path);
            properties.load(stream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ConnectionUtil() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            if (local.get() != null) {
                if (local.get().isClosed()) {
                    connection = dataSource.getConnection();
                    local.set(connection);
                }
                return local.get();
            } else {
                connection = dataSource.getConnection();
                local.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 悄悄地关闭
     *
     * @param connection 数据库连接对象
     */
    public static void close(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
