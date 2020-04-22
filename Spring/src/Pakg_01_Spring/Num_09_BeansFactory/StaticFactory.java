package Pakg_01_Spring.Num_09_BeansFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: //TODO ��̬����������ֱ�ӵ���ĳ����ľ�̬�������Ϳ��Է��� bean ��ʵ��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/21 14:45
 */
public class StaticFactory {
    private static Map<String, Car> cars = new HashMap<>();

    static {
        cars.put("�µ�", new Car("�µ�", 300000));
        cars.put("����", new Car("����", 400000));
    }

    // ��̬��������
    public static Car getCar(String name) {
        return cars.get(name);
    }
}
