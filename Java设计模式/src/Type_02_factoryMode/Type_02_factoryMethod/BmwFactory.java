package Type_02_factoryMode.Type_02_factoryMethod;

/**
 * @Description: //TODO ���幤��2�������������챦��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/16 22:28
 */

public class BmwFactory implements factory{
    @Override
    public BmwCar produce() {
        return new BmwCar();
    }
}
