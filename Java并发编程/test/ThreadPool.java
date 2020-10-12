import java.util.concurrent.*;

/**
 * @Description: //TODO �̳߳�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/24 22:21
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService e1 = Executors.newCachedThreadPool(); // �ɻ�����̳߳�
        ExecutorService e2 = Executors.newFixedThreadPool(10); // �������̳߳�
        ExecutorService e3 = Executors.newSingleThreadExecutor(); // ���߳��̳߳�
        ExecutorService e4 = Executors.newScheduledThreadPool(10); // ������ִ��������̳߳�
        for (int i = 0 ; i < 10; i++) {
            e3.execute(new MyThread(1));
        }
        // ʹ��ThreadPoolExecutor�Զ��崴���̳߳�
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 10,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    }
}

class MyThread implements Runnable {
    int i;

    public MyThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "----" + i);
    }
}
