package Type_03_decorativeMode;

/**
 * @Description: //TODO 创建ConcreteDecorator：具体的装饰者
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/17 16:17
 */
public class Skirt extends Cloth {
    // 用实例变量保存Person的引用
    Person person;

    public Skirt(Person person) {
        this.person = person;
    }

    @Override
    public String getDescription() {
        return person.getDescription() + "a shirt  ";
    }

    @Override
    public double cost() {
        return 100 + person.cost(); //实现了cost()方法，并调用了person的cost()方法，目的是获得所有累加值
    }
}
