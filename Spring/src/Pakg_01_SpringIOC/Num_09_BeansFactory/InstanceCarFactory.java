package Pakg_01_SpringIOC.Num_09_BeansFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: //TODO ʵ����������������Ҫ�������������ٵ��ù�����ʵ������������ bean ��ʵ��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/21 15:00
 */
public class InstanceCarFactory {
    private Map<String, Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<String, Car>();
        cars.put("�µ�", new Car("�µ�", 300000));
        cars.put("����", new Car("����", 400000));
    }

    public Car getCar(String brand) {
        return cars.get(brand);
    }
}
