/**
 * @Description: //TODO Thread在不同线程之间是隔离的
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/25 15:15
 */
public class threadLocal {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(threadLocal.get());
            threadLocal.set(0);
            System.out.println(threadLocal.get());
        }).start();
        new Thread(() -> {
            System.out.println(threadLocal.get());
            threadLocal.set(1);
            System.out.println(threadLocal.get());
        }).start();
    }

}
