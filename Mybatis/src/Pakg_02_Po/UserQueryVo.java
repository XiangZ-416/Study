package Pakg_02_Po;

import java.util.List;

/**
 * @Description: //TODO ��װ������Ϊ�ۺϲ�ѯ���������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/28 21:19
 */
public class UserQueryVo {

    // ������id
    private List<Integer> ids;

    // �������װ����Ҫ�Ĳ�ѯ����

    // �û���ѯ����
    private UserCustom userCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    // ���԰�װ�����Ĳ�ѯ�������綩������Ʒ

}
