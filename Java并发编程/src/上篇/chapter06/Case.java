package 上篇.chapter06;

/**
 * @Description: //TODO 案例：同时采集三个机器的数据，每个机器采集花费的时间不同，需要等待所有采集完再返回。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/15 16:02
 */
public class Case {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 5000L)); // 采集第一台机器数据花费10s
        Thread t2 = new Thread(new CaptureRunnable("M2", 3000L)); // 采集第二台机器数据花费30s
        Thread t3 = new Thread(new CaptureRunnable("M3", 10000L)); // 采集第三台机器数据花费15s

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
