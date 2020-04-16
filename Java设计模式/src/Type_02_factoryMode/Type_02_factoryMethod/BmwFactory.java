package Type_02_factoryMode.Type_02_factoryMethod;

/**
 * @Description: //TODO 具体工厂2：宝马厂，宝马厂造宝马车
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/16 22:28
 */

public class BmwFactory implements factory{
    @Override
    public BmwCar produce() {
        return new BmwCar();
    }
}
