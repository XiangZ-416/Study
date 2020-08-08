package Type_01_SingletonMode.Type_02_Lazy;

/**
 * @Description: //TODO ����ģʽ������ʵ��(�̲߳���ȫ���̰߳�ȫ)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/15 20:11
 */
public class lazyMan {
    public static void main(String[] args) {
        lazy instance1 = lazy.getInstance();
        lazy instance2 = lazy.getInstance();

        System.out.println(instance1 == instance2);
    }
}
// 1.�̲߳���ȫ
//   �ŵ㣺ʵ���������أ��������ڴ���˷�
//   ȱ�㣺ֻ���ڵ��߳���ʹ�á������߳�1����getInstance�е�if��û���ü�����ִ�У�
//         ��һ���߳�ͨ�������if����ʱ�Ϳ��ܳ����������󡣾Ͳ��ǵ���ģʽ�ˡ�
//class lazy {
//    // 1.˽�пղι��췽��
//    private lazy() {
//    }
//    // 2.�������˽�о�̬ʵ��
//    private static lazy instance;
//    // 3.������̬����getInstance���������һ��ʵ�������ô˷���ʱ�Ŵ��������ʵ�������Գ�������ģʽ
//    public static lazy getInstance() {
//        if (instance == null) {
//            instance = new lazy();
//        }
//        return instance;
//    }
//}

// 2.�̰߳�ȫ��ͬ��������
// �ŵ㣺������̲߳���ȫ������
// ȱ�㣺Ч��̫���ˡ�ÿ�ε���getInstance������Ҫ�ж�������getInstance������Ϊ���߳�
//class lazy {
//    // 1.˽�пղι��췽��
//    private lazy() {
//    }
//    // 2.�������˽�о�̬ʵ��
//    private static lazy instance;
//    // 3.������̬����getInstance���������һ��ʵ�������ô˷���ʱ�Ŵ��������ʵ�������Գ�������ģʽ
//    // ��Ϊͬ������
//    public static synchronized lazy getInstance() {
//        if (instance == null) {
//            instance = new lazy();
//        }
//        return instance;
//    }
//}

// 3.�̰߳�ȫ��ͬ������� + ˫�ؼ�� + ��ָֹ��������
// �ŵ㣺������̰߳�ȫ���⡢Ч������
//class lazy {
//    // 1.˽�пղι��췽��
//    private lazy() {
//
//    }
//    // 2.�������˽�о�̬ʵ��
//    private static volatile lazy instance; // volatile����ָֹ�������򣬼�����Ĵ��밴�ճ������ִ��
//    // 3.������̬����getInstance���������һ��ʵ�������ô˷���ʱ�Ŵ��������ʵ�������Գ�������ģʽ
//    // ��Ϊ˫�ؼ�� + ͬ�������
//    public static lazy getInstance() {
//        if (instance == null) { // ��һ���ж�
//            synchronized (lazy.class) { // ����ʱ��lazy������class��Ϊͬ����
//                if (instance == null) { // �ڶ����ж�
//                    instance = new lazy();
//                }
//            }
//        }
//        return instance;
//    }
//    // ���ⷴ�����ƻ�
//    protected Object readResolve() {
//        return instance;
//    }
//}

// 4.��̬�ڲ���ʵ�֣��̰߳�ȫ + ������Ψһ�� + �ӳټ��أ�
class lazy{
    private lazy(){}

    private static class lazyInner{
        private static lazy instance = new lazy();
    }

    public static lazy getInstance(){
        return lazyInner.instance;
    }
}


// 5.ö���ഴ������ģʽ(�ɱ��ⵥ���������ƻ�)
//enum Lazy {
//    INSTANCE;
//    // ����������һ���յ�˽�й��췽��
//    private Lazy () {
//
//    }
//}

// ��׼��enum����ģʽ���������д������ʵ�ֽӿڵ���ʽ
// ���嵥��ģʽ����Ҫ��ɵĴ����߼�
interface Lazy {
    void doSomething();
}

enum Singleton implements Lazy {
    INSTANCE {
        @Override
        public void doSomething() {
            System.out.println("complete singleton");
        }
    };

    public static Lazy getInstance() {
        return Singleton.INSTANCE;
    }
}

// Java.lang.Runtime������˵���ģʽ�Ķ���ʽ