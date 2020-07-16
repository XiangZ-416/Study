package ��ƪ.chapter04;

/**
 * @Description: //TODO �����߳������ڼ���쳣
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/16 15:47
 */
public class ThreadException {

    private final static int A = 10;
    private final static int B = 0;

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50000L);
                    int res = A / B;
                    System.out.println(res);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setUncaughtExceptionHandler((thread, e) -> { // �÷����������߳����沶���쳣
            System.out.println(e);
            System.out.println(thread);
        });
        t.start();
    }
}
