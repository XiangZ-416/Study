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
    // ��ʽ1��4��
    @Test
    public void testConnection1() throws SQLException {

        // 1.�ṩjava.sql.Driver�ӿ�ʵ����Ķ���
        Driver driver = new com.mysql.jdbc.Driver(); // ִ��ʱ��mysql��д�ķ���

        // 2.�ṩurl��ָ���������������
        // jdbc:��Э��
        // mysql:��Э��
        // localhost:������
        // 3306:�˿ں�
        // test:���ݿ���
        String url = "jdbc:mysql://localhost:3306/test"; // urlͳһ��Դ��λ��

        // 3.�ṩProperties�Ķ���ָ���û���������
        // ���û����������װ��Properties��
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        // 4.����driver��connect()����ȡ����
        Connection conn = driver.connect(url, info); // ����ʱ��sun��˾�ƶ��ı�׼

        System.out.println(conn);
    }
}
