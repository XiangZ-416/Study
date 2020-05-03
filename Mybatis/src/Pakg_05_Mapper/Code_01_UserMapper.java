package Pakg_05_Mapper;

import Pakg_02_Po.User;
import Pakg_02_Po.UserCustom;
import Pakg_02_Po.UserQueryVo;

import java.util.List;

/**
 * @Description: //TODO Mapper接口，相当于DAO接口
 *                      Mapper开发规范：
 *                          1、在mapper.xml中 namespace 等于mapper接口地址
 *                          2、mapper.java接口中的 方法名 和mapper.xml中statement的id一致
 *                          3、mapper.java接口中的 方法输入参数类型 和mapper.xml中statement的parameterType指定的类型一致。
 *                          4、mapper.java接口中的 方法返回值类型 和mapper.xml中statement的resultType指定的类型一致
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/27 18:06
 */
public interface Code_01_UserMapper {

    // 用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    // 用户信息综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    // 根据用户id查询用户信息，使用resultMap输出
    public User findUserByIdResultMap(int id) throws Exception;

    // 根据id查询用户信息
    public User findUserById(int id) throws Exception;

    // 根据用户名查询用户列表
    public List<User> findUserByUserName(String username) throws Exception;

    // 添加一条记录
    public void insertUser(User user) throws Exception;

    // 删除一条记录
    public void deleteUserById(int id) throws Exception;

    // 根据id更新用户信息
    public void updateUserById(User user) throws Exception;

}
