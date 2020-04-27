package Pakg_02_SpringAOP.Num_01_AopHelloWorld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Code_04_ArithmeticCalculatorLoggingProxy {

    // 被代理的对象
    private Code_01_ArithmeticCalculator target;

    public Code_04_ArithmeticCalculatorLoggingProxy(Code_01_ArithmeticCalculator target) {
        this.target = target;
    }

    public Code_01_ArithmeticCalculator getLoggingProxy() {
        // 初始化代理对象
        Code_01_ArithmeticCalculator proxy = null;

        // 代理对象由哪一个类加载器加载
        ClassLoader loader = target.getClass().getClassLoader();
        // 代理对象的类型，即其中有哪些方法
        Class [] interfaces = new Class[] {Code_01_ArithmeticCalculator.class};
        // 当调用代理对象其中的方法时，该执行的代码
        InvocationHandler handler = new InvocationHandler() {
            /*
             * proxy：正在返回的哪个代理对象，一般情况下，在 invoke 方法中都不使用该对象
             * method：正在被调用的方法
             * args：调用方法时，传入的参数
             **/
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {

                String methodName = method.getName();
                // 打印日志
                System.out.println("[before] The method " + methodName + " begins with " + Arrays.asList(args));
                // 执行方法
                Object result = method.invoke(target, args);
                //打印日志
                System.out.println("[after] The method ends with " + result);

                return result;
            }
        };
        proxy = (Code_01_ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);

        return proxy;
    }
}
