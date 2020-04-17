package Type_03_decorativeMode;

/**
 * @Description: //TODO 创建Component基类：因为总体对象是人，所以我们可以把人抽象为基类，新建Person.java:
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/17 16:08
 */
public abstract class Person {
    String description = "Unknown"; // 人被什么装饰了

    public String getDescription() {
        return description;
    }

    public abstract double cost(); // 这个装饰花了多少钱
}
