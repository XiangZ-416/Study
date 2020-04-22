package Pakg_01_Spring.Num_11_beansAnnotation;

import Pakg_01_Spring.Num_11_beansAnnotation.AnnotationController.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/21 20:35
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_01_Spring/beans-Annotation.xml");

//        TestObject to = (TestObject) ctx.getBean("testObject");
//        System.out.println(to);

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();
//
//        UserService userService = (UserService) ctx.getBean("userService");
//        System.out.println(userService);

//        UserRepository userRepository = (UserRepository) ctx.getBean("UserRepository");
//        System.out.println(userRepository);
    }
}
