package Pakg_05_Mapper;

import Pakg_02_Po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/27 22:40
 */
public class Code_02_UserMapperTest {

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

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // ����UserMapper����,Mybatis�Զ�����mapper�������
        Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class);

        // ����userMapper�ķ���
        User user = userMapper.findUserById(1);

        System.out.println(user);

    }

}
