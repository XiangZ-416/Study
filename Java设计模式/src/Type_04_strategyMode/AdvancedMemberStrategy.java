package Type_04_strategyMode;

/**
 * @Description: //TODO ConcreteStrategy(������Խ�ɫ3)���߼���Ա�ۿ۲���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/18 13:12
 */
public class AdvancedMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("���ڸ߼���Ա��8��");
        return booksPrice * 0.8;

    }
}
