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
    // ��ʽ1��
    @Test
    public void testConnection1() throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver(); // ִ��ʱʱmysql��д�ķ���

        // jdbc:��Э��
        // mysql:��Э��
        // localhost:������
        // 3306:�˿ں�
        // test:���ݿ���
        String url = "jdbc:mysql://localhost:3306/test"; // urlͳһ��Դ��λ��

        // ���û����������װ��Properties��
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection conn = driver.connect(url, info); // ����ʱ��sun��˾�ƶ��ı�׼

        System.out.println(conn);
    }
}
