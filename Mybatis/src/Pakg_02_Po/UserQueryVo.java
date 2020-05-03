package Pakg_02_Po;

import java.util.List;

/**
 * @Description: //TODO 包装类型作为综合查询的输入参数
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/28 21:19
 */
public class UserQueryVo {

    // 传入多个id
    private List<Integer> ids;

    // 在这里包装所需要的查询条件

    // 用户查询条件
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

    // 可以包装其他的查询条件，如订单、商品

}
