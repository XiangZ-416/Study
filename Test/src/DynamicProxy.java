import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: //TODO ��̬����ͨ��Proxy�����������Ȼ�󽫽ӿڷ�����������InvocationHandler��ɵġ�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/29 20:33
 */
public class DynamicProxy {
    public static void main(String[] args) {
        // ����interface�Ĵ������hello
        Hello hello = (Hello) Proxy.newProxyInstance( // ͨ��Proxy.newProxyInstance()����interfaceʵ��
                Hello.class.getClassLoader(), // ������ӿڵ��������
                new Class[]{Hello.class}, // ������ӿڵ��ֽ�������
                new InvocationHandler() { // ��д������߼�
                    /**
                     * ���ã�ִ�б����������κνӿڷ������ᾭ���÷���
                     * @param proxy  ������������
                     * @param method  ��ǰִ�еı��������ķ���
                     * @param args  ��ǰִ�з�������Ĳ���
                     * @return �ͱ�������󷽷�����ͬ�ķ���ֵ
                     **/
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("hello")) {  // �жϵ�ǰ�����ǲ���morning
                            System.out.println("hello, " + args[0]); // ��ǿ�������morning����
                        }
                        return null;
                    }
                }); // ���봦����÷�����InvocationHandler
        // �򱻴������������
        hello.hello("Bob");
    }
}

// ������ӿ�
interface Hello {
    void hello(String name);
}

 