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
 * @Description: //TODO Mybatis���ų���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/26 16:54
 */
public class Code_01_MybatisFirst {

    // 1.����id��ѯ�û���Ϣ���õ�һ����¼���
    @Test
    public void findUserById() throws IOException {

        // ��ȡmapper�����ļ�
        String resource = "SqlMapConfig.xml";

        // ���������ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // ���������ļ������Ự������SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // ���ûỰ���������ỰSqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //ͨ��SqlSession�������ݿ�
        //��һ��������ӳ���ļ���statement��id������namespace.statement
        //�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
        //sqlSession.selectOne���յĽ������ӳ���ļ�����ƥ���resultType���Ͷ���
        User user = sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);

        //�ͷ���Դ
        sqlSession.close();
    }

    // 2.�����û���ģ����ѯ
    @Test
    public void findUserByUserName() throws IOException {

        // ��ȡmapper�����ļ�
        String resource = "SqlMapConfig.xml";

        // ���������ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // ���������ļ������Ự������SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // ���ûỰ���������ỰSqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // ָ��SQL��䡢���ռλ����ִ��sql���
        List<User> users = sqlSession.selectList("test.findUserByUserName", "С��");

        for (User user : users) {
            System.out.println(user);
        }

        // �رջỰ
        sqlSession.close();

    }

    // 3.���һ����¼
    @Test
    public void insertUser() throws IOException {
        // ��ȡmapper�����ļ�
        String resource = "SqlMapConfig.xml";

        // ���������ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // ���������ļ������Ự������SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // ���ûỰ���������ỰSqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // ��������Ķ���
        User user = new User();
        user.setUsername("��С��");
        user.setBirthday(new Date());
        user.setSex(1);
        user.setAddress("����֣��");

        // ָ��SQL��䡢ָ������Ķ���ִ��sql���
        sqlSession.insert("test.insertUser", user);

        // �ύ����
        sqlSession.commit();

        // ��ȡ�ղ������ݵ�������mapper�б�����ָ��  SELECT LAST_INSERT_ID() �����ã����򷵻�0
        System.out.println(user.getId());

        // �رջỰ
        sqlSession.close();

    }

    // 4.ɾ��һ����¼
    @Test
    public void deleteUserById() throws IOException {

        // ��ȡmapper�����ļ�
        String resource = "SqlMapConfig.xml";

        // ���������ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // ���������ļ������Ự������SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // ���ûỰ���������ỰSqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUserById", 32);

        // �ύ����
        sqlSession.commit();

        // �رջỰ
        sqlSession.close();

    }

    // 5.�����û�id�����û���Ϣ
    @Test
    public void updateUserById() throws IOException {

        // ��ȡmapper�����ļ�
        String resource = "SqlMapConfig.xml";

        // ���������ļ�
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // ���������ļ������Ự������SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // ���ûỰ���������ỰSqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(29);
        user.setUsername("��־��");
        user.setBirthday(new Date());

        sqlSession.update("test.updateUserById", user);

        // �ύ����
        sqlSession.commit();

        // �رջỰ
        sqlSession.close();


    }

}
