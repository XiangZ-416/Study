package Num_01_SpringBeans;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/18 17:10
 */
public class HelloWorld {

    private String name;

    public HelloWorld() {
        System.out.println("HelloWorld's Constructor...");
    }

    public void setName(String name) {
        System.out.println("setName£º" + name);
        this.name = name;
    }

    public void hello() {
        System.out.println("Hello£º" + name);
    }

}
