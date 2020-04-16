package Type_02_factoryMode.Type_02_factoryMethod;

/**
 * @Description: //TODO 工厂方法模式：分担简单工厂模式下单一工厂的负担，并且实现了开闭原则
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/16 22:29
 */

public class client {
    public static void main(String[] args) {
        BenzFactory benzFactory = new BenzFactory();
        Car car = benzFactory.produce();
        car.outPut();
    }
}
