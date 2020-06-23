package chapter01;/** * 死锁例子 *  * @author tengfei.fangtf * @version $Id: DeadLockDemo.java, v 0.1 2015-7-18 下午10:08:28 tengfei.fangtf Exp $ */public class DeadLockDemo {    /** A锁 */    private static String A = "A";    /** B锁 */    private static String B = "B";    public static void main(String[] args) {        new DeadLockDemo().deadLock();    }    // NOTICE: dump 查看线程状态的方法    // 1. jps [-l] 查看本机所有java进程pid    // 2. jstack [-l] pid > xxx.log 将所有线程信息输入到指定文件中    // 3. grep java.lang.Thread.State DeadLockDemo_Dump | awk '{print $2$3$4$5}'| sort | uniq -c   统计所有线程处于什么状态        private void deadLock() {        Thread t1 = new Thread(new Runnable() {            @Override            public void run() {                synchronized (A) {                    try {                        Thread.sleep(2000);                    } catch (InterruptedException e) {                        e.printStackTrace();                    }                    synchronized (B) {                        System.out.println("1");                    }                }            }        });        Thread t2 = new Thread(new Runnable() {            @Override            public void run() {                synchronized (B) {                    synchronized (A) {                        System.out.println("2");                    }                }            }        });        t1.start();        t2.start();    }}