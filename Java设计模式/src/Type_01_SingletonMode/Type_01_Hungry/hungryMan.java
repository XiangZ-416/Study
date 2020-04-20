package Type_01_SingletonMode.Type_01_Hungry;

/**
 * @Description: //TODO 单例模式：饿汉实现（静态变量 或 静态代码块实现）
 * 优点：写法简单、在类加载的时候就完成实例化，避免了线程同步的问题
 * 缺点：如果从始至终没有用过类加载时创建的实例，就造成了内存的浪费
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/15 18:02
 */
public class hungryMan {
    public static void main(String[] args) {
        Hungry instance1 = Hungry.getInstance();
        Hungry instance2 = Hungry.getInstance();

        System.out.println(instance1 == instance2);
    }
}
// 静态变量实现
class Hungry {
    // 1.私有空参构造器，防止new
    private Hungry() {

    }
    // 2.实例化此类的一个私有静态实例。类的加载过程就实例化此类对象，故称饿汉模式。
    private static Hungry instance = new Hungry();
    // 3.提供公有方法getInstance
    public static Hungry getInstance() {
        return instance;
    }
}

// 静态代码块实现
/*
class Hungry {
    // 1.私有空参构造器，防止new
    private Hungry() {

    }
    // 2.声明类的私有静态实例
    private static Hungry instance;
    // 3.在静态代码块中闯将类的实例。类的加载过程就实例化此类对象，故称饿汉模式。
    static {
        instance = new Hungry();
    }
    // 4.提供公有的静态getInstance方法，返回一个本类的实例
    public static Hungry getInstance() {
        return instance;
    }
}
 */
