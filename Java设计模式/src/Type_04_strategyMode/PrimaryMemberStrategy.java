package Type_04_strategyMode;

/**
 * @Description: //TODO ConcreteStrategy(������Խ�ɫ1)��������Ա�ۿ۲���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/18 13:08
 */
public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("���ڳ�����Աû���ۿ�");
        return booksPrice;

    }
}
