package Pakg_04_PreparedStatementBlob;

import Bean.Customer;
import Utils.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * @Description: ʹ��PreparedStatement����Blob��������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/19 17:57
 */
public class BlobTest {

    // �����ݱ�customers���в���Blob���͵��ֶ�
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.��ȡmysql����
            conn = JDBCUtils.getConnection();
            // 2.Ԥ����sql���
            String sql = "insert into customers(name, email, birth, potho) value(?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            // 3.���ռλ��
            ps.setObject(1, "girl");
            ps.setObject(2, "zx1111@163.com");
            ps.setObject(3,"2012-1-1");
            FileInputStream photo = new FileInputStream(new File("playgirl.jpg"));
            ps.setBlob(4, photo);
            // 4.ִ��sql���
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5.�ر���Դ
            JDBCUtils.closeResource(conn, ps);
        }
    }

    //��ѯ���ݱ�customers��Blob���͵��ֶ�
    @Test
    public void testQuery(){
        Connection conn = null;
        PreparedStatement ps = null;
        InputStream is = null;
        FileOutputStream fos = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 21);
            rs = ps.executeQuery();
            if(rs.next()){
                //			��ʽһ��
                //			int id = rs.getInt(1);
                //			String name = rs.getString(2);
                //			String email = rs.getString(3);
                //			Date birth = rs.getDate(4);
                //��ʽ����
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customer cust = new Customer(id, name);
                System.out.println(cust);

                //��Blob���͵��ֶ��������������ļ��ķ�ʽ�����ڱ���
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream(); // �Զ�������ʽ�����ļ�
                fos = new FileOutputStream("playgirl.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) != -1){
                    fos.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn, ps, rs);
        }
    }
}
