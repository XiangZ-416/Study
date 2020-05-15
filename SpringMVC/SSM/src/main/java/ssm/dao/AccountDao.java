package ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ssm.domain.Account;

import java.util.List;

/**
 * @Description: //TODO 持久层：账户接口
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/15 17:35
 */
@Repository
public interface AccountDao {

    // 查询所有账户信息
    @Select("select * from account")
    public List<Account> findAll();

    // 保存账户信息
    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);

}
