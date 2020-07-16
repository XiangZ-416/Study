package 下篇.chapter05;

/**
 * @Description: //TODO 两种方式创建ThreadGroup
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/16 16:23
 */
public class ThreadGroupCreate {
    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("TG1"); // 根据线程组名称创建线程组，其父线程组为main线程组
        ThreadGroup tg2 = new ThreadGroup(tg1, "TG2"); // 根据线程组名称创建线程组，其父线程组为指定的parent线程组

        System.out.println("tg1 name: " + tg1.getName() + "\n" + "tg1 parent: " + tg1.getParent().getName());
        System.out.println("tg2 name: " + tg2.getName() + "\n" + "tg2 parent: " + tg2.getParent().getName());
    }
}
