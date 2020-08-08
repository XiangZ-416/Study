package Pakg_02_SpringAOP.Num_02_AopGeneric;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/22 17:05
 */

// 可以使用 @Order 指定切面的优先级：值越小优先级越高
@Order(1)
// 把这个类声明为一个切面：需要把这个类放入 IOC 容器中、再声明为一个切面
@Aspect
@Component
public class LoggingAspect {

    // 定义一个方法，声明切入点表达式：告诉Spring通知在哪个类的哪个方法切入。一般的，该方法中不再需要添加其他的代码
    // 使用 @Pointcut 来声明切入点表达式
    // 后面的其他通知，直接使用方法名来引用切入点表达式
    @Pointcut("execution(* Pakg_02_SpringAOP.Num_02_AopGeneric.*.*(int , int ))")
    public void declareJointPointExpression() {

    }

    // 1.前置通知：在方法开始之前通知
    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName(); // 返回方法名
        List<Object> args = Arrays.asList(joinPoint.getArgs()); // 返回方法参数
        System.out.println(" 前置通知：The method " + methodName + " begins with " + args);
    }

    // 2.后置通知：在目标方法执行后（无论是否发生异常），都执行的通知
    // 在后置通知中还布恩那个返回目标方法执行的结果
    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(" 后置通知：The method " + methodName + " ends ");
    }

    // 3.返回通知：在方法正常结束之后的通知
    // 返回通知是可以访问到方法的返回值的！
    @AfterReturning(value = "declareJointPointExpression()",
        returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
       String methodName = joinPoint.getSignature().getName();
       System.out.println(" 返回通知：The method " + methodName + " ends with " + result);
    }

    // 4.异常通知：在目标方法出现异常时会执行的代码
    // 可以访问到异常对象；且可以指定在出现特定异常时再执行通知代码
    @AfterThrowing(value = "declareJointPointExpression()",
        throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(" 异常通知：The method " + methodName + " occurs with: " + e);
    }

    // 5.环绕通知：需要携带 ProceedingJoinPoint 类型的参数
    // 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
    // 且环绕通知必须有返回值，返回值即为目标方法的返回值
    // @Around("execution(* Pakg_02_Spring.Num_02_AopImpl.*.*(int , int ))")

}
