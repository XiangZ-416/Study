package Pakg_01_Spring.Num_08_Cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/21 11:22
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("bean 的生命周期：");

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_01_Spring/beans-cycle.xml");

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        // 关闭容器
        ctx.close();


    }
}
