package Pakg_02_PreparedStatement;

import Pakg_01_StatementCRUD.User;
import Utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @Description: 演示PreparedStatement替换Statement解决sql注入问题
 * PreparedStatement为什么能解决sql注入问题？
 *      因为有预编译sql语句，预编译就是提前执行失去了语句，后来再填占位符，不会改变where后面语句的逻辑
 * 除了解决Statement的拼串、sql问题之外，PreparedStatement还有哪些好处呢？
 *      1.PreparedStatement操作Blob（流）的数据，而Statement做不到。
 *      2.PreparedStatement可以实现更高效的批量操作。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/18 20:38
 */
public class Code_02_PreparedStatementAdvantage {
    @Test
    public void testLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String user = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();

        // 用Statement输入password为=1 or时即使密码不对，也会登录成功。利用了关键字or，非法登录
//      String sql = "SELECT user,password FROM user_table WHERE user = '1' or ' AND password = '=1 or '1' = '1'";
        String sql = "SELECT user, password FROM user_table WHERE user = ? AND password = ?";
        User returnUser = CommonQuery(User.class, sql, user, password);
        if (returnUser != null) {
            System.out.println("登陆成功");
        }else {
            System.out.println("用户名不存在或密码错误");
        }
    }

    // 针对不同表的通用查询操作(一个javaBean类代表一个表，同Class代表要查的表（类），具体是什么类用泛型T表示)
    // 返回表中的一条记录
    public <T> T CommonQuery(Class<T> clazz, String sql, Object...args){
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
                return t; // 查到了
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 6.关闭资源
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

        return null; // 没查到
    }
}
