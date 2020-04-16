package Type_02_factoryMode.Type_01_simpleFactory;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/16 18:53
 */

// 具体产品角色2：宝马车
public class Bmw implements Car {
    @Override
    public void produce() {
        System.out.println("生产出一辆宝马车");
    }
}
