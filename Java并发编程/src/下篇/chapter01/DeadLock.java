package ��ƪ.chapter01;

/**
 * @Description: //TODO �������ӣ��߳�t1ӵ�в�����ռ����Դo1����Ҫ������ռ����Դo2 && �߳�t2ӵ�в�����ռ����Դo2����Ҫ������ռ����Դo1
 *                           �����������ĸ���Ҫ������1.���⣺�ǹ�������Դ
 *                                                    2.ռ�в��ȴ���ӵ���˻���Ҫ
 *                                                    3.����ռ����Դ��������Ը�ͷ�
 *                                                    4.ѭ���ȴ����߳�֮���γɻ��ε���Դ�ȴ���ϵ
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/15 21:00
 */
public class DeadLock implements Runnable {

    public int flag = 0;

    // ����������
    public static final Object o1 = new Object(); // 1.����
    public static final Object o2 = new Object();

    // 4.ѭ���ȴ�
    @Override
    public void run() { // 3.����ռ
        if (flag == 0) {
            System.out.println("flag = " + flag); // ��ǰ��flagֵ
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) { // 2.ռ�в��ȴ�
                    System.out.println("0");
                }
            }
        }
        if (flag == 1) { // 3.����ռ
            synchronized (o2) {
                System.out.println("flag = " + flag); // ��ǰ��flagֵ
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("1");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock t1 = new DeadLock();
        DeadLock t2 = new DeadLock();
        t1.flag = 0;
        t2.flag = 1;
        //t1��td2�����ڿ�ִ��״̬����JVM�̵߳�����ִ���ĸ��߳��ǲ�ȷ���ġ�
        //td2��run()������td1��run()֮ǰ����
        new Thread(t1).start(); // �߳�1
        new Thread(t2).start(); // �߳�2
    }
}
