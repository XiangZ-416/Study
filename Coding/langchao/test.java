/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/8/15 20:16
 */
public class test extends Thread {
    String name;

    public static void main(String[] args) {
        test t = new test();
        t.ececute();
    }
    test() {}
    test(String name) {
        this.name = name;
    }
    public String getThreadName() {
        return name;
    }
    public void ececute() {
        test first = new test("one");
        first.start();
        test second = new test("two");
        second.start();}
        public void start() {
            for (int i = 0; i < 2; i++) {
                System.out.println(this.getThreadName() + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

    }
}
