package ��ƪ.chapter06;

/**
 * @Description: //TODO ������ͬʱ�ɼ��������������ݣ�ÿ�������ɼ����ѵ�ʱ�䲻ͬ����Ҫ�ȴ����вɼ����ٷ��ء�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/15 16:02
 */
public class Case {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 5000L)); // �ɼ���һ̨�������ݻ���10s
        Thread t2 = new Thread(new CaptureRunnable("M2", 3000L)); // �ɼ��ڶ�̨�������ݻ���30s
        Thread t3 = new Thread(new CaptureRunnable("M3", 10000L)); // �ɼ�����̨�������ݻ���15s

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long endTime = System.currentTimeMillis();
        System.out.printf("save data startTime is " + startTime + "\n" + "save data endTime is " + endTime);
    }

}
class CaptureRunnable implements Runnable {

    private  String machineName;

    private long spendTime;

    public CaptureRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.println(machineName + " complete data capture and successful");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        return machineName + " finish.";
    }
}
