package 上篇.chapter06;

/**
 * @Description: //TODO 测试 public final synchronized void join(long millis)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/15 15:33
 */
public class ThreadJoin3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("t1 is running");
                    Thread.sleep(1000); // 休眠1s
                    System.out.println("t1 is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //t1.setDaemon(true);
        t1.start();
        t1.join(100); // 当前线程main等待t1线程100ms，如果超过100ms t1线程还没有结束，就开始执行main线程。
                                  // 如果t1不是守护线程，那么main线程执行完后，继续执行t1线程

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
