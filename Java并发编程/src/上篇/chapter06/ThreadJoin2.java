package ��ƪ.chapter06;

/**
 * @Description: //TODO t1��t2��Ȼ�ǲ�����ϵ������ֽ������С���t1��t2ִ�н�����main�̲߳Ż�ִ��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/15 15:15
 */
public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
