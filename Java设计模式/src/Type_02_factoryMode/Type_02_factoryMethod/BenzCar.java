package Type_02_factoryMode.Type_02_factoryMethod;

/**
 * @Description: //TODO 具体产品1：宝马车
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/16 22:31
 */

public class BenzCar implements Car {
    @Override
    public void outPut() {
        System.out.println("奔驰厂生产出一辆奔驰车");
    }
}
