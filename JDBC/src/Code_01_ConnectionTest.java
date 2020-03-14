import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC获取数据库连接的5种方式
 * @author ZX
 * @date 2020/3/13 - 22:03
 */
public class Code_01_ConnectionTest {
    // 方式1：4步
    @Test
    public void testConnection1() throws SQLException {

        // 1.提供java.sql.Driver接口实现类的对象
        // 缺点：出现第三方程序mysql，程序移植性不好
        Driver driver = new com.mysql.jdbc.Driver(); // 执行时是mysql重写的方法

        // 2.提供url，指明具体操作的数据
        // jdbc:主协议
        // mysql:子协议
        // localhost:主机名
        // 3306:端口号
        // test:数据库名
        String url = "jdbc:mysql://localhost:3306/test"; // url统一资源定位符

        // 3.提供Properties的对象，指明用户名和密码
        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        // 4.调用driver的connect()，获取连接
        Connection conn = driver.connect(url, info); // 编译时是sun公司制定的标准

        System.out.println(conn);
    }
    // 方式2：对方式1的迭代
    @Test
    public void testConnection2() {

    }
}
