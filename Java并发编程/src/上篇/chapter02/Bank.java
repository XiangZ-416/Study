package ��ƪ.chapter02;

/**
 * @Description: //TODO ���д���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/14 18:49
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("һ�Ź�̨");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("���Ź�̨");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("���Ź�̨");
        ticketWindow3.start();
    }
}
