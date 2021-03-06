package 下篇.chapter03;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Description: //TODO 测试自定义的显式锁
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/16 12:13
 */
public class LockTest {
    public static void main(String[] args) {
        final BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1", "T2", "T3", "T4")
                .forEach(name ->
                        new Thread(() -> {
                            try {
                                booleanLock.lock(100L);
                                Optional.of(Thread.currentThread().getName() + " have the lock Monitor")
                                        .ifPresent(System.out::println);
                                work();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (Lock.TimeOutException e) {
                                Optional.of(Thread.currentThread().getName() + " time out")
                                        .ifPresent(System.out::println);
                            } finally {
                                booleanLock.unlock();
                            }
                        }, name).start()
                );
    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " Working...").ifPresent(System.out::println);
        Thread.sleep(10000);
    }
}
