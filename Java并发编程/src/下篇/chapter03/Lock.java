package ��ƪ.chapter03;

import java.util.Collection;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/16 11:57
 */
public interface Lock {

    class TimeOutException extends Exception {

        public TimeOutException (String msg) {
            super(msg);
        }

    }

    void lock() throws InterruptedException; // ��ȡ��

    void lock(long mills) throws InterruptedException, TimeOutException; // ��ȡ����ʱ

    void unlock(); // �ͷ���

    Collection<Thread> getBlockedThread(); // ��ǰ��������״̬���߳��б�

    int getBlockedSize(); // ��ǰ��������״̬���߳�����

}
