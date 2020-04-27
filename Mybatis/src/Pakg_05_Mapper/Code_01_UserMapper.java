package Pakg_05_Mapper;

import Pakg_02_Po.User;

import java.util.List;

/**
 * @Description: //TODO Mapper�ӿڣ��൱��DAO�ӿ�
 *                      Mapper�����淶��
 *                          1����mapper.xml�� namespace ����mapper�ӿڵ�ַ
 *                          2��mapper.java�ӿ��е� ������ ��mapper.xml��statement��idһ��
 *                          3��mapper.java�ӿ��е� ��������������� ��mapper.xml��statement��parameterTypeָ��������һ�¡�
 *                          4��mapper.java�ӿ��е� ��������ֵ���� ��mapper.xml��statement��resultTypeָ��������һ��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/27 18:06
 */
public interface Code_01_UserMapper {

    // ����id��ѯ�û���Ϣ
    public User findUserById(int id) throws Exception;

    // �����û�����ѯ�û��б�
    public List<User> findUserByUserName(String username) throws Exception;

    // ���һ����¼
    public void insertUser(User user) throws Exception;

    // ɾ��һ����¼
    public void deleteUserById(int id) throws Exception;

}
