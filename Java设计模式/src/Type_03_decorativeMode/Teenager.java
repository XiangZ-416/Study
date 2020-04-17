package Type_03_decorativeMode;

/**
 * @Description: //TODO 创建ConcreteComponent子类：具体的被装饰者青少年Teenager.java
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/17 16:11
 */
public class Teenager extends Person {

    public Teenager() {
        description = "Shopping List: ";
    }

    @Override
    public double cost() {
        //什么都没买，不用钱
        return 0;
    }

}
