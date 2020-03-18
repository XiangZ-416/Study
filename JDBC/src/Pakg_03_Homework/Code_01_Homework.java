package Pakg_03_Homework;

import Utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @Description: 课后练习1：从控制台向数据库的表customers中插入一条数据，表结构如下：
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/18 21:50
 */
public class Code_01_Homework {

    @Test
    public void testInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名:");
        String name = scanner.next();
        System.out.print("请输入邮箱:");
        String email = scanner.next();
        System.out.print("请输入生日:");
        String birthday = scanner.next();

        String sql = "create into customers(name, email, birth)values(?, ?, ?)";
        int insertCount = CommonCDU(sql, name, email, birthday);
        if (insertCount > 0) {
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    // 通用的增、删、改操作（体现一：增、删、改 ； 体现二：针对于不同的表）
    public int CommonCDU(String sql, Object ... args){ // Object ... args：Object类型的可变参数类型（占位符的个数）
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
            /*
             * ps.execute():
             * 如果执行的是查询操作，有返回结果，则此方法返回true;
             * 如果执行的是增、删、改操作，没有返回结果，则此方法返回false.
             */
            return ps.executeUpdate(); // executeUpdate()：返回值是执行sql语句后影响的行数
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 5.关闭资源
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;
    }
}
