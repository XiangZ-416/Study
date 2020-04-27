package Pakg_02_PreparedStatement;

import Bean.Customer;
import Bean.Order;
import Utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ʹ��PreparedStatement���滻Statement��ʵ�ֶ����ݿ�����ɾ�Ĳ����
 * ��ɾ�ģ���
 * ����ڱ���ֶ������������������ͬ�����
 * 1.��������sqlʱ��ʹ������������������ֶεı���
 * 2.ʹ��ResultSetMetaDataʱ����Ҫʹ��getColumnLabel()���滻getColumnName(),��ȡ�еı�����
 *  ˵�������sql��û�и��ֶ�ȡ������getColumnLabel()��ȡ�ľ�������
 * @author ZX
 * @date 2020/3/16 - 10:57
 */
public class Code_01_PreparedStatementCRUD {
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
            // 2.Ԥ����sql��䣬����PrepareStatementʵ��
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
//                  String columnName = metaData.getColumnName(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    // ��customer����ָ����columnNam�����ԣ���ֵΪcolumnValue��ͨ�����䣨ָ������ʱ���ĳ�����Բ���ֵ��
                    Field field = Customer.class.getDeclaredField(columnLabel); // ָ��Customer����columnName����
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

    // ���Order��Ĳ�ѯ����
    @Test
    public void testQueueForOrder() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 1.��ȡ����
            conn = JDBCUtils.getConnection();
            // 2.Ԥ����sql��䣬prepareStatementʵ��
            String sql = "select order_id, order_name, order_date from `order` where order_id = ?";
            ps = conn.prepareStatement(sql);
            // 3.���ռλ��
            ps.setObject(1,1);
            // 4.ִ�в����ؽ����
            resultSet = ps.executeQuery();
            // 5.��������
            if (resultSet.next()) {
                int id = (int)resultSet.getObject(1);
                String name = (String)resultSet.getObject(2);
                Date date = (Date) resultSet.getObject(3);

                Order order = new Order(id, name, date);
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5.�ر���Դ
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }

    // ���Order���ͨ�ò�ѯ������ÿ�β���ֶζ��ٿ��ܲ�һ����
    public Order CommonQForOrder(String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 1.�������ݿ�
            conn = JDBCUtils.getConnection();
            // 2.Ԥ����sql��䣬����prepareStatementʵ��
            ps = conn.prepareStatement(sql);
            // 3.���ռλ��
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 4.ִ��sql��䲢���ؽ����
            resultSet = ps.executeQuery();
            // ��ȡ�������Ԫ����
            ResultSetMetaData metaData = resultSet.getMetaData();
            // ��ȡ����
            int columnNumber = metaData.getColumnCount();
            // 5.��������
            if (resultSet.next()) {
                Order order = new Order();
                for (int i = 0; i < columnNumber; i++) {
                    // ��ȡÿ���е���ֵ:ͨ�������resultSet
                    Object columnValue = resultSet.getObject(i + 1);
                    // ��ȡ��i + 1�е�����getColumnName()
                    // ��ȡ��i + 1�еı���getColumnLabel()
//                  String columnName = metaData.getColumnName(i + 1); -- ���Ƽ�ʹ��
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    // ͨ�����佫����ָ����columnName�����Ը�ֵΪָ����ֵ
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order, columnValue); // ����ǰorder�������columnValue�����Ը�ֵcolumnValue
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 6.�ر���Դ
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

        return null;
    }

    // ����Order���ͨ�ò�ѯ����
    @Test
    public void testCommonQForOrder(){
        String sql = "select order_id orderId, order_name orderName, order_date orderDate from `order` where order_id = ?";
        Order order = CommonQForOrder(sql, 1);
        System.out.println(order);
    }

    // ��Բ�ͬ���ͨ�ò�ѯ����(һ��javaBean�����һ����ͬClass����Ҫ��ı��ࣩ��������ʲô���÷���T��ʾ)
    // ���ر��е�һ����¼
    public <T> T CommonQuery(Class<T> clazz, String sql, Object...args){
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
                T t = clazz.newInstance(); // ����ػ��ƣ�����javaBean��Ŀղ�public��������
                // ����������һ�����ݵĸ�һ����
                for (int i = 0; i < columnCount; i++) { // �Ѿ�����ռλ��Ҫ���ĳһ�У���ȡ�����ֶε�ֵ
                    // ��ȡ��i + 1�е�ֵ
                    Object columnValue = resultSet.getObject(i + 1);
                    // ��ȡ��i + 1�е�����
//                  String columnName = metaData.getColumnName(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    // ��customer����ָ����columnNam�����ԣ���ֵΪcolumnValue��ͨ�����䣨ָ������ʱ���ĳ�����Բ���ֵ��
                    Field field = clazz.getDeclaredField(columnLabel); // ָ��Customer����columnName����
                    field.setAccessible(true); // �õ������Կ���Ϊ˽�У�����Ϊtrueȷ���ɼ�
                    field.set(t, columnValue); // ��customer�����columnName��������ΪcolumnValue
                }
                return t; // �鵽��
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 6.�ر���Դ
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

        return null; // û�鵽
    }

    // ���Ե���ͨ�ò�ѯ����
    @Test
    public void testCommonQuery() {
        String sql = "select id, name from customers  where id = ?";
        Customer customer = CommonQuery(Customer.class, sql, 12);
        System.out.println(customer);

        String sql1 = "select order_id orderId, order_name orderName from `order` where order_id = ?";
        Order order = CommonQuery(Order.class, sql1, 1);
        System.out.println(order);
    }

    // ��Բ�ͬ���ͨ�ò�ѯ����
    // ���ر�Ķ�����¼
    public <T> List<T> CommonQueries(Class<T> clazz, String sql, Object...args){
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
            // �������϶���
            ArrayList<T> list = new ArrayList<>();
            // 5.��������(��ȡ�ֶε�ֵ)
            while (resultSet.next()) {
                T t = clazz.newInstance(); // ����ػ��ƣ�����javaBean��Ŀղ�public��������
                // ����������һ�����ݵĸ�һ����
                for (int i = 0; i < columnCount; i++) { // �Ѿ�����ռλ��Ҫ���ĳһ�У���ȡ�����ֶε�ֵ
                    // ��ȡ��i + 1�е�ֵ
                    Object columnValue = resultSet.getObject(i + 1);
                    // ��ȡ��i + 1�е�����
//                  String columnName = metaData.getColumnName(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    // ��customer����ָ����columnNam�����ԣ���ֵΪcolumnValue��ͨ�����䣨ָ������ʱ���ĳ�����Բ���ֵ��
                    Field field = clazz.getDeclaredField(columnLabel); // ָ��Customer����columnName����
                    field.setAccessible(true); // �õ������Կ���Ϊ˽�У�����Ϊtrueȷ���ɼ�
                    field.set(t, columnValue); // ��customer�����columnName��������ΪcolumnValue
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 6.�ر���Դ
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

        return null;
    }

    // ���Զ���ͨ�ò�ѯ����
    @Test
    public void testCommonQueries(){
        String sql = "select id, name from customers where id < ?";
        List<Customer> customers = CommonQueries(Customer.class, sql, 12);
        customers.forEach(System.out::println); // lambda���ʽ

        String sql1 = "select order_id orderId, order_name orderName from `order` where order_id < ?";
        List<Order> orders = CommonQueries(Order.class, sql1, 5);
        orders.forEach(System.out::println);
    }
}