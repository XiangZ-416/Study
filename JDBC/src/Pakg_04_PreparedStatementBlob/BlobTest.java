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
 * @Description: 使用PreparedStatement操作Blob类型数据
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/19 17:57
 */
public class BlobTest {

    // 向数据表customers表中插入Blob类型的字段
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.获取mysql连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句
            String sql = "insert into customers(name, email, birth, potho) value(?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            ps.setObject(1, "girl");
            ps.setObject(2, "zx1111@163.com");
            ps.setObject(3,"2012-1-1");
            FileInputStream photo = new FileInputStream(new File("playgirl.jpg"));
            ps.setBlob(4, photo);
            // 4.执行sql语句
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5.关闭资源
            JDBCUtils.closeResource(conn, ps);
        }
    }

    //查询数据表customers中Blob类型的字段
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
                //			方式一：
                //			int id = rs.getInt(1);
                //			String name = rs.getString(2);
                //			String email = rs.getString(3);
                //			Date birth = rs.getDate(4);
                //方式二：
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customer cust = new Customer(id, name);
                System.out.println(cust);

                //将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream(); // 以二进制形式下载文件
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
