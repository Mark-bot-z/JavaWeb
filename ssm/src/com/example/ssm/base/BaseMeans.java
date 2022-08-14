package com.example.ssm.base;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Mark-Z
 * @version 0.0.1
 */
@SuppressWarnings("unchecked")
public abstract class BaseMeans<T> {

    Class<T> tClass;

    {
        Type superclass = this.getClass().getGenericSuperclass();//最近父类的，不是它的爷爷或者爷爷的爷爷
        ParameterizedType type = (ParameterizedType) superclass;
        //@SuppressWarnings("unchecked")压制泛型转换警告
        tClass = (Class<T>) type.getActualTypeArguments()[0];
    }

    /**
     * 基本的新增操作
     *
     * @param connection 数据库连接对象
     * @param sql        INSET执行语句
     * @param args       具体的占位符
     * @return 状态值
     * @throws SQLException 过程中可能出现的SQL 异常
     */

    protected int addRecord(Connection connection, String sql, Object... args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        return queryRunner.update(connection, sql, args);
    }

    /**
     * 基本的删除操作
     *
     * @param connection 数据库连接对象
     * @param sql        DELETE执行语句
     * @param args       具体的占位符
     * @return 状态值
     * @throws SQLException 过程中可能出现的SQL 异常
     */
    protected int deleteRecord(Connection connection, String sql, Object... args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        return queryRunner.update(connection, sql, args);
    }

    /**
     * 基本的修改操作
     *
     * @param connection 数据库连接对象
     * @param sql        UPDATE执行语句
     * @param args       具体的占位符
     * @return 状态值
     * @throws SQLException 过程中可能出现的SQL 异常
     */
    protected int updateRecord(Connection connection, String sql, Object... args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        return queryRunner.update(connection, sql, args);
    }

    /**
     * 基本的查询操作: 查询某一条记录
     *
     * @param connection 数据库连接对象
     * @param sql        SELECT执行语句
     * @param args       具体的占位符
     * @return 封装成对象的记录
     * @throws SQLException 过程中可能出现的SQL 异常
     */
    protected T selectRecordSingle(Connection connection, String sql, Object... args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        return queryRunner.query(connection, sql, new BeanHandler<>(tClass), args);
    }


    /**
     * 基本的查询操作: 查询多条记录
     *
     * @param connection 数据库连接对象
     * @param sql        SELECT执行语句
     * @param args       具体的占位符
     * @return 由多条记录对象构成的集合
     * @throws SQLException 过程中可能出现的SQL 异常
     */
    protected List<T> selectRecordMany(Connection connection, String sql, Object... args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        return queryRunner.query(connection, sql, new BeanListHandler<>(tClass), args);
    }

    /**
     * 返回首行首列的值
     *
     * @return value type--->Long
     */
    public Long getValue(Connection connection, String sql) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
//        只返回结果集第一行中的指定字段(通过构造器),未指定则是第一行的第一列的字段
        return queryRunner.query(connection, sql, new ScalarHandler<Long>() {
            @Override
            public Long handle(ResultSet rs) throws SQLException {
                Long value = null;
                if (rs.next()) {
                    value = rs.getLong(1);
                }
                return value;
            }
        });
    }

    /**
     * 返回单列数据的集合
     *
     * @param tClass 镜子
     * @param label  列名
     * @return K[] 数组
     */
    public <K> K[] getValues(Connection connection, Class<K> tClass, String label, String sql) throws SQLException {
//        只返回结果集第一行中的指定字段(通过构造器),未指定则是第一行的第一列的字段
        return new QueryRunner() {
            @Override
            public <V> V query(Connection conn, String sql, ResultSetHandler<V> rsh) throws SQLException {
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = stmt.executeQuery(sql);
                return rsh.handle(resultSet);
            }
        }.query(connection,
                sql,
                (ResultSetHandler<K[]>) resultSet -> {
                    int index = 0;
                    resultSet.last();//先将游标移动到最后一行统计出行数
                    K[] ks = (K[]) Array.newInstance(tClass, resultSet.getRow());
                    resultSet.first();
                    ks[index++] = resultSet.getObject(label, tClass);
                    while (resultSet.next()) {
                        ks[index++] = resultSet.getObject(label, tClass);
                    }
                    return ks;
                }
        );
    }
}
