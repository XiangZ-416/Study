package ��ƪ.chapter02;

/**
 * @Description: //TODO ������������Version2����������֪ͨ�����ߣ����������û�����ѣ��ǾͲ�����
 *                                                                        ����������Ǿ����ѣ�����ȴ�
 *                                                    ���������һ������һ��...
 *                                                    ���ڵ����⣺��������ߡ��������֮������»��������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/16 9:49
 */
public class ProduceConsumerVersion2 {

    private int i = 0;

    final private Object LOCK = new Object();

    private volatile boolean isProduced = false; // �Ƿ��Ѿ�����

    public void produce() {
        synchronized (LOCK) {
            if (isProduced) { // ����Ѿ�������
                try {
                    LOCK.wait(); // ֹͣ����
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else { // û������
                i++; // ����
                System.out.println("P->" + i);
                LOCK.notify(); // ֪ͨ���������Ѿ�������
                isProduced = true;
            }
        }
    }

    public void consume() {
        synchronized (LOCK) {
            if (isProduced) { // �Ѿ�������
                System.out.println("C->" + i);
                LOCK.notify(); // ֪ͨ���������Ѿ�������
                isProduced = false;
            } else { // û������
                try {
                    LOCK.wait(); // ֹͣ����
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
