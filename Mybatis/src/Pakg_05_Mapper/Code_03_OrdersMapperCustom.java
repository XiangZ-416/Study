package Pakg_05_Mapper;

import Pakg_02_Po.Orders;
import Pakg_02_Po.OrdersCustom;
import Pakg_02_Po.User;

import java.util.List;

/**
 * @Description: //TODO 订单mapper
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/30 16:02
 */
public interface Code_03_OrdersMapperCustom {

    // 一对一映射
    // 1.查询订单关联查询用户：使用ResultType
    public List<OrdersCustom> findOrdersUser() throws Exception;

    // 2.查询订单关联查询用户：使用ResultMap
    public List<Orders> findOrdersUserResultMap() throws Exception;

    // 一对多映射
    // 查询订单关联查询用户和订单明细：使用ResultMap
    public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    // 多对多映射
    // 查询用户及用户购买的商品的信息
    public List<User> findUserAndItemsResultMap() throws Exception;

    //查询订单关联查询用户，其中用户延迟加载
    public List<Orders> findOrdersUserLazyLoading() throws Exception;

}
