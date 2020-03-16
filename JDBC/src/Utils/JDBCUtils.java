package Utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作数据库的工具类
 * @author ZX
 * @date 2020/3/16 - 14:21
 */
public class JDBCUtils {
    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        // 1.读取配置文件（获取、加载、读）
        // 创建流对象获取配置文件:类名.ClassLoader.getSystemResourceAsStream("配置文件名称");
        InputStream configFile = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        // 加载配置文件
        Properties pros =  new Properties();
        pros.load(configFile); // 加载
        // 读
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driver = pros.getProperty("driver");

        // 2.加载驱动
        Class.forName(driver);

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

        return conn;
    }

    /**
     * 关闭连接和Statement的操作
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn, Statement ps){
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet resultSet) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
