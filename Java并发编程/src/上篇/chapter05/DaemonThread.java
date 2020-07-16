package ��ƪ.chapter05;

/**
 * @Description: //TODO �ػ��߳�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/15 10:56
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
        }; // new״̬
        t.setDaemon(true); // ����tΪ�ػ��̣߳�main�߳��������ڽ������ػ��̵߳���������Ҳ�ͽ�����
        t.start(); // runnable״̬ --> running | dead | blocked
        try {
            Thread.sleep(5000); // main�߳�����5s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
