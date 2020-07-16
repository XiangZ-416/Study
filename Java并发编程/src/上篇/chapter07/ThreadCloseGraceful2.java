package 上篇.chapter07;

/**
 * @Description: //TODO 通过interrupt关闭线程
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/15 17:27
 */
public class ThreadCloseGraceful2 {
    private static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    break; // break后可以执行while后面的逻辑。return（无法执行while后面的逻辑）
                }
            }
            //----------------
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.interrupt(); // 中断worker线程，进入相应逻辑后break，然后关闭worker线程
    }
}
