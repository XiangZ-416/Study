package Pakg_01_Spring.Num_05_BeansScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/20 20:53
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_01_Spring/beans-scope.xml");

        Object car1 = ctx.getBean("car4");
        Object car2 = ctx.getBean("car4");
        System.out.println(car1 == car2);

    }
}
