package 上篇.chapter02;

/**
 * @Description: //TODO Runnable接口的作用：将程序执行的逻辑单元和线程的启动分开（类似策略模式）
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/14 19:04
 */
public class TicketWindowRunnable implements Runnable{

    private static final int MAX = 50; // 最大号码

    private static int index = 1; // 初始号码

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
        }
    }
}
