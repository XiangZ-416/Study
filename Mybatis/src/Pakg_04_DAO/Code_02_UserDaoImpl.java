package Pakg_04_DAO;

import Pakg_02_Po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/27 18:09
 */
public class Code_02_UserDaoImpl implements Code_01_UserDao{

    // ��Ҫ��daoʵ������ע��SqlSessionFactory
    // ����ͨ�����췽��ע��
    private SqlSessionFactory sqlSessionFactory; // SqlSessionFactory���õ���ģʽֻ����һ������

    public Code_02_UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession�̲߳���ȫ��Ҫ���ڷ�������
        // ִ�в��Ҳ���
        User user = sqlSession.selectOne("test.findUserById", id);
        // �ر���Դ
        sqlSession.close();

        return user;

    }

    @Override
    public void insertUser(User user) throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // ִ�в������
        sqlSession.insert("test.insertUser", user);
        // �ύ����
        sqlSession.commit();
        // �ر���Դ
        sqlSession.close();

    }

    @Override
    public void deleteUser(int id) throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // ִ��ɾ������
        sqlSession.delete("test.deleteUserById", id);
        // �ύ����
        sqlSession.commit();
        // �ر���Դ
        sqlSession.close();

    }

}
