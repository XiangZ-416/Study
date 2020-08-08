import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: //TODO 动态代理：通过Proxy创建代理对象，然后将接口方法“代理”给InvocationHandler完成的。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/29 20:33
 */
public class DynamicProxy {
    public static void main(String[] args) {
        // 创建interface的代理对象hello
        Hello hello = (Hello) Proxy.newProxyInstance( // 通过Proxy.newProxyInstance()创建interface实例
                Hello.class.getClassLoader(), // 被代理接口的类加载器
                new Class[]{Hello.class}, // 被代理接口的字节码数组
                new InvocationHandler() { // 编写代理的逻辑
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy  代理对象的引用
                     * @param method  当前执行的被代理对象的方法
                     * @param args  当前执行方法所需的参数
                     * @return 和被代理对象方法有相同的返回值
                     **/
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("hello")) {  // 判断当前方法是不是morning
                            System.out.println("hello, " + args[0]); // 增强被代理的morning方法
                        }
                        return null;
                    }
                }); // 传入处理调用方法的InvocationHandler
        // 向被代理方法传入参数
        hello.hello("Bob");
    }
}

// 被代理接口
interface Hello {
    void hello(String name);
}

 