package Pakg_01_MybatisJDBC;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/26 15:10
 */
public class Code_01_JDBCTest {

    public static void main(String[] args) {

        // ���ݿ�����
        Connection connection = null;
        // Ԥ�����Statement
        PreparedStatement preparedStatement = null;
        // �����
        ResultSet resultSet = null;

        try {
            //�������ݿ�����
            Class.forName("com.mysql.jdbc.Driver");

            //ͨ�������������ȡ���ݿ�����
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "root");
            //����sql��� ?��ʾռλ��
            String sql = "select * from user where username = ?";
            //��ȡԤ����statement
            preparedStatement = connection.prepareStatement(sql);
            //���ò�������һ������Ϊsql����в�������ţ���1��ʼ�����ڶ�������Ϊ���õĲ���ֵ
            preparedStatement.setString(1, "����");
            //�����ݿⷢ��sqlִ�в�ѯ����ѯ�������
            resultSet =  preparedStatement.executeQuery();
            //������ѯ�����
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"  "+resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //�ͷ���Դ
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}