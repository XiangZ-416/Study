package Pakg_01_SpringIOC.Num_04_BeansRelation;

import Pakg_01_SpringIOC.Num_03_AutoWire.Address;
import Pakg_01_SpringIOC.Num_03_AutoWire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/20 20:06
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_01_SpringIOC/beans-relation.xml");

//        Address address1 = (Address) ctx.getBean("address1");
//        System.out.println(address1);

        Address address2 = (Address) ctx.getBean("address2");
        System.out.println(address2);

        Person person6 = (Person) ctx.getBean("person6");
        System.out.println(person6);

    }
}
