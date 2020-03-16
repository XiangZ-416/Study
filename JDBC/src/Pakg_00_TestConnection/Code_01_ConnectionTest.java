package Pakg_00_TestConnection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC获取数据库连接的5种方式（掌握方式5）
 * 四个基本信息：driver、url、user、password
 * @author ZX
 * @date 2020/3/13 - 22:03
 */
public class Code_01_ConnectionTest {
    // 方式1：4步
    @Test
    public void testConnection1() throws SQLException {

        // 1.提供java.sql.Driver接口实现类的对象
        // 缺点：直接出现第三方程序mysql，程序移植性不好
        Driver driver = new com.mysql.jdbc.Driver(); // 多态：执行时是mysql重写Driver的方法

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
    // 方式2：对方式1的迭代:在如下的程序中不出现第三方的api，使程序具有练好的可移植性
    @Test
    public void testConnection2() throws Exception {
        // 1.获取Driver，实现类对象，使用反射
        // 创建mysql类实体
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        // 获取driver类的实例
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供url，指明具体操作的数据
        String url = "jdbc:mysql://localhost:3306/test";

        // 3.提供Properties的对象，指明用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        // 4.调用driver的connect()，获取连接
        Connection conn = driver.connect(url, info); // 编译时是sun公司制定的标准

        System.out.println(conn);
    }

    // 方式3：利用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {
        // 1.获取Driver实现类对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供另外3个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        // 3.注册驱动
        DriverManager.registerDriver(driver);

        // 4.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);
    }

    // 方式4：可以只是加载驱动，不要显示的注册驱动
    @Test
    public void testConnection4() throws Exception {
        // 1.提供另外3个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        // 2.加载mysql的Driver
        // mysql静态代码块中自己注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);
    }

    // 方式5：最终版
    // 将数据库连接需要的4个基本信息放到配置文件中，通过读取配置文件的方式，获取连接
    // 使用配置文件的好处：
    // ① 实现了代码和数据的分离（解耦）。如果需要修改配置信息，直接在配置文件中修改，不需要深入代码；
    // ② 如果修改了配置信息，省去重新编译的过程。
    @Test
    public void testConnection5() throws Exception {
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
    }
}