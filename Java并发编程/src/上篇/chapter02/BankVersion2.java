package ��ƪ.chapter02;

/**
 * @Description: //TODO Runnable�ӿ��µ����д���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/14 19:06
 */
public class BankVersion2 {
    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindow = new TicketWindowRunnable();
        Thread windowThread1 = new Thread(ticketWindow, "һ�Ŵ���");
        Thread windowThread2 = new Thread(ticketWindow, "���Ŵ���");
        Thread windowThread3 = new Thread(ticketWindow, "���Ŵ���");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
