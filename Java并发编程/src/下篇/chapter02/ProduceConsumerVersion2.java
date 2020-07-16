package 下篇.chapter02;

/**
 * @Description: //TODO 生产者消费者Version2：生产结束通知消费者，如果消费者没有消费，那就不生产
 *                                                                        如果有数，那就消费，否则等待
 *                                                    结果：生产一个消费一个...
 *                                                    存在的问题：多个生产者、多个消费之的情况下会出现问题
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/16 9:49
 */
public class ProduceConsumerVersion2 {

    private int i = 0;

    final private Object LOCK = new Object();

    private volatile boolean isProduced = false; // 是否已经生产

    public void produce() {
        synchronized (LOCK) {
            if (isProduced) { // 如果已经生产了
                try {
                    LOCK.wait(); // 停止生产
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else { // 没有生产
                i++; // 生产
                System.out.println("P->" + i);
                LOCK.notify(); // 通知消费者我已经生产了
                isProduced = true;
            }
        }
    }

    public void consume() {
        synchronized (LOCK) {
            if (isProduced) { // 已经生产了
                System.out.println("C->" + i);
                LOCK.notify(); // 通知生产者我已经消费了
                isProduced = false;
            } else { // 没有生产
                try {
                    LOCK.wait(); // 停止消费
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion2 pc = new ProduceConsumerVersion2();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    pc.produce();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    pc.consume();
                }
            }
        }.start();
    }
}
