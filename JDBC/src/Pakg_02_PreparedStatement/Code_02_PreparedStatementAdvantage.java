package Pakg_02_PreparedStatement;

import Pakg_01_StatementCRUD.User;
import Utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * @Description: ��ʾPreparedStatement�滻Statement���sqlע������
 * PreparedStatementΪʲô�ܽ��sqlע�����⣿
 *      ��Ϊ��Ԥ����sql��䣬Ԥ���������ǰִ��ʧȥ����䣬��������ռλ��������ı�where���������߼�
 * ���˽��Statement��ƴ����sql����֮�⣬PreparedStatement������Щ�ô��أ�
 *      1.PreparedStatement����Blob�����������ݣ���Statement��������
 *      2.PreparedStatement����ʵ�ָ���Ч������������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/18 20:38
 */
public class Code_02_PreparedStatementAdvantage {
    @Test
    public void testLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("�������û�����");
        String user = scanner.next();
        System.out.println("���������룺");
        String password = scanner.next();

        // ��Statement����passwordΪ=1 orʱ��ʹ���벻�ԣ�Ҳ���¼�ɹ��������˹ؼ���or���Ƿ���¼
//      String sql = "SELECT user,password FROM user_table WHERE user = '1' or ' AND password = '=1 or '1' = '1'";
        String sql = "SELECT user, password FROM user_table WHERE user = ? AND password = ?";
        User returnUser = CommonQuery(User.class, sql, user, password);
        if (returnUser != null) {
            System.out.println("��½�ɹ�");
        }else {
            System.out.println("�û��������ڻ��������");
        }
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
}
