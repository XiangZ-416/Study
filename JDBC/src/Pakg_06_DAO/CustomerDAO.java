package Pakg_06_DAO;

import Bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Description: //TODO �˽ӿ����ڹ淶���Customer��ĳ��ò���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/23 12:06
 */
public interface CustomerDAO {
    /**
     * @Author ZX
     * @Description //TODO ��cust������ӵ����ݿ���
     * @Date 12:18 2020/3/23
     * @Param [conn, cust]
     * @return void
     **/
    void insert(Connection conn, Customer cust);

    /**
     * @Author ZX
     * @Description //TODO ����ָ����Id,ɾ�����е�һ����¼
     * @Date 12:20 2020/3/23
     * @Param [conn, id]
     * @return void
     **/
    void deleteById(Connection conn, int id);
    
    /**
     * @Author ZX
     * @Description //TODO ����ڴ��е�cust����ȥ�޸ı���ָ���ļ�¼
     * @Date 12:22 2020/3/23
     * @Param [conn, cust]
     * @return void
     **/
    void update(Connection conn, Customer cust);

    /**
     * @Author ZX
     * @Description //TODO ���ָ����id��ѯ�õ���Ӧ��Customer����
     * @Date 13:47 2020/3/23
     * @Param [conn, id]
     * @return void
     **/
    Customer getCustomerById(Connection conn, int id);

    /**
     * @Author ZX
     * @Description //TODO ��ѯ���е����еļ�¼���ɵļ���
     * @Date 13:48 2020/3/23
     * @Param [conn]
     * @return java.util.List<Bean.Customer>
     **/
    List<Customer> getAll(Connection conn);
    
    /**
     * @Author ZX
     * @Description //TODO �������ݱ������ݵ���Ŀ��
     * @Date 13:49 2020/3/23
     * @Param [conn]
     * @return java.lang.Long
     **/
    Long getCount(Connection conn);

    /**
     * @Author ZX
     * @Description //TODO �������ݱ�����������
     * @Date 13:51 2020/3/23
     * @Param [conn]
     * @return java.sql.Date
     **/
    Date getMaxBirth(Connection conn);
}
