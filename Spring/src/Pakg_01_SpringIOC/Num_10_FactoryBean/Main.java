package Pakg_01_SpringIOC.Num_10_FactoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/21 15:39
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_01_SpringIOC/beans-beanFactory.xml");

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
    }
}
