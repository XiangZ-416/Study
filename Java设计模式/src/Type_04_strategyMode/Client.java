package Type_04_strategyMode;

/**
 * @Description: //TODO �ͻ���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/18 13:17
 */
public class Client {
    public static void main(String[] args) {

        //ѡ�񲢴�����Ҫʹ�õĲ��Զ���
        MemberStrategy strategy = new AdvancedMemberStrategy(); // �߼���Ա�ۿ۲���
        //��������
        Price price = new Price(strategy);
        //����۸�
        double quote = price.quote(300);
        System.out.println("ͼ������ռ۸�Ϊ��" + quote);

    }
}
