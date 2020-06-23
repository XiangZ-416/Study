package chapter04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 6-3
 */
public class ThreadState {

    private static Lock lock = new ReentrantLock();
// NOTICE: 线程状态总结
// 线程状态：NEW、RUNNING、TERMINATED ，这三个没啥说的，最主要的是另外三个状态：BLOCKED、WAITING、TIMED_WAITING。
// 1. BLOCKED：未获得锁时处于该状态：BLOCKED (on object monitor)
// 2. WAITING：调用 wait 方法后，处于该状态：WAITING (on object monitor), 未获得时条件锁也处于该状态：WAITING (parking).表示当前线程需要等待其他线程做出一些特定动作（通知或中断）。
// 3. TIMED_WAITING：调用 sleep 方法后，处于该状态：TIMED_WAITING (sleeping), 可以在指定的时间自行返回的。

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        // 使用两个Blocked线程，一个获取锁成功，另一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
        new Thread(new Sync(), "SyncThread-1").start();
        new Thread(new Sync(), "SyncThread-2").start();
    }

    /**
     * 该线程不断的进行睡眠
     */
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }
//    调用了 sleep 方法，处于 TIMED_WAITING 状态: TIMED_WAITING (sleeping)
//    "TimeWaitingThread" #13 prio=5 os_prio=31 tid=0x00007fd851813000 nid=0xa603 waiting on condition [0x000070000ddc9000]
//   java.lang.Thread.State: TIMED_WAITING (sleeping)
//        at java.lang.Thread.sleep(Native Method)
//        at java.lang.Thread.sleep(Thread.java:340)
//        at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
//        at chapter04.SleepUtils.second(SleepUtils.java:11)
//        at chapter04.ThreadState$TimeWaiting.run(ThreadState.java:30)
//        at java.lang.Thread.run(Thread.java:745)

    /**
     * 该线程在Waiting.class实例上等待
     */
    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
//  获取到了锁，并且调用了 wait 方法，处于 WAITING 状态：WAITING (on object monitor)
//  "WaitingThread" #14 prio=5 os_prio=31 tid=0x00007fd85283c800 nid=0xa403 in Object.wait() [0x000070000decc000]
//    java.lang.Thread.State: WAITING (on object monitor)
//    at java.lang.Object.wait(Native Method)
//            - waiting on <0x000000076afc4a38> (a java.lang.Class for chapter04.ThreadState$Waiting)
//    at java.lang.Object.wait(Object.java:502)
//    at chapter04.ThreadState$Waiting.run(ThreadState.java:44)
//            - locked <0x000000076afc4a38> (a java.lang.Class for chapter04.ThreadState$Waiting)
//    at java.lang.Thread.run(Thread.java:745)


    /**
     * 该线程在Blocked.class实例上加锁后，不会释放该锁
     */
    static class Blocked implements Runnable {
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }
//    "BlockedThread-2" 未获得锁，处于 阻塞 状态： BLOCKED (on object monitor)
//    "BlockedThread-2" #16 prio=5 os_prio=31 tid=0x00007fd85381a000 nid=0x5a03 waiting for monitor entry [0x000070000e0d2000]
//    java.lang.Thread.State: BLOCKED (on object monitor)
//    at chapter04.ThreadState$Blocked.run(ThreadState.java:60)
//            - waiting to lock <0x000000076afc8608> (a java.lang.Class for chapter04.ThreadState$Blocked)
//    at java.lang.Thread.run(Thread.java:745)

//    "BlockedThread-1" 获得了锁，调用了 sleep 方法，处于 TIMED_WAITING 状态：TIMED_WAITING (sleeping)
//    "BlockedThread-1" #15 prio=5 os_prio=31 tid=0x00007fd85502b800 nid=0xa203 waiting on condition [0x000070000dfcf000]
//    java.lang.Thread.State: TIMED_WAITING (sleeping)
//    at java.lang.Thread.sleep(Native Method)
//    at java.lang.Thread.sleep(Thread.java:340)
//    at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
//    at chapter04.SleepUtils.second(SleepUtils.java:11)
//    at chapter04.ThreadState$Blocked.run(ThreadState.java:60)
//            - locked <0x000000076afc8608> (a java.lang.Class for chapter04.ThreadState$Blocked)
//    at java.lang.Thread.run(Thread.java:745)
//


    static class Sync implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                SleepUtils.second(100);
            } finally {
                lock.unlock();
            }

        }

    }
//   "SyncThread-2" 未获得锁，但处于 WAITING 状态： WAITING (parking)
//    "SyncThread-2" #18 prio=5 os_prio=31 tid=0x00007fd85283d000 nid=0x5c03 waiting on condition [0x000070000e2d8000]
//    java.lang.Thread.State: WAITING (parking)
//    at sun.misc.Unsafe.park(Native Method)
//            - parking to wait for  <0x000000076afbd328> (a java.util.concurrent.locks.ReentrantLock$NonfairSync)
//    at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
//    at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
//    at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireQueued(AbstractQueuedSynchronizer.java:870)
//    at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquire(AbstractQueuedSynchronizer.java:1199)
//    at java.util.concurrent.locks.ReentrantLock$NonfairSync.lock(ReentrantLock.java:209)
//    at java.util.concurrent.locks.ReentrantLock.lock(ReentrantLock.java:285)
//    at chapter04.ThreadState$Sync.run(ThreadState.java:70)
//    at java.lang.Thread.run(Thread.java:745)
//
//    "SyncThread-1" 获得了锁，调用了 sleep 方法，处于 TIMED_WAITING 状态：TIMED_WAITING (sleeping)
//    "SyncThread-1" #17 prio=5 os_prio=31 tid=0x00007fd85502c000 nid=0xa103 waiting on condition [0x000070000e1d5000]
//    java.lang.Thread.State: TIMED_WAITING (sleeping)
//    at java.lang.Thread.sleep(Native Method)
//    at java.lang.Thread.sleep(Thread.java:340)
//    at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
//    at chapter04.SleepUtils.second(SleepUtils.java:11)
//    at chapter04.ThreadState$Sync.run(ThreadState.java:72)
//    at java.lang.Thread.run(Thread.java:745)
//
//    过段事件后，这两个线程就会跑完，不存在。

}