package Pakg_02_SpringAOP.Num_02_AopGeneric;

import Pakg_02_SpringAOP.Num_01_AopHelloWorld.Code_01_ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: //TODO ʹ��ע������AOP
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/22 16:42
 */
public class Main {
    public static void main(String[] args) {
        // 1.���� Spring �� IOC ����
        ApplicationContext ctx = new ClassPathXmlApplicationContext("AopGeneric.xml");

        // 2.�� IOC �����л�ȡ bean ��ʵ��
        Code_01_ArithmeticCalculator arithmeticCalculatorImpl = (Code_01_ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        // 3.ʹ�� bean
        int result = arithmeticCalculatorImpl.add(1, 2);
        System.out.println("result:"+ result);

        result = arithmeticCalculatorImpl.div(12, 2);
        System.out.println("result:"+ result);

    }
}
