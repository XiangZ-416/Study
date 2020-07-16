package 上篇.chapter02;

/**
 * @Description: //TODO 售票窗口
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/14 18:48
 */
public class TicketWindow extends Thread {

    private final String name; // 柜台名

    private static final int MAX = 50; // 最大号码

    private static int index = 1; // 初始号码

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + "当前的号码是：" + (index++));
        }
    }
}
