package Pakg_01_SpringIOC.Num_03_AutoWire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/20 17:52
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_01_SpringIOC/beans-autoWire.xml");

        Person person = (Person) ctx.getBean("person5");
        System.out.println(person);
    }
}
