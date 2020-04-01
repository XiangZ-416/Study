package Pakg_06_DAO;

import Utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: //TODO 封装了针对数据表的通用操作CRUD的抽象类
 * DAO
 * Data Access Object访问数据信息的类和接口，包括了对数据的CRUD（Create、Retrival、Update、Delete），而不包含任何业务相关的信息。有时也称作：BaseDAO
 * 作用：为了实现功能的模块化，更有利于代码的维护和升级。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/22 14:16
 */
public abstract class BaseDAO<T> {

    private Class<T> clazz = null;

    {
        // 获取当前BaseDAO的子类继承父类中的泛型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;

        Type[] typeArguments = paramType.getActualTypeArguments();// 获取符类泛型参数
        clazz = (Class<T>) typeArguments[0];// 获取泛型的第一个参数
    }


    // 通用的增删改操作---version 2.0 （考虑上事务）
    public void CommonCDU(Connection conn, String sql, Object... args) {// sql中占位符的个数与可变形参的长度相同！
        PreparedStatement ps = null;
        try {
            // 1.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            // 2.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);// 小心参数声明错误！！
            }
            // 3.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.资源的关闭
            JDBCUtils.closeResource(null, ps);
        }
    }

    //通用的查询操作，用于返回数据表中的一条记录（version 2.0：考虑上事务）
    public T CommonQuery(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t = clazz.newInstance();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);

                    // 获取每个列的列名
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);

        }
        return null;
    }

    // 针对不同表的通用查询操作
    // 返回表的多条记录 V2.0 考虑事务
    public List<T> CommonQueries(Connection conn, String sql, Object...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 1.连获取数据库接（外面获取）
            // 2.预编译sql语句，返回prepareStatement对象
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 4.执行并返回结果集
            resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData(); // 获取结果集的元数据（修饰结果集）
            int columnCount = metaData.getColumnCount(); // 通过结果集元数据获取结果集的列数
            // 创建集合对象
            ArrayList<T> list = new ArrayList<>();
            // 5.处理结果集(获取字段的值)
            while (resultSet.next()) {
                T t = clazz.newInstance(); // 类加载机制（利用javaBean类的空参public构造器）
                // 处理结果集中一行数据的各一个列
                for (int i = 0; i < columnCount; i++) { // 已经进入占位符要求的某一行，获取各个字段的值
                    // 获取第i + 1列的值
                    Object columnValue = resultSet.getObject(i + 1);
                    // 获取第i + 1列的列名
//                  String columnName = metaData.getColumnName(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    // 给customer对象指定的columnNam的属性，赋值为columnValue，通过反射（指定运行时类的某个属性并赋值）
                    Field field = clazz.getDeclaredField(columnLabel); // 指定Customer类中columnName属性
                    field.setAccessible(true); // 拿到的属性可能为私有，设置为true确保可见
                    field.set(t, columnValue); // 将customer对象的columnName属性设置为columnValue
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 6.关闭资源
            JDBCUtils.closeResource(null, ps, resultSet);
        }
        return null;
    }

    // 用于查询表中特殊值的方法
    public <E> E getValue(Connection conn,  String sql, Object...args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0;  i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return (E) resultSet.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null, ps, resultSet);
        }
        return null;
    }
}
