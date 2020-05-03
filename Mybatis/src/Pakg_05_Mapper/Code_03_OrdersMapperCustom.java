package Pakg_05_Mapper;

import Pakg_02_Po.Orders;
import Pakg_02_Po.OrdersCustom;
import Pakg_02_Po.User;

import java.util.List;

/**
 * @Description: //TODO ����mapper
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/30 16:02
 */
public interface Code_03_OrdersMapperCustom {

    // һ��һӳ��
    // 1.��ѯ����������ѯ�û���ʹ��ResultType
    public List<OrdersCustom> findOrdersUser() throws Exception;

    // 2.��ѯ����������ѯ�û���ʹ��ResultMap
    public List<Orders> findOrdersUserResultMap() throws Exception;

    // һ�Զ�ӳ��
    // ��ѯ����������ѯ�û��Ͷ�����ϸ��ʹ��ResultMap
    public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    // ��Զ�ӳ��
    // ��ѯ�û����û��������Ʒ����Ϣ
    public List<User> findUserAndItemsResultMap() throws Exception;

    //��ѯ����������ѯ�û��������û��ӳټ���
    public List<Orders> findOrdersUserLazyLoading() throws Exception;

}
