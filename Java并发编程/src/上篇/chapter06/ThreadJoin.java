package ��ƪ.chapter06;

/**
 * @Description: //TODO  ���� public final void join() throws InterruptedException
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/15 15:25
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        };
        t1.start();
        t1.join(); // ����֮�󣬵�ǰ�߳�main�ȴ�t1�߳�ִ�н�������ִ�С�������ֽ���ִ�е����

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
