package com.example.ssm.base;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mark-Z
 * @version 0.0.1
 * @date 2022/5/16
 * @implNote 通用的基础操作--->增删改查
 * |---------QueryRunner:sql语句执行类
 * |---------update(): 只接收增 删 改
 * |---------query(): 只接收 查
 */
@SuppressWarnings("unchecked")
public abstract class BaseMeans<T> {

    Class<T> tClass;
    {
        Type superclass = this.getClass().getGenericSuperclass();//最近父类的，不是它的爷爷或者爷爷的爷爷
        ParameterizedType type = (ParameterizedType)superclass;
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
        return queryRunner.query(connection,sql, new BeanHandler<>(tClass), args);
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
     * 查询总的记录条数
     * @return value
     */
    public Long getValue(Connection connection, String sql) throws SQLException{
        QueryRunner queryRunner = new QueryRunner();
//        只返回结果集第一行中的指定字段(通过构造器),未指定则是第一行的第一列的字段
        return queryRunner.query(connection,sql, new ScalarHandler<Long> () {
            @Override
            public Long handle(ResultSet rs) throws SQLException {
                Long value = null;
                if (rs.next()){
                    value = rs.getLong(1);
                }
                return value;
            }
        });
    }

}
