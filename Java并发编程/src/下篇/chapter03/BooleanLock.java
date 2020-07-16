package ��ƪ.chapter03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/16 12:04
 */
public class BooleanLock implements Lock {

    private boolean initValue; // initValueΪtrue�������Ѿ�������
                                     // initValueΪfalse������������

    private Thread currentThread;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>(); // ��������״̬���߳��б�

    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue) { // ����������
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true; // ��ʾ��ǰ��������
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
            this.initValue = false; // �ͷ���
            System.out.println(Thread.currentThread() + "�ͷ���");
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedThreadCollection); // ���ñ���߳��޸�blockedThreadCollection
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
