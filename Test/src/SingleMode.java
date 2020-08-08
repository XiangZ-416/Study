/**
 * @Description: //TODO 单例模式的两种实现
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/17 9:32
 */
public class SingleMode {

    // 饿汉
    public static class Hungry {
        private static Hungry instance = new Hungry();

        private Hungry() {

        }

        public static Hungry getInstance() {
            return instance;
        }
    }

    // 懒汉
    public static class Lazy {
        private static Lazy instance = null;

        private Lazy() {

        }

        public synchronized static Lazy getInstance() { // 一定是同步方法/同步代码块，否则多线程调用可能会创建多个instance
            if (instance == null) {
                instance = new Lazy();
            }
            return instance;
        }
    }

}
