package Type_04_strategyMode;

/**
 * @Description: //TODO ConcreteStrategy(������Խ�ɫ2)���м���Ա�ۿ۲���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/18 13:10
 */
public class IntermediateMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("�����м���Ա��9��");
        return booksPrice * 0.9;

    }
}
