package ��ƪ.chapter05;

/**
 * @Description: //TODO �����̵߳����ȼ���ִ�н�������õ����ȼ���һ�����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/15 15:00
 */
public class ThreadSimpleAPI2 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() +":" + i);
                }
            }
        };
        t1.setPriority(Thread.MIN_PRIORITY);


        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() +":" + i);
                }
            }
        };
        t2.setPriority(Thread.NORM_PRIORITY);

        Thread t3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+":" + i);
                }
            }
        };
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
