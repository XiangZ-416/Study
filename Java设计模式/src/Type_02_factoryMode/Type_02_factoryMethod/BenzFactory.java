package Type_02_factoryMode.Type_02_factoryMethod;


/**
 * @Description: //TODO ���幤��1�����۳������۳��챼�۳�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/16 22:27
 */

public class BenzFactory implements factory {
    @Override
    public BenzCar produce() {
        return new BenzCar();
    }
}
