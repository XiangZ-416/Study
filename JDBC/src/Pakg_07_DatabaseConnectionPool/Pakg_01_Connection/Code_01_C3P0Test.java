package Pakg_07_DatabaseConnectionPool.Pakg_01_Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description: //TODO ����C3P0���ݿ����ӳ�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/23 15:24
 */
public class Code_01_C3P0Test {
    // ��ʽһ��
    @Test
    public void testGetConnection() throws Exception{
        // ��ȡc3p0���ݿ����ӳ�
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" );
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        cpds.setUser("root");
        cpds.setPassword("root");
        // ͨ��������صĲ����������ݿ����ӳؽ��й���
        // ���ó�ʼʱ���ݿ����ӳ��е�������
        cpds.setInitialPoolSize(10);

        // ��ȡ����
        Connection conn = cpds.getConnection();
        System.out.println(conn);

        // ����c3p0���ݿ����ӳ�
//		DataSources.destroy( cpds );
    }
    //��ʽ����ʹ�������ļ�
    @Test
    public void testGetConnection1() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
}
