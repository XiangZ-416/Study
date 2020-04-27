package Pakg_01_SpringIOC.Num_01_SpringBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/18 17:15
 */
public class Main {
    public static void main(String[] args) {
//        // 1.创建HelloWorld对象
//        HelloWorld helloWorld = new HelloWorld();
//        // 2.为属性name赋值
//        helloWorld.setName("Spring");
//        // 3.调用hello方法
//        helloWorld.hello();

        // 1.创建 Spring 的 IOC 容器对象
        // ApplicationContext：代表 IOC 容器
        // ClassPathXmlApplicationContext：是 ApplicationContext 接口的实现类，该实现从类路径下来加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_01_SpringIOC/applicationContext.xml");

        // 2.从 IOC 容器中获取 bean 实例
        // 利用 id 定位到 IOC 容器中的 bean 实例
        HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
        // 利用类型返回 IOC 容器中的 bean，但要求 IOC 容器中只能由一个该类型的 bean 实例
        //HelloWorld bean = ctx.getBean(HelloWorld.class);
        // 3.调用hello方法
        //helloWorld.hello();
        helloWorld.hello();


        Car car1 = (Car)ctx.getBean("car1");
        System.out.println(car1);

        Car car2 = (Car)ctx.getBean("car2");
        System.out.println(car2);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

    }
}
