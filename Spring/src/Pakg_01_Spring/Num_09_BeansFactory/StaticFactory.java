package Pakg_01_Spring.Num_09_BeansFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: //TODO 静态工厂方法：直接调用某个类的静态方法，就可以返回 bean 的实例
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/21 14:45
 */
public class StaticFactory {
    private static Map<String, Car> cars = new HashMap<>();

    static {
        cars.put("奥迪", new Car("奥迪", 300000));
        cars.put("福特", new Car("福特", 400000));
    }

    // 静态工厂方法
    public static Car getCar(String name) {
        return cars.get(name);
    }
}
