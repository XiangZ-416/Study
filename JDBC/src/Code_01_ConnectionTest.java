import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ZX
 * @date 2020/3/13 - 22:03
 */
public class Code_01_ConnectionTest {
    // 方式1：
    @Test
    public void testConnection1() throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver(); // 执行时时mysql重写的方法

        // jdbc:主协议
        // mysql:子协议
        // localhost:主机名
        // 3306:端口号
        // test:数据库名
        String url = "jdbc:mysql://localhost:3306/test"; // url统一资源定位符

        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection conn = driver.connect(url, info); // 编译时是sun公司制定的标准

        System.out.println(conn);
    }
}
