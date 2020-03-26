package Pakg_05_Transaction;

import Pakg_01_StatementCRUD.User;
import Utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @Description:
 *
 *  1.ʲô�����ݿ�����
 *  ����һ���߼�������Ԫ,ʹ���ݴ�һ��״̬�任����һ��״̬��
 *  	> һ���߼�������Ԫ��һ������DML������
 *
 *  2.�������ԭ�򣺱�֤����������Ϊһ��������Ԫ��ִ�У���ʹ�����˹��ϣ������ܸı�����ִ�з�ʽ��
 *   ����һ��������ִ�ж������ʱ��Ҫô���е����񶼱��ύ(commit)����ô��Щ�޸ľ����õر���
 *   ������Ҫô���ݿ����ϵͳ�����������������޸ģ���������ع�(rollback)�����״̬��
 *
 *  3.����һ���ύ���Ͳ��ɻع�
 *
 *  4.��Щ�����ᵼ�����ݵ��Զ��ύ��
 *   	>DDL����һ��ִ�У������Զ��ύ��
 *   		>set autocommit = false ��DDL����ʧЧ
 *   	>DMLĬ������£�һ��ִ�У��ͻ��Զ��ύ��
 *   		>���ǿ���ͨ��set autocommit = false�ķ�ʽȡ��DML�������Զ��ύ��
 *   	>Ĭ���ڹر�����ʱ�����Զ����ύ����
 *
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/20 17:50
 */
public class TransactionTest {

    //******************δ�������ݿ���������µ�ת�˲���**************************
    /*
     * ��������ݱ�user_table��˵��
     * AA�û���BB�û�ת��100
     *
     * update user_table set balance = balance - 100 where user = 'AA';
     * update user_table set balance = balance + 100 where user = 'BB';
     */
    @Test
    public void testUpdate(){

        String sql1 = "update user_table set balance = balance - 100 where user = ?";
        CommonCDU(sql1, "AA");

        //ģ�������쳣
        System.out.println(10 / 0);

        String sql2 = "update user_table set balance = balance + 100 where user = ?";
        CommonCDU(sql2, "BB");

        System.out.println("ת�˳ɹ�");
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

    //********************�������ݿ�������ת�˲���*********************
    @Test
    public void testUpdateWithTx() {
        Connection conn = null;
        try {
            // 1.��ȡ���ݿ�����
            conn = JDBCUtils.getConnection();
            // 2.��������
            conn.setAutoCommit(false);
            // 3.�������ݿ����
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            CommonCDU(conn, sql1, "AA");
            // ģ�������쳣
            //System.out.println(10 / 0);
            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            CommonCDU(conn, sql2, "BB");
            // 4.��û���쳣�����ύ����
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 5.�����쳣����ع�����
            try {
                assert conn != null;
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                }
        } finally {
            try {
            //6.�ָ�ÿ��DML�������Զ��ύ����
            assert conn != null;
            conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //7.�ر�����
            JDBCUtils.closeResource(conn, null, null);
        }
    }

    // ͨ�õ���ɾ�Ĳ���---version 2.0 ������������
    public void CommonCDU(Connection conn, String sql, Object... args) {// sql��ռλ���ĸ�����ɱ��βεĳ�����ͬ��
        PreparedStatement ps = null;
        try {
            // 1.Ԥ����sql��䣬����PreparedStatement��ʵ��
            ps = conn.prepareStatement(sql);
            // 2.���ռλ��
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);// С�Ĳ����������󣡣�
            }
            // 3.ִ��
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.��Դ�Ĺر�
            JDBCUtils.closeResource(null, ps);
        }
    }


    //*****************************************************
    @Test
    public void testTransactionSelect() throws Exception{

        Connection conn = JDBCUtils.getConnection();
        //��ȡ��ǰ���ӵĸ��뼶��
        System.out.println(conn.getTransactionIsolation());
        //�������ݿ�ĸ��뼶��
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        //ȡ���Զ��ύ����
        conn.setAutoCommit(false);

        String sql = "select user,password,balance from user_table where user = ?";
        User user = CommonQuery(conn, User.class, sql, "CC");

        System.out.println(user);

    }

    @Test
    public void testTransactionUpdate() throws Exception{
        Connection conn = JDBCUtils.getConnection();

        //ȡ���Զ��ύ����
        conn.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        CommonCDU(conn, sql, 5000,"CC");

        Thread.sleep(15000);
        System.out.println("�޸Ľ���");
    }


    //*****************************************************
    @Test
    public void TransactionSelect() throws Exception{

        Connection conn = JDBCUtils.getConnection();
        //��ȡ��ǰ���ӵĸ��뼶��
        System.out.println(conn.getTransactionIsolation());
        //�������ݿ�ĸ��뼶��
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        //ȡ���Զ��ύ����
        conn.setAutoCommit(false);

        String sql = "select user,password,balance from user_table where user = ?";
        User user = CommonQuery(conn, User.class, sql, "CC");

        System.out.println(user);

    }

    @Test
    public void TransactionUpdate() throws Exception{
        Connection conn = JDBCUtils.getConnection();

        //ȡ���Զ��ύ����
        conn.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        CommonCDU(conn, sql, 5000,"CC");

        Thread.sleep(15000);
        System.out.println("�޸Ľ���");
    }

    //ͨ�õĲ�ѯ���������ڷ������ݱ��е�һ����¼��version 2.0������������
    public <T> T CommonQuery(Connection conn,Class<T> clazz,String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // ��ȡ�������Ԫ���� :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // ͨ��ResultSetMetaData��ȡ������е�����
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t = clazz.newInstance();
                // ��������һ�������е�ÿһ����
                for (int i = 0; i < columnCount; i++) {
                    // ��ȡ��ֵ
                    Object columValue = rs.getObject(i + 1);

                    // ��ȡÿ���е�����
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // ��t����ָ����columnName���ԣ���ֵΪcolumValue��ͨ������
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);

        }

        return null;
    }
}
