package Pakg_04_DAO;

import Pakg_02_Po.User;

/**
 * @Description: //TODO DAO�ӿڣ���������ɾ���ġ��鷽��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/27 18:06
 */
public interface Code_01_UserDao {

    // ����id��ѯ�û���Ϣ
    public User findUserById(int id) throws Exception;

    // ���һ����¼
    public void insertUser(User user) throws Exception;

    // ɾ��һ����¼
    public void deleteUser(int id) throws Exception;

}
