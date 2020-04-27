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
 * @Date:Create�� 2020/4/27 18:24
 */
public class Code_03_UserDaoImplTest {

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
    public void testFindUserById() throws Exception {

        // ͨ�����캯��ע��Ự����������UserDaoImpl����
        Code_01_UserDao userDao = new Code_02_UserDaoImpl(sqlSessionFactory);

        // ����UserDao����
        User user = userDao.findUserById(1);

        System.out.println(user);

    }

}
