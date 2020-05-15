package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.AccountDao;
import ssm.domain.Account;
import ssm.service.AccountService;

import java.util.List;

/**
 * @Description: //TODO 业务层实现类
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/15 17:39
 */
@Service("accountService") // 把service交给IOC容器管理
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户信息...");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层，保存账户信息...");
        accountDao.saveAccount(account);
    }

}
