package Type_01_SingletonMode.Type_01_Hungry;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£∫ 2020/7/29 19:19
 */
public class test {
    public static void main(String[] args) {
        User u1 = new User("πÿ”⁄");
        User u2 = new User("’≈∑…");
        u1.show();
        u1.show();
    }
}

class User {
    private static String name;

    User(String name) {
        User.name = name;
    }
    public void show() {
        System.out.println(name);
    }
}
