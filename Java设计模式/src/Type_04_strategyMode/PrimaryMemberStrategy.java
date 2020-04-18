package Type_04_strategyMode;

/**
 * @Description: //TODO ConcreteStrategy(具体策略角色1)：初级会员折扣策略
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/18 13:08
 */
public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于初级会员没有折扣");
        return booksPrice;

    }
}
