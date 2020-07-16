package 下篇.chapter02;

import java.util.stream.Stream;

/**
 * @Description: //TODO 多个生产者、多个消费之的情况下的实现
 *                           运行结果：生产一个，消费一个
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/16 10:39
 */
public class ProduceConsumerVersion3 {

    private int i = 0;

    final private Object LOCK = new Object();

    private volatile boolean isProduced = false; // 是否已经生产

    public void produce() {
        synchronized (LOCK) {
            while (isProduced) {
                try {
                    LOCK.wait(); // 停止生产
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++; // 生产
            System.out.println("P->" + i);
            LOCK.notifyAll(); // 通知消费者我已经生产了
            isProduced = true;
        }
    }

    public void consume() {
        synchronized (LOCK) {
            while (!isProduced) {
                try {
                    LOCK.wait(); // 停止消费
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C->" + i);
            LOCK.notifyAll(); // 通知生产者我已经消费了
            isProduced = false;
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion3 pc = new ProduceConsumerVersion3();
        Stream.of("P1", "P2", "P3").forEach(n ->
                new Thread(n) {
                    @Override
                    public void run() {
                        while (true) {
                            pc.produce();
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );
        Stream.of("C1", "C2", "C3", "C4").forEach(n ->
                new Thread(n) {
                    @Override
                    public void run() {
                        while (true) {
                            pc.consume();
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );
    }

}
