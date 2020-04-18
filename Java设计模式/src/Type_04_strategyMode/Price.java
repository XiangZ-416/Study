package Type_04_strategyMode;

/**
 * @Description: //TODO Context(������ɫ)���۸���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/18 13:15
 */
public class Price {

    // ������Ϸ�ʽ����һ������Ĳ��Զ���
    MemberStrategy strategy;

    /**
     * ���캯��������һ������Ĳ��Զ���
     * @param strategy    ����Ĳ��Զ���
     */
    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * ����ͼ��ļ۸�
     * @param booksPrice    ͼ���ԭ��
     * @return    ��������ۺ�ļ۸�
     */
    public double quote(double booksPrice){
        return this.strategy.calcPrice(booksPrice);
    }
}
