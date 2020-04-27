package Pakg_03_SpringJDBC.Num_02_TransactionManagement;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO ����ע�����������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/23 22:47
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

    // ���Ը�����Ż�ȡ��ĵ���
    @Test
    public void testBookShopDaoFindPriceByIsbn() {
        System.out.println("��ĵ���b��" + bookShopDao.findBookPriceByIsbn("1001"));
    }

    // ������Ŀ�棺ʹ��Ŷ�Ӧ�Ŀ�� -1
    @Test
    public void testUpdateBookStockByIsbn() {
        bookShopDao.updateBookStock("1001");
    }

    // �����û����˻���ʹ userName �� balance - price
    @Test
    public void testUpdateUserAccount() {
        bookShopDao.updateUserAccount("AA", 100);
    }

    // ����
    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", "1001");
    }

}
