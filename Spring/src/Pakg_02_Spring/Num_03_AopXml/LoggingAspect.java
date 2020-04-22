package Pakg_02_Spring.Num_03_AopXml;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * ����ʹ�� @Order ע��ָ����������ȼ�, ֵԽС���ȼ�Խ��
 */

public class LoggingAspect {
	

	/**
	 * �� com.atguigu.spring.aop.ArithmeticCalculator �ӿڵ�ÿһ��ʵ�����ÿһ��������ʼ֮ǰִ��һ�δ���
	 */
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		
		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}
	
	/**
	 * �ڷ���ִ��֮��ִ�еĴ���. ���۸÷����Ƿ�����쳣
	 */
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
	/**
	 * �ڷ���������������ִ�еĴ���
	 * ����֪ͨ�ǿ��Է��ʵ������ķ���ֵ��!
	 */
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	/**
	 * ��Ŀ�귽�������쳣ʱ��ִ�еĴ���.
	 * ���Է��ʵ��쳣����; �ҿ���ָ���ڳ����ض��쳣ʱ��ִ��֪ͨ����
	 */
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs excetion:" + e);
	}

}
