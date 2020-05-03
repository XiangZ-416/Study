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

    // �û���Ϣ�ۺϲ�ѯ
    @Test
    public void testFindUserList() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // ����UserMapper����,Mybatis�Զ�����mapper�������
        Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class);

        // ������װ�������ò�ѯ����
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex(1);
        userCustom.setUsername("С��");
        //ʹ��foreachҪ������id
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        //��idsͨ��userQueryVo����Statement
        userQueryVo.setIds(ids);
        userQueryVo.setUserCustom(userCustom);

        // ����userMapper�ķ���
        List<UserCustom> users = userMapper.findUserList(userQueryVo);

        System.out.println(users);

    }

    @Test
    public void testFindUserCount() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // ����UserMapper����,Mybatis�Զ�����mapper�������
        Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class);

        // ������װ�������ò�ѯ����
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex(1);
        userCustom.setUsername("������");
        userQueryVo.setUserCustom(userCustom);

        // ����userMapper�ķ���
        int count = userMapper.findUserCount(userQueryVo);

        System.out.println(count);

    }

    @Test
    public void testFindUserByIdResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // ����UserMapper����,Mybatis�Զ�����mapper�������
        Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class);

        // ����userMapper�ķ���
        User user = userMapper.findUserByIdResultMap(1);

        System.out.println(user);

    }

}
