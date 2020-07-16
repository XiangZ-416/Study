package 下篇.chapter03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/16 12:04
 */
public class BooleanLock implements Lock {

    private boolean initValue; // initValue为true代表锁已经被拿走
                                     // initValue为false代表锁可以抢

    private Thread currentThread;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>(); // 处于阻塞状态的线程列表

    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue) { // 锁被拿走了
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true; // 表示当前正在用锁
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills <= 0)
            lock();

        long hasRemaining = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (initValue) {
            if (hasRemaining <= 0)
                throw  new TimeOutException("Time out");
            blockedThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            hasRemaining = System.currentTimeMillis() - endTime;
        }
        this.initValue = true;
        this.currentThread = Thread.currentThread();

    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentThread) {
            this.initValue = false; // 释放锁
            System.out.println(Thread.currentThread() + "释放锁");
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedThreadCollection); // 不让别的线程修改blockedThreadCollection
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
