package Pakg_04_DAO;

import Pakg_02_Po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/27 18:09
 */
public class Code_02_UserDaoImpl implements Code_01_UserDao{

    // 需要向dao实现类中注入SqlSessionFactory
    // 这里通过构造方法注入
    private SqlSessionFactory sqlSessionFactory; // SqlSessionFactory利用单例模式只创建一个对象

    public Code_02_UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession(); // SqlSession线程不安全故要放在方法体内
        // 执行查找操作
        User user = sqlSession.selectOne("test.findUserById", id);
        // 关闭资源
        sqlSession.close();

        return user;

    }

    @Override
    public void insertUser(User user) throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行插入操作
        sqlSession.insert("test.insertUser", user);
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();

    }

    @Override
    public void deleteUser(int id) throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行删除操作
        sqlSession.delete("test.deleteUserById", id);
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();

    }

}
