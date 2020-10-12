import java.util.concurrent.*;

/**
 * @Description: //TODO 线程池
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/24 22:21
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService e1 = Executors.newCachedThreadPool(); // 可缓存的线程池
        ExecutorService e2 = Executors.newFixedThreadPool(10); // 定常的线程池
        ExecutorService e3 = Executors.newSingleThreadExecutor(); // 单线程线程池
        ExecutorService e4 = Executors.newScheduledThreadPool(10); // 周期性执行任务的线程池
        for (int i = 0 ; i < 10; i++) {
            e3.execute(new MyThread(1));
        }
        // 使用ThreadPoolExecutor自定义创建线程池
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
