package ��ƪ.chapter02;

/**
 * @Description: //TODO ��Ʊ����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/14 18:48
 */
public class TicketWindow extends Thread {

    private final String name; // ��̨��

    private static final int MAX = 50; // ������

    private static int index = 1; // ��ʼ����

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("��̨��" + name + "��ǰ�ĺ����ǣ�" + (index++));
        }
    }
}
