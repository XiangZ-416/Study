package ssm.service;

import ssm.domain.Account;

import java.util.List;

/**
 * @Description: //TODO 业务层接口
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/15 17:38
 */
public interface AccountService {

    // 查询所有账户信息
    public List<Account> findAll();

    // 保存账户信息
    public void saveAccount(Account account);

}
