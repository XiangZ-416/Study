package Pakg_03_SpringJDBC.Num_02_TransactionManagement;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO 基于注解的事务配置
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/23 22:47
 */
public class SpringTransactionTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private bookShopService bookShopService = null;


    {
        ctx = new ClassPathXmlApplicationContext("Tm.xml");
        bookShopDao = ctx.getBean(bookShopDaoImpl.class);
        bookShopService = ctx.getBean(bookShopService.class);
    }

    // 测试根据书号获取书的单价
    @Test
    public void testBookShopDaoFindPriceByIsbn() {
        System.out.println("书的单价b：" + bookShopDao.findBookPriceByIsbn("1001"));
    }

    // 更新书的库存：使书号对应的库存 -1
    @Test
    public void testUpdateBookStockByIsbn() {
        bookShopDao.updateBookStock("1001");
    }

    // 更新用户的账户余额：使 userName 的 balance - price
    @Test
    public void testUpdateUserAccount() {
        bookShopDao.updateUserAccount("AA", 100);
    }

    // 测试
    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", "1001");
    }

}
