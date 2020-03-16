package Pakg_02_TestPreparedStatementCRUD;

import Bean.Customer;
import Utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * ʹ��PreparedStatement���滻Statement��ʵ�ֶ����ݿ�����ɾ�Ĳ����
 * ��ɾ�ģ���
 * @author ZX
 * @date 2020/3/16 - 10:57
 */
public class Code_01_PreparedStatementUpdateTestCRUD {
    // 1.��customers�������һ����¼
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.��ȡ����
            conn = JDBCUtils.getConnection();

            // 2.Ԥ����sql��䣬����PreparedStatement��ʵ��
            String sql = "insert into customers(name, email) values (?, ?)";
            ps = conn.prepareStatement(sql);

            // 3.���ռλ��
            ps.setObject(1, "��߸");
            ps.setObject(2, "nezha@gmail.com");

            // 4.ִ�в���
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.�ر���Դ
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // 2.����customers����һ����¼
    @Test
    public void testUpdate() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. ��ȡ��������
            conn = JDBCUtils.getConnection();
            // 2.Ԥ����sql��䣬����PrepreStatementʵ��
            String sql = "UPDATE CUSTOMERS SET NAME = ? WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            // 3.���ռλ��
            ps.setObject(1, "Ī����");
            ps.setObject(2, "18");
            // 4.ִ��
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5.��Դ�ر�
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // 3.ɾ��customers����һ����¼
    @Test
    public void testDelete() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. ��ȡ��������
            conn = JDBCUtils.getConnection();
            // 2.Ԥ����sql��䣬����PrepareStatementʵ��a
            String sql = "delete from customers where id = ?";
            ps = conn.prepareStatement(sql);
            // 3.���ռλ��
            ps.setObject(1, 20);
            // 4.ִ��
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5.��Դ�ر�
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // ͨ�õ�����ɾ���Ĳ���������һ������ɾ���� �� ���ֶ�������ڲ�ͬ�ı�
    public void CommonCDU(String sql, Object ... args){ // Object ... args��Object���͵Ŀɱ�������ͣ�ռλ���ĸ�����
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.��ȡ���ݿ������
            conn = JDBCUtils.getConnection();

            // 2.��ȡPreparedStatement��ʵ�� (��Ԥ����sql���)
            ps = conn.prepareStatement(sql);
            // 3.���ռλ��
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]); // ���ݿ��Ǵ�1��ʼ�ģ������Ǵ�0��ʼ��
            }

            // 4.ִ��sql���
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 5.�ر���Դ
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // ������ɾ�ĵ�ͨ�÷���
    @Test
    public void testCommonDelete(){
        // ɾ��
//      String sql = "delete from customers where id = ?";
//      testCommon(sql, 3);

        // ���
        String sql = "update `order` set order_name = ? where order_id = ?";
        CommonCDU(sql, "DD", "2");
    }

    /**
     * ���customers��Ĳ�ѯ����
     */
    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 1.��ȡ��������
            conn = JDBCUtils.getConnection();
            // 2.Ԥ����sql��䣬��ȡPreparedStatement��ʵ��
            String sql = "select id, name from customers where id = ?";
            ps = conn.prepareStatement(sql);
            // 3.���ռλ��
            ps.setObject(1, 1);
            // 4.ִ�в����ؽ����
            resultSet = ps.executeQuery();
            // 5.��������(��ȡ�ֶε�ֵ)
            if (resultSet.next()) { // �жϽ��������һ���Ƿ������ݣ���������ݣ�����true����ָ������
                // ��ȡ��ǰ�������ݵĸ����ֶε�ֵ
                int id = resultSet.getInt(1); // ��ѯ���ĵ�һ���ֶε�ֵ
                String name = resultSet.getString(2); // ��ѯ���ĵڶ����ֶε�ֵ

                // ��ʽ1:ֱ�����
                System.out.println("id = "+ id +"�� name = "+ name +"");

                // ��ʽ2��Object����
                Object[] data = new Object[] {id, name};
                for (int i = 0; i < data.length; i++) {
                    System.out.print(data[i] + " ");
                }
                System.out.println();

                // ��ʽ3�������ݷ�װΪһ������
                Customer customer = new Customer(id, name);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 6.�ر���Դ
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }

    // ���customers���ͨ�ò�ѯ������ÿ�β���ֶζ��ٿ��ܲ�һ����
    public Customer commonQForCustomers(String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 1.����ȡ���ݿ��
            conn = JDBCUtils.getConnection();
            // 2.Ԥ����sql��䣬����prepareStatement����
            ps = conn.prepareStatement(sql);
            // 3.���ռλ��
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 4.ִ�в����ؽ����
            resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData(); // ��ȡ�������Ԫ���ݣ����ν������
            int columnCount = metaData.getColumnCount(); // ͨ�������Ԫ���ݻ�ȡ�����������
            // 5.��������(��ȡ�ֶε�ֵ)
            if (resultSet.next()) {
                Customer customer = new Customer(); // ���е�һ������
                // ����������һ�����ݵĸ�һ����
                for (int i = 0; i < columnCount; i++) { // �Ѿ�����ռλ��Ҫ���ĳһ�У���ȡ�����ֶε�ֵ
                    // ��ȡ��i + 1�е�ֵ
                    Object columnValue = resultSet.getObject(i + 1);
                    // ��ȡ��i + 1�е�����
                    String columnName = metaData.getColumnName(i + 1);
                    // ��customer����ָ����columnNam�����ԣ���ֵΪcolumnValue��ͨ�����䣨ָ������ʱ���ĳ�����Բ���ֵ��
                    Field field = Customer.class.getDeclaredField(columnName); // ָ��Customer����columnName����
                    field.setAccessible(true); // �õ������Կ���Ϊ˽�У�����Ϊtrueȷ���ɼ�
                    field.set(customer, columnValue); // ��customer�����columnName��������ΪcolumnValue
                }
                return customer; // �鵽��
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 6.�ر���Դ
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

        return null; // û�鵽
    }

    @Test
    public void testCommonQForCustomers() {
        String sql = "select id, name from customers where id = ?";
        Customer customer = commonQForCustomers(sql, 13);
        System.out.println(customer);

        sql = "select id, name from customers where name = ?";
        Customer customer1 = commonQForCustomers(sql, "�ܽ���");
        System.out.println(customer1);
    }

    // ���Order���ͨ�ò�ѯ������ÿ�β���ֶζ��ٿ��ܲ�һ����
    public Customer commonQForOrder(String sql, Object...args) {

        return null;
    }
}
