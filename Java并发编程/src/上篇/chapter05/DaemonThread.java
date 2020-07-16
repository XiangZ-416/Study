package 上篇.chapter05;

/**
 * @Description: //TODO 守护线程
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/15 10:56
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " running");
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName() + " done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }; // new状态
        t.setDaemon(true); // 设置t为守护线程（main线程生命周期结束，守护线程的声明周期也就结束）
        t.start(); // runnable状态 --> running | dead | blocked
        try {
            Thread.sleep(5000); // main线程休眠5s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
