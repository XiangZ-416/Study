package 上篇.chapter07;

/**
 * @Description: //TODO 通过定义flag关闭线程
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/15 17:18
 */
public class ThreadCloseGraceful {

    private static class Worker extends Thread {

        private volatile boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                // 执行逻辑
            }
        }

        public void shutdown() {
            this.flag = false;
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

        worker.shutdown(); // 关闭worker线程

    }

}
