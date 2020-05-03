package Pakg_05_Mapper;

import Pakg_02_Po.Orders;
import Pakg_02_Po.OrdersCustom;
import Pakg_02_Po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/30 16:08
 */
public class Code_04_OrdersMapperCustomTest {

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
    public void TestFindOrdersUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建Code_03_OrdersMapperCustom代理对象
        Code_03_OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(Code_03_OrdersMapperCustom.class);

        //调用mapper的方法
        List<OrdersCustom> ordersCustoms = ordersMapperCustom.findOrdersUser();

        System.out.println(ordersCustoms);

        sqlSession.close();

    }

    @Test
    public void TestFindOrdersUserResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建Code_03_OrdersMapperCustom代理对象
        Code_03_OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(Code_03_OrdersMapperCustom.class);

        //调用mapper的方法
        List<Orders> ordersCustoms = ordersMapperCustom.findOrdersUserResultMap();

        System.out.println(ordersCustoms);

        sqlSession.close();

    }

    @Test
    public void TestFindOrdersAndOrderDetailResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建Code_03_OrdersMapperCustom代理对象
        Code_03_OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(Code_03_OrdersMapperCustom.class);

        //调用mapper的方法
        List<Orders> orderDetailResultMap = ordersMapperCustom.findOrdersAndOrderDetailResultMap();

        System.out.println(orderDetailResultMap);

        sqlSession.close();

    }

    @Test
    public void TestFindUserAndItemsResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建Code_03_OrdersMapperCustom代理对象
        Code_03_OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(Code_03_OrdersMapperCustom.class);

        //调用mapper的方法
        List<User> orderDetailResultMap = ordersMapperCustom.findUserAndItemsResultMap();

        System.out.println(orderDetailResultMap);

        sqlSession.close();

    }

    @Test
    public void TestFindOrdersUserLazyLoading() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建Code_03_OrdersMapperCustom代理对象
        Code_03_OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(Code_03_OrdersMapperCustom.class);

        //调用mapper的方法
        List<Orders> ordersUserLazyLoading = ordersMapperCustom.findOrdersUserLazyLoading();

        // 遍历上边的查询列表
        for(Orders orders : ordersUserLazyLoading) {
            User user = orders.getUser();
            System.out.println(user);
        }

    }

    // 测试一级缓存：每个sqlSession都有一个独立的一级缓存（HashMap实现）
    // 每次执行sqlSession.commit之后就会清除一级缓存
    @Test
    public void testFirstCache() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class);

        User user1 = userMapper.findUserById(1);

        //第一此发出请求，更新id为1的用户
        user1.setUsername("测试一级缓存");
        user1.setId(1);
        userMapper.updateUserById(user1);
        sqlSession.commit(); // sqlSession执行增、删、改后的commit操作之后就会清空sqlSession中一级缓存的数据
                             // 目的：保证以及缓存存储的时最新的数据，避免脏读
                             // Mybatis默认支持一级缓存

        //第二次发出请求查询id为1的用户，需要从数据库中查
        User user2 = userMapper.findUserById(1);
        System.out.println(user2);

        sqlSession.close();

    }

    // 测试二级缓存：每个mapper标签共享一块二级缓存区域（二级缓存可以不是内存），Mybatis默认支持二级缓存，可以通过flushCache="false"关闭二级缓存。
    // 只有一个sqlSession执行close之后才对另一个sqlSession开启二级缓存。当一个sqlSession执行commit()操作后，
    // 该sqlSession所在的mapper文件对应的二级缓存将被清空
    @Test
    public void testSecondCache() throws Exception {

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        Code_01_UserMapper userMapper1 = sqlSession1.getMapper(Code_01_UserMapper.class);
        User user1 = userMapper1.findUserById(1);
        sqlSession1.close(); // 只有执行关闭sqlSession1才能启动二级缓存
        System.out.println(user1);

        // 使用sqlSession3执行commit()操作清空UserMapper下的二级缓存
        Code_01_UserMapper userMapper3 = sqlSession3.getMapper(Code_01_UserMapper.class);
        User user3 = userMapper3.findUserById(1);
        user3.setUsername("测试二级缓存");
        user3.setId(1);
        userMapper3.updateUserById(user3);
        sqlSession3.commit(); // 只有执行提交才会清空UserMapper下的二级缓存
        sqlSession3.close();

        Code_01_UserMapper userMapper2 = sqlSession2.getMapper(Code_01_UserMapper.class);
        User user2 = userMapper2.findUserById(1);
        sqlSession2.close();
        System.out.println(user2);

    }



}
