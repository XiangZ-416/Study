//package Pakg_08_DBUtils;
//
//import Bean.Customer;
//import Utils.JDBCUtils;
//import com.mysql.jdbc.Connection;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.ResultSetHandler;
//import org.apache.commons.dbutils.handlers.*;
//import org.junit.Test;
//
//import java.sql.Date;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Description: //TODO commons-dbutils �� Apache ��֯�ṩ��һ����Դ JDBC�������,��װ����������ݿ����ɾ�Ĳ����
// *                           �������Լ�д��Code_01_PreparedStatementCRUD
// * @Author: ZX   Email:zx04161313@163.com
// * @Date:Create�� 2020/3/23 16:12
// */
//public class Code_01_Queries {
//    //���Բ���
//    @Test
//    public void testInsert() {
//        Connection conn = null;
//        try {
//            QueryRunner runner = new QueryRunner();
//            conn = (Connection) JDBCUtils.getConnection();
//            String sql = "insert into customers(name,email,birth)values(?,?,?)";
//            int insertCount = runner.update(conn, sql, "������","caixukun@126.com","1997-09-08");
//            System.out.println("�����" + insertCount + "����¼");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            JDBCUtils.closeResource(conn, null);
//        }
//
//    }
//
//    //���Բ�ѯ
//    /*
//     * BeanHander:��ResultSetHandler�ӿڵ�ʵ���࣬���ڷ�װ���е�һ����¼��
//     */
//    @Test
//    public void testQuery1(){
//        Connection conn = null;
//        try {
//            QueryRunner runner = new QueryRunner();
//            conn = (Connection) JDBCUtils.getConnection();
//            String sql = "select id,name,email,birth from customers where id = ?";
//            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
//            Customer customer = runner.query(conn, sql, handler, 23);
//            System.out.println(customer);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }finally{
//            JDBCUtils.closeResource(conn, null);
//
//        }
//
//    }
//
//    /*
//     * BeanListHandler:��ResultSetHandler�ӿڵ�ʵ���࣬���ڷ�װ���еĶ�����¼���ɵļ��ϡ�
//     */
//    @Test
//    public void testQuery2() {
//        Connection conn = null;
//        try {
//            QueryRunner runner = new QueryRunner();
//            conn = (Connection) JDBCUtils.getConnection();
//            String sql = "select id,name,email,birth from customers where id < ?";
//
//            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
//
//            List<Customer> list = runner.query(conn, sql, handler, 23);
//            list.forEach(System.out::println);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            JDBCUtils.closeResource(conn, null);
//        }
//
//    }
//
//    /*
//     * MapHander:��ResultSetHandler�ӿڵ�ʵ���࣬��Ӧ���е�һ����¼��
//     * ���ֶμ���Ӧ�ֶε�ֵ��Ϊmap�е�key��value
//     */
//    @Test
//    public void testQuery3(){
//        Connection conn = null;
//        try {
//            QueryRunner runner = new QueryRunner();
//            conn = (Connection) JDBCUtils.getConnection();
//            String sql = "select id,name,email,birth from customers where id = ?";
//            MapHandler handler = new MapHandler();
//            Map<String, Object> map = runner.query(conn, sql, handler, 23);
//            System.out.println(map);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            JDBCUtils.closeResource(conn, null);
//        }
//
//    }
//
//    /*
//     * MapListHander:��ResultSetHandler�ӿڵ�ʵ���࣬��Ӧ���еĶ�����¼��
//     * ���ֶμ���Ӧ�ֶε�ֵ��Ϊmap�е�key��value������Щmap��ӵ�List��
//     */
//    @Test
//    public void testQuery4(){
//        Connection conn = null;
//        try {
//            QueryRunner runner = new QueryRunner();
//            conn = (Connection) JDBCUtils.getConnection();
//            String sql = "select id,name,email,birth from customers where id < ?";
//
//            MapListHandler handler = new MapListHandler();
//            List<Map<String, Object>> list = runner.query(conn, sql, handler, 23);
//            list.forEach(System.out::println);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            JDBCUtils.closeResource(conn, null);
//        }
//
//    }
//    /*
//     * ScalarHandler:���ڲ�ѯ����ֵ
//     */
//    @Test
//    public void testQuery5(){
//        Connection conn = null;
//        try {
//            QueryRunner runner = new QueryRunner();
//            conn = (Connection) JDBCUtils.getConnection();
//
//            String sql = "select count(*) from customers";
//
//            ScalarHandler handler = new ScalarHandler();
//
//            Long count = (Long) runner.query(conn, sql, handler);
//            System.out.println(count);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            JDBCUtils.closeResource(conn, null);
//        }
//
//    }
//    @Test
//    public void testQuery6(){
//        Connection conn = null;
//        try {
//            QueryRunner runner = new QueryRunner();
//            conn = (Connection) JDBCUtils.getConnection();
//
//            String sql = "select max(birth) from customers";
//
//            ScalarHandler handler = new ScalarHandler();
//            Date maxBirth = (Date) runner.query(conn, sql, handler);
//            System.out.println(maxBirth);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            JDBCUtils.closeResource(conn, null);
//        }
//
//    }
//
//    /*
//     * �Զ���ResultSetHandler��ʵ����
//     */
//    @Test
//    public void testQuery7(){
//        Connection conn = null;
//        try {
//            QueryRunner runner = new QueryRunner();
//            conn = (Connection) JDBCUtils.getConnection();
//
//            String sql = "select id,name,email,birth from customers where id = ?";
//            ResultSetHandler<Customer> handler = new ResultSetHandler<Customer>(){
//
//                @Override
//                public Customer handle(ResultSet rs) throws SQLException {
////					System.out.println("handle");
////					return null;
//
////					return new Customer(12, "����", "Jacky@126.com", new Date(234324234324L));
//
//                    if(rs.next()){
//                        int id = rs.getInt("id");
//                        String name = rs.getString("name");
//                        Customer customer = new Customer(id, name);
//                        return customer;
//                    }
//                    return null;
//
//                }
//
//            };
//            Customer customer = runner.query(conn, sql, handler,23);
//            System.out.println(customer);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            JDBCUtils.closeResource(conn, null);
//        }
//    }
//}
