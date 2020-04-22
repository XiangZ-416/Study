package Pakg_01_Spring.Num_02_BeansCollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/20 16:18
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_01_Spring/applicationContext.xml");

        Person person2 = (Person) ctx.getBean("person2");
        System.out.println(person2);

        NewPerson newPerson = (NewPerson) ctx.getBean("newPerson");
        System.out.println(newPerson);

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);

        Person person3 = (Person) ctx.getBean("person3");
        System.out.println(person3);

        Person person4 = (Person) ctx.getBean("person4");
        System.out.println(person4);
    }
}
