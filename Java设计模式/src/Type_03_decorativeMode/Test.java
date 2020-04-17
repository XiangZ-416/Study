package Type_03_decorativeMode;

/**
 * @Description: //TODO 先创建一个Teenager对象，接着用Shirt装饰它，就变成了穿着Shirt的Teenager，
 *                      再用Casquette装饰，就变成了戴着Casquette的穿着Shirt的Teenager。运行结果如下所示：
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/17 16:20
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Teenager(); // 造一个Teenager对象

        person = new Skirt(person); // 用Skirt修饰Teenager

        System.out.println(person.getDescription() + " ￥ " + person.cost());
    }
}
