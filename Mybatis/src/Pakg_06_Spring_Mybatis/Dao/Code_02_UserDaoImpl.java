package Pakg_06_Spring_Mybatis.Dao;

import Pakg_02_Po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/27 18:09
 */
public class Code_02_UserDaoImpl extends SqlSessionDaoSupport implements Code_01_UserDao {

    // ��Ҫ��daoʵ������ע��SqlSessionFactory
    // ����ͨ�����췽��ע��
    private SqlSessionFactory sqlSessionFactory; // SqlSessionFactory���õ���ģʽֻ����һ������

    public Code_02_UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Code_02_UserDaoImpl() {

    }

    @Override
    public User findUserById(int id) throws Exception {

        //�̳�SqlSessionDaoSupport��ͨ��this.getSqlSession();���sqlSession
        SqlSession sqlSession = this.getSqlSession();
        // ִ�в��Ҳ���
        User user = sqlSession.selectOne("test.findUserById", id);
        // Spring���������Զ��ͷ���Դ

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
