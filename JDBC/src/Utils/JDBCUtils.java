package Utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * �������ݿ�Ĺ�����
 * @author ZX
 * @date 2020/3/16 - 14:21
 */
public class JDBCUtils {
    /**
     * ��ȡ���ݿ�����
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
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

        return conn;
    }

    /**
     * �ر����Ӻ�Statement�Ĳ���
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
