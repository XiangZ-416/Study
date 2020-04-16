package Type_02_factoryMode.Type_01_simpleFactory;

import java.util.Scanner;

/**
 * @Description: //TODO 简单工厂模式：将造车与客服分开，实现了解耦合，但未实现开闭原则
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/16 18:56
 */
public class client {
    public static void main(String[] args) throws Exception {
        // 告诉工厂生产一辆奔驰
        Car car = simpleFactory.produceCar(getCarType());
        // 生产
        car.outPut();
    }

    private static String getCarType () {
        System.out.println("输入想要的车名：");
        Scanner input = new Scanner(System.in);

        return input.nextLine();
    }
}
