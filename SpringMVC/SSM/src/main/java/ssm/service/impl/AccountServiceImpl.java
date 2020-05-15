package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.AccountDao;
import ssm.domain.Account;
import ssm.service.AccountService;

import java.util.List;

/**
 * @Description: //TODO ҵ���ʵ����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/15 17:39
 */
@Service("accountService") // ��service����IOC��������
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("ҵ��㣺��ѯ�����˻���Ϣ...");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("ҵ��㣬�����˻���Ϣ...");
        accountDao.saveAccount(account);
    }

}
