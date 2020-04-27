package Pakg_07_DatabaseConnectionPool.Pakg_01_Connection;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Description: //TODO 测试Druid数据库连接池
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/23 15:54
 */
public class Code_02_DruidTest {
    @Test
    public void getConnection() throws Exception{
        Properties pros = new Properties();

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Pakg_03_Spring/druid.properties");

        pros.load(is);

        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);

    }
}
