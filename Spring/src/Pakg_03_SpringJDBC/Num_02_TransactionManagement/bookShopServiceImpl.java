package Pakg_03_SpringJDBC.Num_02_TransactionManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/23 23:21
 */

@Service("bookShopService")
public class bookShopServiceImpl implements bookShopService{

    @Autowired
    private  BookShopDao bookShopDao;

    // �������ע��
    // 1.ʹ�� propagation ָ������Ĵ�����Ϊ������ǰ�����񷽷�������һ�����񷽷�����ʱ��
    //   ���ʹ������Ĭ��ȡֵΪ REQUIRED ����ʹ�ñ������ߵ����񣬲��������¿�����
    //                        REQUIRES_NEW���������¿�һ������
    // 2.ʹ�� isolation ָ������ĸ��뼶����õ��� READ_COMMITTED
    // 3.Ĭ������� Spring �������Ƕ���������ʱ�쳣���лع���Ҳ����ͨ����Ӧ���� noRollbackFor ��������. ͨ��ȡĬ��ֵ���ɡ�
    // 4.ʹ�� readOnly ָ�������Ƿ���ֻ������ʾ�������ֻ��ȡ���ݵ����������ݣ��������԰������ݿ������Ż������������һ��ֻ��ȡ���ݿ�ֵ�ķ���Ӧ���� readOnly = true��
    // 5.ʹ�� timeout ָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ�䡣
//    @Transactional(propagation = Propagation.REQUIRES_NEW,
//            isolation = Isolation.READ_COMMITTED, noRollbackFor = UserAccountException.class)
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,
            timeout = 1)
    @Override
    public void purchase(String userName, String isbn) {
        // 1.��ȡ��ĵ���
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        // 2.������Ŀ��
        bookShopDao.updateBookStock(isbn);

        // 3.�����û����
        bookShopDao.updateUserAccount(userName, price);

    }
}
