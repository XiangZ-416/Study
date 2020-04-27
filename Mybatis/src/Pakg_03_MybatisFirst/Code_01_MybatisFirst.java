package Pakg_03_MybatisFirst;

import Pakg_02_Po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Description: //TODO Mybatis入门程序
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/26 16:54
 */
public class Code_01_MybatisFirst {

    // 1.根据id查询用户信息，得到一条记录结果
    @Test
    public void findUserById() throws IOException {

        // 获取mapper配置文件
        String resource = "SqlMapConfig.xml";

        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 根据配置文件创建会话工厂：SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 利用会话工厂创建会话SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过SqlSession操作数据库
        //第一个参数：映射文件中statement的id，等于namespace.statement
        //第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        //sqlSession.selectOne最终的结果是与映射文件中所匹配的resultType类型对象
        User user = sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);

        //释放资源
        sqlSession.close();
    }

    // 2.根据用户名模糊查询
    @Test
    public void findUserByUserName() throws IOException {

        // 获取mapper配置文件
        String resource = "SqlMapConfig.xml";

        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 根据配置文件创建会话工厂：SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 利用会话工厂创建会话SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 指定SQL语句、填充占位符并执行sql语句
        List<User> users = sqlSession.selectList("test.findUserByUserName", "小明");

        for (User user : users) {
            System.out.println(user);
        }

        // 关闭会话
        sqlSession.close();

    }

    // 3.添加一条记录
    @Test
    public void insertUser() throws IOException {
        // 获取mapper配置文件
        String resource = "SqlMapConfig.xml";

        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 根据配置文件创建会话工厂：SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 利用会话工厂创建会话SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建插入的对象
        User user = new User();
        user.setUsername("王小军");
        user.setBirthday(new Date());
        user.setSex(1);
        user.setAddress("河南郑州");

        // 指定SQL语句、指定插入的对象并执行sql语句
        sqlSession.insert("test.insertUser", user);

        // 提交事务
        sqlSession.commit();

        // 获取刚插入数据的主键，mapper中必须先指定  SELECT LAST_INSERT_ID() 才有用，否则返回0
        System.out.println(user.getId());

        // 关闭会话
        sqlSession.close();

    }

    // 4.删除一条记录
    @Test
    public void deleteUserById() throws IOException {

        // 获取mapper配置文件
        String resource = "SqlMapConfig.xml";

        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 根据配置文件创建会话工厂：SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 利用会话工厂创建会话SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUserById", 32);

        // 提交事务
        sqlSession.commit();

        // 关闭会话
        sqlSession.close();

    }

    // 5.根据用户id更新用户信息
    @Test
    public void updateUserById() throws IOException {

        // 获取mapper配置文件
        String resource = "SqlMapConfig.xml";

        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 根据配置文件创建会话工厂：SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 利用会话工厂创建会话SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(29);
        user.setUsername("罗志祥");
        user.setBirthday(new Date());

        sqlSession.update("test.updateUserById", user);

        // 提交事务
        sqlSession.commit();

        // 关闭会话
        sqlSession.close();


    }

}
