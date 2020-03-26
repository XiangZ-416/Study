package Pakg_05_Transaction;

import Pakg_01_StatementCRUD.User;
import Utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @Description:
 *
 *  1.什么叫数据库事务？
 *  事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。
 *  	> 一组逻辑操作单元：一个或多个DML操作。
 *
 *  2.事务处理的原则：保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
 *   当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些修改就永久地保存
 *   下来；要么数据库管理系统将放弃所作的所有修改，整个事务回滚(rollback)到最初状态。
 *
 *  3.数据一旦提交，就不可回滚
 *
 *  4.哪些操作会导致数据的自动提交？
 *   	>DDL操作一旦执行，都会自动提交。
 *   		>set autocommit = false 对DDL操作失效
 *   	>DML默认情况下，一旦执行，就会自动提交。
 *   		>我们可以通过set autocommit = false的方式取消DML操作的自动提交。
 *   	>默认在关闭连接时，会自动的提交数据
 *
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/20 17:50
 */
public class TransactionTest {

    //******************未考虑数据库事务情况下的转账操作**************************
    /*
     * 针对于数据表user_table来说：
     * AA用户给BB用户转账100
     *
     * update user_table set balance = balance - 100 where user = 'AA';
     * update user_table set balance = balance + 100 where user = 'BB';
     */
    @Test
    public void testUpdate(){

        String sql1 = "update user_table set balance = balance - 100 where user = ?";
        CommonCDU(sql1, "AA");

        //模拟网络异常
        System.out.println(10 / 0);

        String sql2 = "update user_table set balance = balance + 100 where user = ?";
        CommonCDU(sql2, "BB");

        System.out.println("转账成功");
    }


    // 通用的增、删、改操作（体现一：增、删、改 ； 体现二：针对于不同的表）
    public void CommonCDU(String sql, Object ... args){ // Object ... args：Object类型的可变参数类型（占位符的个数）
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.获取数据库的连接
            conn = JDBCUtils.getConnection();

            // 2.获取PreparedStatement的实例 (或：预编译sql语句)
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]); // 数据库是从1开始的，数组是从0开始的
            }

            // 4.执行sql语句
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 5.关闭资源
            JDBCUtils.closeResource(conn, ps);
        }
    }

    //********************考虑数据库事务后的转账操作*********************
    @Test
    public void testUpdateWithTx() {
        Connection conn = null;
        try {
            // 1.获取数据库连接
            conn = JDBCUtils.getConnection();
            // 2.开启事务
            conn.setAutoCommit(false);
            // 3.进行数据库操作
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            CommonCDU(conn, sql1, "AA");
            // 模拟网络异常
            //System.out.println(10 / 0);
            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            CommonCDU(conn, sql2, "BB");
            // 4.若没有异常，则提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 5.若有异常，则回滚事务
            try {
                assert conn != null;
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                }
        } finally {
            try {
            //6.恢复每次DML操作的自动提交功能
            assert conn != null;
            conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //7.关闭连接
            JDBCUtils.closeResource(conn, null, null);
        }
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


    //*****************************************************
    @Test
    public void testTransactionSelect() throws Exception{

        Connection conn = JDBCUtils.getConnection();
        //获取当前连接的隔离级别
        System.out.println(conn.getTransactionIsolation());
        //设置数据库的隔离级别：
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        //取消自动提交数据
        conn.setAutoCommit(false);

        String sql = "select user,password,balance from user_table where user = ?";
        User user = CommonQuery(conn, User.class, sql, "CC");

        System.out.println(user);

    }

    @Test
    public void testTransactionUpdate() throws Exception{
        Connection conn = JDBCUtils.getConnection();

        //取消自动提交数据
        conn.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        CommonCDU(conn, sql, 5000,"CC");

        Thread.sleep(15000);
        System.out.println("修改结束");
    }


    //*****************************************************
    @Test
    public void TransactionSelect() throws Exception{

        Connection conn = JDBCUtils.getConnection();
        //获取当前连接的隔离级别
        System.out.println(conn.getTransactionIsolation());
        //设置数据库的隔离级别：
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        //取消自动提交数据
        conn.setAutoCommit(false);

        String sql = "select user,password,balance from user_table where user = ?";
        User user = CommonQuery(conn, User.class, sql, "CC");

        System.out.println(user);

    }

    @Test
    public void TransactionUpdate() throws Exception{
        Connection conn = JDBCUtils.getConnection();

        //取消自动提交数据
        conn.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        CommonCDU(conn, sql, 5000,"CC");

        Thread.sleep(15000);
        System.out.println("修改结束");
    }

    //通用的查询操作，用于返回数据表中的一条记录（version 2.0：考虑上事务）
    public <T> T CommonQuery(Connection conn,Class<T> clazz,String sql, Object... args) {
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
}
