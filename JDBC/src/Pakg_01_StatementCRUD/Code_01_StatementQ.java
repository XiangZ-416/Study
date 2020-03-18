package Pakg_01_StatementCRUD;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Code_01_StatementQ {

	// ʹ��Statement�ı׶ˣ���Ҫƴдsql��䣬���Ҵ���SQLע�������
	// SQLע�룺����ĳЩϵͳû�ж��û���������ݽ��г�ֵļ�飬�����û�����������ע��Ƿ��� SQL ����
	//		������(�磺SELECT user, password FROM user_table WHERE user='a' OR 1 = ' AND password = ' OR '1' =
	//		'1') ���Ӷ�����ϵͳ�� SQL ������ɶ�����Ϊ��������
	// ��α���sqlע�룺��PreparedStatement
	@Test
	public void testLogin() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("�������û�����");
		String user = scanner.next();
		System.out.println("���������룺");
		String password = scanner.next();

		String sql = "SELECT user, password FROM user_table WHERE user = '"+ user +"' AND password = '"+ password +"'";

		User returnUser = get(sql, User.class);
		if (returnUser != null) {
			System.out.println("��½�ɹ�");
		}else {
			System.out.println("�û��������ڻ��������");
		}
	}

	// ʹ��Statementʵ�ֶ����ݱ�Ĳ�ѯ����
	public <T> T get(String sql, Class<T> clazz) {
		T t = null;

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.���������ļ�
			InputStream is = Code_01_StatementQ.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties pros = new Properties();
			pros.load(is);

			// 2.��ȡ������Ϣ
			String user = pros.getProperty("user");
			String password = pros.getProperty("password");
			String url = pros.getProperty("url");
			String driverClass = pros.getProperty("driverClass");

			// 3.��������
			Class.forName(driverClass);

			// 4.��ȡ����
			conn = DriverManager.getConnection(url, user, password);

			st = conn.createStatement();

			rs = st.executeQuery(sql);

			// ��ȡ�������Ԫ����
			ResultSetMetaData rsmd = rs.getMetaData();

			// ��ȡ�����������
			int columnCount = rsmd.getColumnCount();

			if (rs.next()) {

				t = clazz.newInstance();

				for (int i = 0; i < columnCount; i++) {
					// //1. ��ȡ�е�����
					// String columnName = rsmd.getColumnName(i+1);

					// 1. ��ȡ�еı���
					String columnName = rsmd.getColumnLabel(i + 1);

					// 2. ����������ȡ��Ӧ���ݱ��е�����
					Object columnVal = rs.getObject(columnName);

					// 3. �����ݱ��еõ������ݣ���װ������
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(t, columnVal);
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
