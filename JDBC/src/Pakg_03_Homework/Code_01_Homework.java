package Pakg_03_Homework;

import Utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @Description: �κ���ϰ1���ӿ���̨�����ݿ�ı�customers�в���һ�����ݣ���ṹ���£�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/18 21:50
 */
public class Code_01_Homework {

    @Test
    public void testInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("�������û���:");
        String name = scanner.next();
        System.out.print("����������:");
        String email = scanner.next();
        System.out.print("����������:");
        String birthday = scanner.next();

        String sql = "create into customers(name, email, birth)values(?, ?, ?)";
        int insertCount = CommonCDU(sql, name, email, birthday);
        if (insertCount > 0) {
            System.out.println("��ӳɹ�");
        }else {
            System.out.println("���ʧ��");
        }
    }

    // ͨ�õ�����ɾ���Ĳ���������һ������ɾ���� �� ���ֶ�������ڲ�ͬ�ı�
    public int CommonCDU(String sql, Object ... args){ // Object ... args��Object���͵Ŀɱ�������ͣ�ռλ���ĸ�����
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
            /*
             * ps.execute():
             * ���ִ�е��ǲ�ѯ�������з��ؽ������˷�������true;
             * ���ִ�е�������ɾ���Ĳ�����û�з��ؽ������˷�������false.
             */
            return ps.executeUpdate(); // executeUpdate()������ֵ��ִ��sql����Ӱ�������
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 5.�ر���Դ
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;
    }
}
