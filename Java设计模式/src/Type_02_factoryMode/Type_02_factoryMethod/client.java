package Type_02_factoryMode.Type_02_factoryMethod;

/**
 * @Description: //TODO ��������ģʽ���ֵ��򵥹���ģʽ�µ�һ�����ĸ���������ʵ���˿���ԭ��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/16 22:29
 */

public class client {
    public static void main(String[] args) {
        BenzFactory benzFactory = new BenzFactory();
        Car car = benzFactory.produce();
        car.outPut();
    }
}
