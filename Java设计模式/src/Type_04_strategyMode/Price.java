package Type_04_strategyMode;

/**
 * @Description: //TODO Context(环境角色)：价格类
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/18 13:15
 */
public class Price {

    // 利用组合方式持有一个具体的策略对象
    MemberStrategy strategy;

    /**
     * 构造函数，传入一个具体的策略对象
     * @param strategy    具体的策略对象
     */
    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double quote(double booksPrice){
        return this.strategy.calcPrice(booksPrice);
    }
}
