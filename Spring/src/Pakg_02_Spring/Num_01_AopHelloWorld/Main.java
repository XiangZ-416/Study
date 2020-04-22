package Pakg_02_Spring.Num_01_AopHelloWorld;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/22 15:39
 */
public class Main {
    public static void main(String[] args) {

//        Code_01_ArithmeticCalculator arithmeticCalculator = new Code_03_ArithmeticCalculatorLoggingImpl();

        // 获取被代理对象
        Code_01_ArithmeticCalculator target = new Code_02_ArithmeticCalculatorImpl();
        // 获取代理对象
        Code_01_ArithmeticCalculator proxy = new Code_04_ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

        int result = proxy.add(1, 2);
        System.out.println("-->" + result);

        result = proxy.div(4, 2);
        System.out.println("-->" + result);
    }
}
