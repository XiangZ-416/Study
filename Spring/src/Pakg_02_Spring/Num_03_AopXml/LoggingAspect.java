package Pakg_02_Spring.Num_03_AopXml;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * 可以使用 @Order 注解指定切面的优先级, 值越小优先级越高
 */

public class LoggingAspect {
	

	/**
	 * 在 com.atguigu.spring.aop.ArithmeticCalculator 接口的每一个实现类的每一个方法开始之前执行一段代码
	 */
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		
		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}
	
	/**
	 * 在方法执行之后执行的代码. 无论该方法是否出现异常
	 */
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}
	
	/**
	 * 在方法法正常结束受执行的代码
	 * 返回通知是可以访问到方法的返回值的!
	 */
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	/**
	 * 在目标方法出现异常时会执行的代码.
	 * 可以访问到异常对象; 且可以指定在出现特定异常时在执行通知代码
	 */
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs excetion:" + e);
	}

}
