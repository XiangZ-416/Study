package Pakg_06_DAO;

import Bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Description: //TODO 针对Customer表的具体操作
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/23 13:53
 */
public class CustomerDaoImpl extends  BaseDAO<Customer> implements CustomerDAO {

    @Override
    public void insert(Connection conn, Customer cust) {
        String sql = "insert into customers(id,name)values(?,?)";
        CommonCDU(conn, sql,cust.getId(), cust.getName());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        CommonCDU(conn, sql , id);
    }

    @Override
    public void update(Connection conn, Customer cust) {
        String sql = "update customers set id = ?,name = ?";
        CommonCDU(conn, sql, cust.getId(), cust.getName());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select id,name,birth from customers where id = ?";
        Customer customer = CommonQuery(conn,  sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customer> list = CommonQueries(conn, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
            String sql = "select count(*) from customers";
            return getValue(conn, sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birth) from customers";
        return getValue(conn, sql);
    }
}
