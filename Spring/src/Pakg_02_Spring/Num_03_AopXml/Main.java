package Pakg_02_Spring.Num_03_AopXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ZX
 * @Description //TODO 使用XML文件配置AOP
 * @Date 21:12 2020/4/22
 * @Param
 * @return
 **/
public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Pakg_02_Spring/AopXml.xml");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		System.out.println(arithmeticCalculator.getClass().getName());
		
		int result = arithmeticCalculator.add(1, 2);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(1000, 10);
		System.out.println("result:" + result);
	}
	
}
