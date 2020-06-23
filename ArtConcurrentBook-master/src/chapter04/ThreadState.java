package chapter04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 6-3
 */
public class ThreadState {

    private static Lock lock = new ReentrantLock();
// NOTICE: �߳�״̬�ܽ�
// �߳�״̬��NEW��RUNNING��TERMINATED ��������ûɶ˵�ģ�����Ҫ������������״̬��BLOCKED��WAITING��TIMED_WAITING��
// 1. BLOCKED��δ�����ʱ���ڸ�״̬��BLOCKED (on object monitor)
// 2. WAITING������ wait �����󣬴��ڸ�״̬��WAITING (on object monitor), δ���ʱ������Ҳ���ڸ�״̬��WAITING (parking).��ʾ��ǰ�߳���Ҫ�ȴ������߳�����һЩ�ض�������֪ͨ���жϣ���
// 3. TIMED_WAITING������ sleep �����󣬴��ڸ�״̬��TIMED_WAITING (sleeping), ������ָ����ʱ�����з��صġ�

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        // ʹ������Blocked�̣߳�һ����ȡ���ɹ�����һ��������
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
        new Thread(new Sync(), "SyncThread-1").start();
        new Thread(new Sync(), "SyncThread-2").start();
    }

    /**
     * ���̲߳��ϵĽ���˯��
     */
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }
//    ������ sleep ���������� TIMED_WAITING ״̬: TIMED_WAITING (sleeping)
//    "TimeWaitingThread" #13 prio=5 os_prio=31 tid=0x00007fd851813000 nid=0xa603 waiting on condition [0x000070000ddc9000]
//   java.lang.Thread.State: TIMED_WAITING (sleeping)
//        at java.lang.Thread.sleep(Native Method)
//        at java.lang.Thread.sleep(Thread.java:340)
//        at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
//        at chapter04.SleepUtils.second(SleepUtils.java:11)
//        at chapter04.ThreadState$TimeWaiting.run(ThreadState.java:30)
//        at java.lang.Thread.run(Thread.java:745)

    /**
     * ���߳���Waiting.classʵ���ϵȴ�
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
//  ��ȡ�����������ҵ����� wait ���������� WAITING ״̬��WAITING (on object monitor)
//  "WaitingThread" #14 prio=5 os_prio=31 tid=0x00007fd85283c800 nid=0xa403 in Object.wait() [0x000070000decc000]
//    java.lang.Thread.State: WAITING (on object monitor)
//    at java.lang.Object.wait(Native Method)
//            - waiting on <0x000000076afc4a38> (a java.lang.Class for chapter04.ThreadState$Waiting)
//    at java.lang.Object.wait(Object.java:502)
//    at chapter04.ThreadState$Waiting.run(ThreadState.java:44)
//            - locked <0x000000076afc4a38> (a java.lang.Class for chapter04.ThreadState$Waiting)
//    at java.lang.Thread.run(Thread.java:745)


    /**
     * ���߳���Blocked.classʵ���ϼ����󣬲����ͷŸ���
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
//    "BlockedThread-2" δ����������� ���� ״̬�� BLOCKED (on object monitor)
//    "BlockedThread-2" #16 prio=5 os_prio=31 tid=0x00007fd85381a000 nid=0x5a03 waiting for monitor entry [0x000070000e0d2000]
//    java.lang.Thread.State: BLOCKED (on object monitor)
//    at chapter04.ThreadState$Blocked.run(ThreadState.java:60)
//            - waiting to lock <0x000000076afc8608> (a java.lang.Class for chapter04.ThreadState$Blocked)
//    at java.lang.Thread.run(Thread.java:745)

//    "BlockedThread-1" ��������������� sleep ���������� TIMED_WAITING ״̬��TIMED_WAITING (sleeping)
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
//   "SyncThread-2" δ������������� WAITING ״̬�� WAITING (parking)
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
//    "SyncThread-1" ��������������� sleep ���������� TIMED_WAITING ״̬��TIMED_WAITING (sleeping)
//    "SyncThread-1" #17 prio=5 os_prio=31 tid=0x00007fd85502c000 nid=0xa103 waiting on condition [0x000070000e1d5000]
//    java.lang.Thread.State: TIMED_WAITING (sleeping)
//    at java.lang.Thread.sleep(Native Method)
//    at java.lang.Thread.sleep(Thread.java:340)
//    at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
//    at chapter04.SleepUtils.second(SleepUtils.java:11)
//    at chapter04.ThreadState$Sync.run(ThreadState.java:72)
//    at java.lang.Thread.run(Thread.java:745)
//
//    �����¼����������߳̾ͻ����꣬�����ڡ�

}