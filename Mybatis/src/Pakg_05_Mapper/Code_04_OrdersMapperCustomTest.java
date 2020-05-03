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
 * @Date:Create�� 2020/4/30 16:08
 */
public class Code_04_OrdersMapperCustomTest {

    private SqlSessionFactory sqlSessionFactory;

    // �˷�����testFindUserById֮ǰִ��
    @Before
    public void setUp() throws Exception {

        // �����Ự����SqlSessionFactory
        // ��ȡmapper�����ļ�
        String resource = "SqlMapConfig.xml";

        // ���������ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // ���������ļ������Ự������SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void TestFindOrdersUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //����Code_03_OrdersMapperCustom�������
        Code_03_OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(Code_03_OrdersMapperCustom.class);

        //����mapper�ķ���
        List<OrdersCustom> ordersCustoms = ordersMapperCustom.findOrdersUser();

        System.out.println(ordersCustoms);

        sqlSession.close();

    }

    @Test
    public void TestFindOrdersUserResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //����Code_03_OrdersMapperCustom�������
        Code_03_OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(Code_03_OrdersMapperCustom.class);

        //����mapper�ķ���
        List<Orders> ordersCustoms = ordersMapperCustom.findOrdersUserResultMap();

        System.out.println(ordersCustoms);

        sqlSession.close();

    }

    @Test
    public void TestFindOrdersAndOrderDetailResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //����Code_03_OrdersMapperCustom�������
        Code_03_OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(Code_03_OrdersMapperCustom.class);

        //����mapper�ķ���
        List<Orders> orderDetailResultMap = ordersMapperCustom.findOrdersAndOrderDetailResultMap();

        System.out.println(orderDetailResultMap);

        sqlSession.close();

    }

    @Test
    public void TestFindUserAndItemsResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //����Code_03_OrdersMapperCustom�������
        Code_03_OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(Code_03_OrdersMapperCustom.class);

        //����mapper�ķ���
        List<User> orderDetailResultMap = ordersMapperCustom.findUserAndItemsResultMap();

        System.out.println(orderDetailResultMap);

        sqlSession.close();

    }

    @Test
    public void TestFindOrdersUserLazyLoading() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //����Code_03_OrdersMapperCustom�������
        Code_03_OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(Code_03_OrdersMapperCustom.class);

        //����mapper�ķ���
        List<Orders> ordersUserLazyLoading = ordersMapperCustom.findOrdersUserLazyLoading();

        // �����ϱߵĲ�ѯ�б�
        for(Orders orders : ordersUserLazyLoading) {
            User user = orders.getUser();
            System.out.println(user);
        }

    }

    // ����һ�����棺ÿ��sqlSession����һ��������һ�����棨HashMapʵ�֣�
    // ÿ��ִ��sqlSession.commit֮��ͻ����һ������
    @Test
    public void testFirstCache() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class);

        User user1 = userMapper.findUserById(1);

        //��һ�˷������󣬸���idΪ1���û�
        user1.setUsername("����һ������");
        user1.setId(1);
        userMapper.updateUserById(user1);
        sqlSession.commit(); // sqlSessionִ������ɾ���ĺ��commit����֮��ͻ����sqlSession��һ�����������
                             // Ŀ�ģ���֤�Լ�����洢��ʱ���µ����ݣ��������
                             // MybatisĬ��֧��һ������

        //�ڶ��η��������ѯidΪ1���û�����Ҫ�����ݿ��в�
        User user2 = userMapper.findUserById(1);
        System.out.println(user2);

        sqlSession.close();

    }

    // ���Զ������棺ÿ��mapper��ǩ����һ������������򣨶���������Բ����ڴ棩��MybatisĬ��֧�ֶ������棬����ͨ��flushCache="false"�رն������档
    // ֻ��һ��sqlSessionִ��close֮��Ŷ���һ��sqlSession�����������档��һ��sqlSessionִ��commit()������
    // ��sqlSession���ڵ�mapper�ļ���Ӧ�Ķ������潫�����
    @Test
    public void testSecondCache() throws Exception {

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        Code_01_UserMapper userMapper1 = sqlSession1.getMapper(Code_01_UserMapper.class);
        User user1 = userMapper1.findUserById(1);
        sqlSession1.close(); // ֻ��ִ�йر�sqlSession1����������������
        System.out.println(user1);

        // ʹ��sqlSession3ִ��commit()�������UserMapper�µĶ�������
        Code_01_UserMapper userMapper3 = sqlSession3.getMapper(Code_01_UserMapper.class);
        User user3 = userMapper3.findUserById(1);
        user3.setUsername("���Զ�������");
        user3.setId(1);
        userMapper3.updateUserById(user3);
        sqlSession3.commit(); // ֻ��ִ���ύ�Ż����UserMapper�µĶ�������
        sqlSession3.close();

        Code_01_UserMapper userMapper2 = sqlSession2.getMapper(Code_01_UserMapper.class);
        User user2 = userMapper2.findUserById(1);
        sqlSession2.close();
        System.out.println(user2);

    }



}
