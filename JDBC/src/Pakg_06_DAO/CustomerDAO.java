package Pakg_06_DAO;

import Bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Description: //TODO 此接口用于规范针对Customer表的常用操作
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/23 12:06
 */
public interface CustomerDAO {
    /**
     * @Author ZX
     * @Description //TODO 将cust对象添加到数据库中
     * @Date 12:18 2020/3/23
     * @Param [conn, cust]
     * @return void
     **/
    void insert(Connection conn, Customer cust);

    /**
     * @Author ZX
     * @Description //TODO 根据指定的Id,删除表中的一条记录
     * @Date 12:20 2020/3/23
     * @Param [conn, id]
     * @return void
     **/
    void deleteById(Connection conn, int id);
    
    /**
     * @Author ZX
     * @Description //TODO 针对内存中的cust对象，去修改表中指定的记录
     * @Date 12:22 2020/3/23
     * @Param [conn, cust]
     * @return void
     **/
    void update(Connection conn, Customer cust);

    /**
     * @Author ZX
     * @Description //TODO 针对指定的id查询得到对应的Customer对象
     * @Date 13:47 2020/3/23
     * @Param [conn, id]
     * @return void
     **/
    Customer getCustomerById(Connection conn, int id);

    /**
     * @Author ZX
     * @Description //TODO 查询表中的所有的记录构成的集合
     * @Date 13:48 2020/3/23
     * @Param [conn]
     * @return java.util.List<Bean.Customer>
     **/
    List<Customer> getAll(Connection conn);
    
    /**
     * @Author ZX
     * @Description //TODO 返回数据表中数据的条目数
     * @Date 13:49 2020/3/23
     * @Param [conn]
     * @return java.lang.Long
     **/
    Long getCount(Connection conn);

    /**
     * @Author ZX
     * @Description //TODO 返回数据表中最大的生日
     * @Date 13:51 2020/3/23
     * @Param [conn]
     * @return java.sql.Date
     **/
    Date getMaxBirth(Connection conn);
}
