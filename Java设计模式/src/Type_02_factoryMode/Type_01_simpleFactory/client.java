package Type_02_factoryMode.Type_01_simpleFactory;

import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/16 18:56
 */
public class client {
    public static void main(String[] args) throws Exception {
        // 告诉工厂生产一辆奔驰
        Car car = simpleFactory.produceCar(getCarType());
        // 生产
        car.produce();
    }

    private static String getCarType () {
        System.out.println("输入想要的车名：");
        Scanner input = new Scanner(System.in);

        return input.nextLine();
    }
}
