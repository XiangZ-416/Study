package ��ƪ.chapter02;

/**
 * @Description: //TODO ������������Version1�������߳�û��ͨ�ţ�������һֱ������������һֱ����ͬһ����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/16 9:39
 */
public class ProduceConsumerVersion1 {

    private  int i = 1;
    final private Object LOCK = new Object();

    private void produce () {
        synchronized (LOCK) {
            System.out.println("P->" + (i++));
        }
    }

    private void consume () {
        synchronized (LOCK) {
            System.out.println("C->" + i);
        }
    }

    public static void main(String[] args) {

        ProduceConsumerVersion1 pc = new ProduceConsumerVersion1();

        new Thread("P") {
            @Override
            public void run() {
                while (true) {
                    pc.produce();
                }
            }
        }.start();

        new Thread("C") {
            @Override
            public void run() {
                while (true) {
                    pc.consume();
                }
            }
        }.start();
    }
}
