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
 * @Date:Create�� 2020/4/22 17:05
 */

// ����ʹ�� @Order ָ����������ȼ���ֵԽС���ȼ�Խ��
@Order(1)
// �����������Ϊһ�����棺��Ҫ���������� IOC �����С�������Ϊһ������
@Aspect
@Component
public class LoggingAspect {

    // ����һ�������������������ʽ������Spring֪ͨ���ĸ�����ĸ��������롣һ��ģ��÷����в�����Ҫ��������Ĵ���
    // ʹ�� @Pointcut �������������ʽ
    // ���������֪ͨ��ֱ��ʹ�÷������������������ʽ
    @Pointcut("execution(* Pakg_02_SpringAOP.Num_02_AopGeneric.*.*(int , int ))")
    public void declareJointPointExpression() {

    }

    // 1.ǰ��֪ͨ���ڷ�����ʼ֮ǰ֪ͨ
    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName(); // ���ط�����
        List<Object> args = Arrays.asList(joinPoint.getArgs()); // ���ط�������
        System.out.println(" ǰ��֪ͨ��The method " + methodName + " begins with " + args);
    }

    // 2.����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣������ִ�е�֪ͨ
    // �ں���֪ͨ�л������Ǹ�����Ŀ�귽��ִ�еĽ��
    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(" ����֪ͨ��The method " + methodName + " ends ");
    }

    // 3.����֪ͨ���ڷ�����������֮���֪ͨ
    // ����֪ͨ�ǿ��Է��ʵ������ķ���ֵ�ģ�
    @AfterReturning(value = "declareJointPointExpression()",
        returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
       String methodName = joinPoint.getSignature().getName();
       System.out.println(" ����֪ͨ��The method " + methodName + " ends with " + result);
    }

    // 4.�쳣֪ͨ����Ŀ�귽�������쳣ʱ��ִ�еĴ���
    // ���Է��ʵ��쳣�����ҿ���ָ���ڳ����ض��쳣ʱ��ִ��֪ͨ����
    @AfterThrowing(value = "declareJointPointExpression()",
        throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(" �쳣֪ͨ��The method " + methodName + " occurs with: " + e);
    }

    // 5.����֪ͨ����ҪЯ�� ProceedingJoinPoint ���͵Ĳ���
    // ����֪ͨ�����ڶ�̬�����ȫ���̣�ProceedingJoinPoint ���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��
    // �һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
    // @Around("execution(* Pakg_02_Spring.Num_02_AopImpl.*.*(int , int ))")

}
