package ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ssm.domain.Account;

import java.util.List;

/**
 * @Description: //TODO �־ò㣺�˻��ӿ�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/15 17:35
 */
@Repository
public interface AccountDao {

    // ��ѯ�����˻���Ϣ
    @Select("select * from account")
    public List<Account> findAll();

    // �����˻���Ϣ
    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);

}
