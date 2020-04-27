package Pakg_01_SpringIOC.Num_01_SpringBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/18 17:15
 */
public class Main {
    public static void main(String[] args) {
//        // 1.����HelloWorld����
//        HelloWorld helloWorld = new HelloWorld();
//        // 2.Ϊ����name��ֵ
//        helloWorld.setName("Spring");
//        // 3.����hello����
//        helloWorld.hello();

        // 1.���� Spring �� IOC ��������
        // ApplicationContext������ IOC ����
        // ClassPathXmlApplicationContext���� ApplicationContext �ӿڵ�ʵ���࣬��ʵ�ִ���·���������������ļ�
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_01_SpringIOC/applicationContext.xml");

        // 2.�� IOC �����л�ȡ bean ʵ��
        // ���� id ��λ�� IOC �����е� bean ʵ��
        HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
        // �������ͷ��� IOC �����е� bean����Ҫ�� IOC ������ֻ����һ�������͵� bean ʵ��
        //HelloWorld bean = ctx.getBean(HelloWorld.class);
        // 3.����hello����
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
