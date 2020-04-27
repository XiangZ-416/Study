package Pakg_04_DAO;

import Pakg_02_Po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/27 18:24
 */
public class Code_03_UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    // 此方法在testFindUserById之前执行
    @Before
    public void setUp() throws Exception {

        // 创建会话工厂SqlSessionFactory
        // 获取mapper配置文件
        String resource = "SqlMapConfig.xml";

        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 根据配置文件创建会话工厂：SqlSessionFactory
       sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void testFindUserById() throws Exception {

        // 通过构造函数注入会话工厂，创建UserDaoImpl对象
        Code_01_UserDao userDao = new Code_02_UserDaoImpl(sqlSessionFactory);

        // 调用UserDao方法
        User user = userDao.findUserById(1);

        System.out.println(user);

    }

}
