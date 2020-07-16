package 上篇.chapter07;

/**
 * @Description: //TODO void interrupt() ：中断线程
 *                          boolean interrupted() ：测试当前线程是否已经中断
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/15 16:22
 */
public class ThreadInterrupt {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println(isInterrupted());
                        }
                    }
                }
            }
        };

        t.start();
        Thread.sleep(100);
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
