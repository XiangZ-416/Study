package Pakg_06_DAO;

import Utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: //TODO ��װ��������ݱ��ͨ�ò���CRUD�ĳ�����
 * DAO
 * Data Access Object����������Ϣ����ͽӿڣ������˶����ݵ�CRUD��Create��Retrival��Update��Delete�������������κ�ҵ����ص���Ϣ����ʱҲ������BaseDAO
 * ���ã�Ϊ��ʵ�ֹ��ܵ�ģ�黯���������ڴ����ά����������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/22 14:16
 */
public abstract class BaseDAO<T> {

    private Class<T> clazz = null;

    {
        // ��ȡ��ǰBaseDAO������̳и����еķ���
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;

        Type[] typeArguments = paramType.getActualTypeArguments();// ��ȡ���෺�Ͳ���
        clazz = (Class<T>) typeArguments[0];// ��ȡ���͵ĵ�һ������
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

    //ͨ�õĲ�ѯ���������ڷ������ݱ��е�һ����¼��version 2.0������������
    public T CommonQuery(Connection conn, String sql, Object... args) {
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

    // ��Բ�ͬ���ͨ�ò�ѯ����
    // ���ر�Ķ�����¼ V2.0 ��������
    public List<T> CommonQueries(Connection conn, String sql, Object...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 1.����ȡ���ݿ�ӣ������ȡ��
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
            JDBCUtils.closeResource(null, ps, resultSet);
        }
        return null;
    }

    // ���ڲ�ѯ��������ֵ�ķ���
    public <E> E getValue(Connection conn,  String sql, Object...args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0;  i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return (E) resultSet.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null, ps, resultSet);
        }
        return null;
    }
}
