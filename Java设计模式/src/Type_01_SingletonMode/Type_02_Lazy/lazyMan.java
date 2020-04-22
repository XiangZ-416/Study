package Type_01_SingletonMode.Type_02_Lazy;

/**
 * @Description: //TODO 单例模式：懒汉实现(线程不安全、线程安全)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/15 20:11
 */
public class lazyMan {
    public static void main(String[] args) {
        lazy instance1 = lazy.getInstance();
        lazy instance2 = lazy.getInstance();

        System.out.println(instance1 == instance2);
    }
}
/*
// 1.线程不安全
//   优点：实现了懒加载，避免了内存的浪费
//   缺点：只能在单线程中使用。比如线程1进入getInstance中的if还没来得及往下执行；
//         另一个线程通过了这个if，此时就可能出现两个对象。就不是单例模式了。
class lazy {
    // 1.私有空参构造方法
    private lazy() {

    }
    // 2.声明类的私有静态实例
    private static lazy instance;
    // 3.公共静态方法getInstance，返回类的一个实例。调用此方法时才创建此类的实例，所以称作懒汉模式
    public static lazy getInstance() {
        if (instance == null) {
            instance = new lazy();
        }
        return instance;
    }
}
*/

/*
// 2.线程安全（同步方法）
// 优点：解决了线程不安全的问题
// 缺点：效率太低了。每次调用getInstance方法都要判断锁，即getInstance方法内为单线程
class lazy {
    // 1.私有空参构造方法
    private lazy() {

    }
    // 2.声明类的私有静态实例
    private static lazy instance;
    // 3.公共静态方法getInstance，返回类的一个实例。调用此方法时才创建此类的实例，所以称作懒汉模式
    // 改为同步方法
    public static synchronized lazy getInstance() {
        if (instance == null) {
            instance = new lazy();
        }
        return instance;
    }
}
 */

// 3.线程安全（同步代码块 + 双重检查）
// 优点：解决了线程安全问题、效率问题
class lazy {
    // 1.私有空参构造方法
    private lazy() {

    }
    // 2.声明类的私有静态实例
    private static volatile lazy instance; // volatile：禁止指令重排序，即下面的代码按照程序次序执行
    // 3.公共静态方法getInstance，返回类的一个实例。调用此方法时才创建此类的实例，所以称作懒汉模式
    // 改为双重检查 + 同步代码块
    public static lazy getInstance() {
        if (instance == null) { // 第一次判断
            synchronized (lazy.class) { // 运行时类lazy的属性class作为同步锁
                if (instance == null) { // 第二次判断
                    instance = new lazy();
                }
            }
        }
        return instance;
    }
}

// Java.lang.Runtime类就用了单例模式的饿汉式