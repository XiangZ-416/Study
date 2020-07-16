package ��ƪ.chapter07;

/**
 * @Description: //TODO ͨ������flag�ر��߳�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/15 17:18
 */
public class ThreadCloseGraceful {

    private static class Worker extends Thread {

        private volatile boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                // ִ���߼�
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

        worker.shutdown(); // �ر�worker�߳�

    }

}
