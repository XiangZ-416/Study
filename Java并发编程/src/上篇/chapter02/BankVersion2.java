package 上篇.chapter02;

/**
 * @Description: //TODO Runnable接口下的银行大厅
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/14 19:06
 */
public class BankVersion2 {
    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindow = new TicketWindowRunnable();
        Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
        Thread windowThread3 = new Thread(ticketWindow, "三号窗口");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}
