package Type_04_strategyMode;

/**
 * @Description: //TODO Strategy(������Խ�ɫ)�������ۿ۽ӿ�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/18 13:06
 */
public interface MemberStrategy {
    /**
     * @Author ZX
     * @Description //TODO ����ͼ����ۺ�ļ۸�
     * @Date 13:08 2020/4/18
     * @Param [booksPrice] ͼ���ԭ��
     * @return double
     **/
    public double calcPrice(double booksPrice);
}
