package Type_03_decorativeMode;

/**
 * @Description: //TODO ����ConcreteComponent���ࣺ����ı�װ����������Teenager.java
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/17 16:11
 */
public class Teenager extends Person {

    public Teenager() {
        description = "Shopping List: ";
    }

    @Override
    public double cost() {
        //ʲô��û�򣬲���Ǯ
        return 0;
    }

}
