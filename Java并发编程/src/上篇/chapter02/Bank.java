package 上篇.chapter02;

/**
 * @Description: //TODO 银行大厅
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/14 18:49
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("一号柜台");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("二号柜台");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("三号柜台");
        ticketWindow3.start();
    }
}
