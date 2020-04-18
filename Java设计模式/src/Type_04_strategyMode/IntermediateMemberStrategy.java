package Type_04_strategyMode;

/**
 * @Description: //TODO ConcreteStrategy(具体策略角色2)：中级会员折扣策略
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/18 13:10
 */
public class IntermediateMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("对于中级会员打9折");
        return booksPrice * 0.9;

    }
}
