package Pakg_03_SpringJDBC.Num_02_TransactionManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/23 23:21
 */

@Service("bookShopService")
public class bookShopServiceImpl implements bookShopService{

    @Autowired
    private  BookShopDao bookShopDao;

    // 添加事务注解
    // 1.使用 propagation 指定事务的传播行为：即当前的事务方法被另外一个事务方法调用时，
    //   如何使用事务，默认取值为 REQUIRED ，即使用被调用者的事务，不再重新新开事务
    //                        REQUIRES_NEW，调用者新开一个事务
    // 2.使用 isolation 指定事务的隔离级别，最常用的是 READ_COMMITTED
    // 3.默认情况下 Spring 的事务是对所有运行时异常进行回滚，也可以通过对应属性 noRollbackFor 进行设置. 通常取默认值即可。
    // 4.使用 readOnly 指定事务是否是只读。表示这个事务只读取数据但不更新数据，这样可以帮助数据库引擎优化事务。若真的是一个只读取数据库值的方法应设置 readOnly = true。
    // 5.使用 timeout 指定强制回滚之前事务可以占用的时间。
//    @Transactional(propagation = Propagation.REQUIRES_NEW,
//            isolation = Isolation.READ_COMMITTED, noRollbackFor = UserAccountException.class)
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,
            timeout = 1)
    @Override
    public void purchase(String userName, String isbn) {
        // 1.获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        // 2.更新书的库存
        bookShopDao.updateBookStock(isbn);

        // 3.更新用户余额
        bookShopDao.updateUserAccount(userName, price);

    }
}
