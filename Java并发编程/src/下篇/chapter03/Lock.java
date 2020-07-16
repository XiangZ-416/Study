package 下篇.chapter03;

import java.util.Collection;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/16 11:57
 */
public interface Lock {

    class TimeOutException extends Exception {

        public TimeOutException (String msg) {
            super(msg);
        }

    }

    void lock() throws InterruptedException; // 获取锁

    void lock(long mills) throws InterruptedException, TimeOutException; // 获取锁超时

    void unlock(); // 释放锁

    Collection<Thread> getBlockedThread(); // 当前处于阻塞状态的线程列表

    int getBlockedSize(); // 当前处于阻塞状态的线程数量

}
