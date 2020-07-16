package 上篇.chapter05;

/**
 * @Description: //TODO 输出线程的名称、id、优先级
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/15 14:48
 */
public class ThreadSimpleAPI {
    public static void main(String[] args) {
        Thread t = new Thread("t1") {
            @Override
            public void run() {
                System.out.println("Hello");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getPriority());
    }
}
