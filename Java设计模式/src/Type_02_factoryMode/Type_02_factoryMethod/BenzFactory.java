package Type_02_factoryMode.Type_02_factoryMethod;


/**
 * @Description: //TODO 具体工厂1：奔驰厂，奔驰厂造奔驰车
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/16 22:27
 */

public class BenzFactory implements factory {
    @Override
    public BenzCar produce() {
        return new BenzCar();
    }
}
