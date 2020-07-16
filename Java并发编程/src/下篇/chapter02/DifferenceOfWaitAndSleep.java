package 下篇.chapter02;

/**
 * @Description: //TODO wait()和sleep()的区别
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/16 11:23
 */
public class DifferenceOfWaitAndSleep {

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        //m1();
        m2();
    }

    public static void m1 () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m2 () {
        synchronized (LOCK) {
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
