import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: //TODO Atomic��װ�� �����͵ı������Ա�֤�Ըñ����Ĳ�������ԭ�Ӳ���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/23 18:12
 */
public class Atomic {
    static AtomicInteger a = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                a.getAndAdd(1);
            }).start();
            new Thread(() -> {
                a.getAndAdd(1);
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(a);
    }
}
