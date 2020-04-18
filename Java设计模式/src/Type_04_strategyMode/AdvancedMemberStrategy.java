package Type_04_strategyMode;

/**
 * @Description: //TODO ConcreteStrategy(具体策略角色3)：高级会员折扣策略
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/18 13:12
 */
public class AdvancedMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于高级会员打8折");
        return booksPrice * 0.8;

    }
}
