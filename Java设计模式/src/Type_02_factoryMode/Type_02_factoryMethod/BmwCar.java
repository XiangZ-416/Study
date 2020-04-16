package Type_02_factoryMode.Type_02_factoryMethod;

/**
 * @Description: //TODO 具体产品2：奔驰车
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/16 22:32
 */

public class BmwCar implements Car {
    @Override
    public void outPut() {
        System.out.println("宝马厂生产出一辆宝马车");
    }
}
