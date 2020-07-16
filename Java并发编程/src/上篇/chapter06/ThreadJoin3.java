package ��ƪ.chapter06;

/**
 * @Description: //TODO ���� public final synchronized void join(long millis)
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/15 15:33
 */
public class ThreadJoin3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("t1 is running");
                    Thread.sleep(1000); // ����1s
                    System.out.println("t1 is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //t1.setDaemon(true);
        t1.start();
        t1.join(100); // ��ǰ�߳�main�ȴ�t1�߳�100ms���������100ms t1�̻߳�û�н������Ϳ�ʼִ��main�̡߳�
                                  // ���t1�����ػ��̣߳���ômain�߳�ִ����󣬼���ִ��t1�߳�

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
