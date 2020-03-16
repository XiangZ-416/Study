package Pakg_00_TestConnection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC��ȡ���ݿ����ӵ�5�ַ�ʽ�����շ�ʽ5��
 * �ĸ�������Ϣ��driver��url��user��password
 * @author ZX
 * @date 2020/3/13 - 22:03
 */
public class Code_01_ConnectionTest {
    // ��ʽ1��4��
    @Test
    public void testConnection1() throws SQLException {

        // 1.�ṩjava.sql.Driver�ӿ�ʵ����Ķ���
        // ȱ�㣺ֱ�ӳ��ֵ���������mysql��������ֲ�Բ���
        Driver driver = new com.mysql.jdbc.Driver(); // ��̬��ִ��ʱ��mysql��дDriver�ķ���

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
    // ��ʽ2���Է�ʽ1�ĵ���:�����µĳ����в����ֵ�������api��ʹ����������õĿ���ֲ��
    @Test
    public void testConnection2() throws Exception {
        // 1.��ȡDriver��ʵ�������ʹ�÷���
        // ����mysql��ʵ��
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        // ��ȡdriver���ʵ��
        Driver driver = (Driver) clazz.newInstance();

        // 2.�ṩurl��ָ���������������
        String url = "jdbc:mysql://localhost:3306/test";

        // 3.�ṩProperties�Ķ���ָ���û���������
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        // 4.����driver��connect()����ȡ����
        Connection conn = driver.connect(url, info); // ����ʱ��sun��˾�ƶ��ı�׼

        System.out.println(conn);
    }

    // ��ʽ3������DriverManager�滻Driver
    @Test
    public void testConnection3() throws Exception {
        // 1.��ȡDriverʵ�������
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.�ṩ����3�����ӵĻ�����Ϣ
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        // 3.ע������
        DriverManager.registerDriver(driver);

        // 4.��ȡ����
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);
    }

    // ��ʽ4������ֻ�Ǽ�����������Ҫ��ʾ��ע������
    @Test
    public void testConnection4() throws Exception {
        // 1.�ṩ����3�����ӵĻ�����Ϣ
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        // 2.����mysql��Driver
        // mysql��̬��������Լ�ע������
        Class.forName("com.mysql.jdbc.Driver");

        // 3.��ȡ����
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);
    }

    // ��ʽ5�����հ�
    // �����ݿ�������Ҫ��4��������Ϣ�ŵ������ļ��У�ͨ����ȡ�����ļ��ķ�ʽ����ȡ����
    // ʹ�������ļ��ĺô���
    // �� ʵ���˴�������ݵķ��루����������Ҫ�޸�������Ϣ��ֱ���������ļ����޸ģ�����Ҫ������룻
    // �� ����޸���������Ϣ��ʡȥ���±���Ĺ��̡�
    @Test
    public void testConnection5() throws Exception {
        // 1.��ȡ�����ļ�����ȡ�����ء�����
        // �����������ȡ�����ļ�:����.ClassLoader.getSystemResourceAsStream("�����ļ�����");
        InputStream configFile = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        // ���������ļ�
        Properties pros =  new Properties();
        pros.load(configFile); // ����
        // ��
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driver = pros.getProperty("driver");

        // 2.��������
        Class.forName(driver);

        // 3.��ȡ����
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}