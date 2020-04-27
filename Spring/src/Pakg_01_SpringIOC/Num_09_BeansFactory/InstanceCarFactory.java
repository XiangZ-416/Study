package Pakg_01_SpringIOC.Num_09_BeansFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: //TODO 实例工厂方法：及需要创建工厂本身，再调用工厂的实例方法来返回 bean 的实例
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/21 15:00
 */
public class InstanceCarFactory {
    private Map<String, Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<String, Car>();
        cars.put("奥迪", new Car("奥迪", 300000));
        cars.put("福特", new Car("福特", 400000));
    }

    public Car getCar(String brand) {
        return cars.get(brand);
    }
}
