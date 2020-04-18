package Type_03_decorativeMode;

/**
 * @Description: //TODO 创建Decorator：装饰者Cloth.java
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/17 16:14
 */
public abstract class Cloth extends Person {
    public abstract String getDescription();

    @Override
    public double cost() {
        // 什么都没买，不用钱
        return 0;
    }
}
