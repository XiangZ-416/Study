package Pakg_04_DAO;

import Pakg_02_Po.User;

/**
 * @Description: //TODO DAO接口：声明增、删、改、查方法
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/27 18:06
 */
public interface Code_01_UserDao {

    // 根据id查询用户信息
    public User findUserById(int id) throws Exception;

    // 添加一条记录
    public void insertUser(User user) throws Exception;

    // 删除一条记录
    public void deleteUser(int id) throws Exception;

}
