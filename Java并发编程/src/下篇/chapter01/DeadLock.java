package 下篇.chapter01;

/**
 * @Description: //TODO 死锁例子：线程t1拥有不可抢占的资源o1还想要不可抢占的资源o2 && 线程t2拥有不可抢占的资源o2还想要不可抢占的资源o1
 *                           死锁产生的四个必要条件：1.互斥：非共享资资源
 *                                                    2.占有并等待：拥有了还想要
 *                                                    3.非抢占：资源必须是自愿释放
 *                                                    4.循环等待：线程之间形成环形的资源等待关系
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/15 21:00
 */
public class DeadLock implements Runnable {

    public int flag = 0;

    // 定义两个锁
    public static final Object o1 = new Object(); // 1.互斥
    public static final Object o2 = new Object();

    // 4.循环等待
    @Override
    public void run() { // 3.非抢占
        if (flag == 0) {
            System.out.println("flag = " + flag); // 当前的flag值
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) { // 2.占有并等待
                    System.out.println("0");
                }
            }
        }
        if (flag == 1) { // 3.非抢占
            synchronized (o2) {
                System.out.println("flag = " + flag); // 当前的flag值
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("1");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock t1 = new DeadLock();
        DeadLock t2 = new DeadLock();
        t1.flag = 0;
        t2.flag = 1;
        //t1，td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
        //td2的run()可能在td1的run()之前运行
        new Thread(t1).start(); // 线程1
        new Thread(t2).start(); // 线程2
    }
}
