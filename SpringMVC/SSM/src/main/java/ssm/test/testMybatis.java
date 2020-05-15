package ssm.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ssm.dao.AccountDao;
import ssm.domain.Account;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description: //TODO 测试Mybatis
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/15 21:03
 */
public class testMybatis {

    // 测查询
    @Test
    public void run1() throws IOException {
        // 加载Mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        // 查询所有数据
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        // 关闭资源
        sqlSession.close();;
        in.close();
    }

    // 测保存
    @Test
    public void run2() throws Exception {
        Account account = new Account();
        account.setName("熊大");
        account.setMoney(400);

        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession对象
        SqlSession session = factory.openSession();

        // 获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        dao.saveAccount(account);

        // 提交事务
        session.commit();
        // 释放资源
        session.close();
        inputStream.close();
    }

}
