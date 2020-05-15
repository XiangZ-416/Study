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
 * @Description: //TODO ����Mybatis
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/15 21:03
 */
public class testMybatis {

    // ���ѯ
    @Test
    public void run1() throws IOException {
        // ����Mybatis�����ļ�
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // ����sqlSessionFactory����
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // ����sqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // ��ȡ�������
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        // ��ѯ��������
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        // �ر���Դ
        sqlSession.close();;
        in.close();
    }

    // �Ᵽ��
    @Test
    public void run2() throws Exception {
        Account account = new Account();
        account.setName("�ܴ�");
        account.setMoney(400);

        // ���������ļ�
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // ��������
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // ����sqlSession����
        SqlSession session = factory.openSession();

        // ��ȡ�������
        AccountDao dao = session.getMapper(AccountDao.class);
        dao.saveAccount(account);

        // �ύ����
        session.commit();
        // �ͷ���Դ
        session.close();
        inputStream.close();
    }

}
