package ��ƪ.chapter02;

/**
 * @Description: //TODO Runnable�ӿڵ����ã�������ִ�е��߼���Ԫ���̵߳������ֿ������Ʋ���ģʽ��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/14 19:04
 */
public class TicketWindowRunnable implements Runnable{

    private static final int MAX = 50; // ������

    private static int index = 1; // ��ʼ����

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " �ĺ����ǣ�" + (index++));
        }
    }
}
