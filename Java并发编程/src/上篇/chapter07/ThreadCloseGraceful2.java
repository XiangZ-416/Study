package ��ƪ.chapter07;

/**
 * @Description: //TODO ͨ��interrupt�ر��߳�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/15 17:27
 */
public class ThreadCloseGraceful2 {
    private static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    break; // break�����ִ��while������߼���return���޷�ִ��while������߼���
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

        worker.interrupt(); // �ж�worker�̣߳�������Ӧ�߼���break��Ȼ��ر�worker�߳�
    }
}
