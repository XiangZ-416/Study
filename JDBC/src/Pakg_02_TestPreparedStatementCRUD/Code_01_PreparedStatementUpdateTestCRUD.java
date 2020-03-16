package Pakg_02_TestPreparedStatementCRUD;

import Bean.Customer;
import Utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 使用PreparedStatement来替换Statement，实现对数据库表的增删改查操作
 * 增删改；查
 * @author ZX
 * @date 2020/3/16 - 10:57
 */
public class Code_01_PreparedStatementUpdateTestCRUD {
    // 1.向customers表中添加一条记录
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.获取连接
            conn = JDBCUtils.getConnection();

            // 2.预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into customers(name, email) values (?, ?)";
            ps = conn.prepareStatement(sql);

            // 3.填充占位符
            ps.setObject(1, "哪吒");
            ps.setObject(2, "nezha@gmail.com");

            // 4.执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭资源
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // 2.更改customers表中一条记录
    @Test
    public void testUpdate() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 获取数库连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PrepreStatement实例
            String sql = "UPDATE CUSTOMERS SET NAME = ? WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            ps.setObject(1, "莫扎特");
            ps.setObject(2, "18");
            // 4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5.资源关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // 3.删除customers表中一条记录
    @Test
    public void testDelete() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 获取数库连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PrepareStatement实例a
            String sql = "delete from customers where id = ?";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            ps.setObject(1, 20);
            // 4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5.资源关闭
            JDBCUtils.closeResource(conn, ps);
        }
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

    // 测试增删改的通用方法
    @Test
    public void testCommonDelete(){
        // 删除
//      String sql = "delete from customers where id = ?";
//      testCommon(sql, 3);

        // 添加
        String sql = "update `order` set order_name = ? where order_id = ?";
        CommonCDU(sql, "DD", "2");
    }

    /**
     * 针对customers表的查询操作
     */
    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数库连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，获取PreparedStatement的实例
            String sql = "select id, name from customers where id = ?";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            ps.setObject(1, 1);
            // 4.执行并返回结果集
            resultSet = ps.executeQuery();
            // 5.处理结果集(获取字段的值)
            if (resultSet.next()) { // 判断结果集的下一条是否有数据，如果有数据，返回true并且指针下移
                // 获取当前这条数据的各个字段的值
                int id = resultSet.getInt(1); // 查询到的第一个字段的值
                String name = resultSet.getString(2); // 查询到的第二个字段的值

                // 方式1:直接输出
                System.out.println("id = "+ id +"， name = "+ name +"");

                // 方式2：Object数组
                Object[] data = new Object[] {id, name};
                for (int i = 0; i < data.length; i++) {
                    System.out.print(data[i] + " ");
                }
                System.out.println();

                // 方式3：将数据封装为一个对象
                Customer customer = new Customer(id, name);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 6.关闭资源
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }

    // 针对customers表的通用查询操作（每次查的字段多少可能不一样）
    public Customer commonQForCustomers(String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 1.连获取数据库接
            conn = JDBCUtils.getConnection();
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
            // 5.处理结果集(获取字段的值)
            if (resultSet.next()) {
                Customer customer = new Customer(); // 表中的一条数据
                // 处理结果集中一行数据的各一个列
                for (int i = 0; i < columnCount; i++) { // 已经进入占位符要求的某一行，获取各个字段的值
                    // 获取第i + 1列的值
                    Object columnValue = resultSet.getObject(i + 1);
                    // 获取第i + 1列的列名
                    String columnName = metaData.getColumnName(i + 1);
                    // 给customer对象指定的columnNam的属性，赋值为columnValue，通过反射（指定运行时类的某个属性并赋值）
                    Field field = Customer.class.getDeclaredField(columnName); // 指定Customer类中columnName属性
                    field.setAccessible(true); // 拿到的属性可能为私有，设置为true确保可见
                    field.set(customer, columnValue); // 将customer对象的columnName属性设置为columnValue
                }
                return customer; // 查到了
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 6.关闭资源
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

        return null; // 没查到
    }

    @Test
    public void testCommonQForCustomers() {
        String sql = "select id, name from customers where id = ?";
        Customer customer = commonQForCustomers(sql, 13);
        System.out.println(customer);

        sql = "select id, name from customers where name = ?";
        Customer customer1 = commonQForCustomers(sql, "周杰伦");
        System.out.println(customer1);
    }

    // 针对Order表的通用查询操作（每次查的字段多少可能不一样）
    public Customer commonQForOrder(String sql, Object...args) {

        return null;
    }
}
