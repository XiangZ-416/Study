package Pakg_02_SpringAOP.Num_01_AopHelloWorld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Code_04_ArithmeticCalculatorLoggingProxy {

    // ������Ķ���
    private Code_01_ArithmeticCalculator target;

    public Code_04_ArithmeticCalculatorLoggingProxy(Code_01_ArithmeticCalculator target) {
        this.target = target;
    }

    public Code_01_ArithmeticCalculator getLoggingProxy() {
        // ��ʼ���������
        Code_01_ArithmeticCalculator proxy = null;

        // �����������һ�������������
        ClassLoader loader = target.getClass().getClassLoader();
        // �����������ͣ�����������Щ����
        Class [] interfaces = new Class[] {Code_01_ArithmeticCalculator.class};
        // �����ô���������еķ���ʱ����ִ�еĴ���
        InvocationHandler handler = new InvocationHandler() {
            /*
             * proxy�����ڷ��ص��ĸ��������һ������£��� invoke �����ж���ʹ�øö���
             * method�����ڱ����õķ���
             * args�����÷���ʱ������Ĳ���
             **/
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {

                String methodName = method.getName();
                // ��ӡ��־
                System.out.println("[before] The method " + methodName + " begins with " + Arrays.asList(args));
                // ִ�з���
                Object result = method.invoke(target, args);
                //��ӡ��־
                System.out.println("[after] The method ends with " + result);

                return result;
            }
        };
        proxy = (Code_01_ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);

        return proxy;
    }
}
