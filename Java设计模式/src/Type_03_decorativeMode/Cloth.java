package Type_03_decorativeMode;

/**
 * @Description: //TODO ����Decorator��װ����Cloth.java
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/17 16:14
 */
public abstract class Cloth extends Person {
    public abstract String getDescription();

    @Override
    public double cost() {
        // ʲô��û�򣬲���Ǯ
        return 0;
    }
}
