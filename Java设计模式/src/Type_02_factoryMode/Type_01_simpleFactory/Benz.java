package Type_02_factoryMode.Type_01_simpleFactory;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/16 18:52
 */

// 具体产品角色1：奔驰车
public class Benz implements Car{
    @Override
    public void produce() {
        System.out.println("生产出一辆奔驰车");
    }
}
