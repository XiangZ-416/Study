package 上篇.chapter06;

/**
 * @Description: //TODO  测试 public final void join() throws InterruptedException
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/15 15:25
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        };
        t1.start();
        t1.join(); // 加上之后，当前线程main等待t1线程执行结束后再执行。不会出现交替执行的情况

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
