package ssm.service;

import ssm.domain.Account;

import java.util.List;

/**
 * @Description: //TODO ҵ���ӿ�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/15 17:38
 */
public interface AccountService {

    // ��ѯ�����˻���Ϣ
    public List<Account> findAll();

    // �����˻���Ϣ
    public void saveAccount(Account account);

}
