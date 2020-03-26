package Pakg_06_DAO;

import Bean.Customer;
import Utils.JDBCUtils;
import com.mysql.jdbc.Connection;
import org.junit.Test;

/**
 * @Description: //TODO ����Customer��Ĳ���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/23 14:23
 */
public class CustomerDaoImplTest {
    private CustomerDaoImpl customerDao = new CustomerDaoImpl();

    // ����CustomerDaoImpl�е�insert����
    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            conn = (Connection) JDBCUtils.getConnection();
            Customer cust = new Customer(22, "zx");
            customerDao.insert(conn, cust);
            System.out.println("��ӳɹ�");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
}
