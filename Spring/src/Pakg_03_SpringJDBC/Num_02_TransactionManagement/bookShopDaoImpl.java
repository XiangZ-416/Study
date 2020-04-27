package Pakg_03_SpringJDBC.Num_02_TransactionManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/23 22:36
 */

@Repository("bookShopDao")
public class bookShopDaoImpl implements BookShopDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql = "SELECT price FROM book WHERE isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Override
    public void updateBookStock(String isbn) {
        // �����Ŀ���Ƿ��㹻�������������׳��쳣
        String sql2 = "SELECT stock FROM book_stock WHERE isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if(stock == 0){
            throw new BookStockException("��治��!");
        }

        String sql = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateUserAccount(String userName, int price) {
        //��֤����Ƿ��㹻, ������, ���׳��쳣
        String sql2 = "SELECT balance FROM account WHERE username = ?";
        int balance = jdbcTemplate.queryForObject(sql2, Integer.class, userName);
        if(balance < price){
            throw new UserAccountException("����!");
        }

        String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
        jdbcTemplate.update(sql, price, userName);
    }
}
