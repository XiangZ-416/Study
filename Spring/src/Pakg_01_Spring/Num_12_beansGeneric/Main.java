package Pakg_01_Spring.Num_12_beansGeneric;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/21 21:40
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_01_Spring/beans-generic.xml");

        UserService userService = (UserService) ctx.getBean("userService");
        userService.add();
    }
}
