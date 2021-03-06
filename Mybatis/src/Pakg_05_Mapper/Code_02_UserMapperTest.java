package Pakg_05_Mapper;

import Pakg_02_Po.User;
import Pakg_02_Po.UserCustom;
import Pakg_02_Po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/27 22:40
 */
public class Code_02_UserMapperTest {

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

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建UserMapper对象,Mybatis自动生成mapper代理对象
        Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class);

        // 调用userMapper的方法
        User user = userMapper.findUserById(1);

        System.out.println(user);

    }

    // 用户信息综合查询
    @Test
    public void testFindUserList() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建UserMapper对象,Mybatis自动生成mapper代理对象
        Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class);

        // 创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex(1);
        userCustom.setUsername("小明");
        //使用foreach要传入多个id
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        //将ids通过userQueryVo传入Statement
        userQueryVo.setIds(ids);
        userQueryVo.setUserCustom(userCustom);

        // 调用userMapper的方法
        List<UserCustom> users = userMapper.findUserList(userQueryVo);

        System.out.println(users);

    }

    @Test
    public void testFindUserCount() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建UserMapper对象,Mybatis自动生成mapper代理对象
        Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class);

        // 创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex(1);
        userCustom.setUsername("张三丰");
        userQueryVo.setUserCustom(userCustom);

        // 调用userMapper的方法
        int count = userMapper.findUserCount(userQueryVo);

        System.out.println(count);

    }

    @Test
    public void testFindUserByIdResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建UserMapper对象,Mybatis自动生成mapper代理对象
        Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class);

        // 调用userMapper的方法
        User user = userMapper.findUserByIdResultMap(1);

        System.out.println(user);

    }

}
