package Type_04_strategyMode;

/**
 * @Description: //TODO Strategy(抽象策略角色)：抽象折扣接口
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/18 13:06
 */
public interface MemberStrategy {
    /**
     * @Author ZX
     * @Description //TODO 计算图书打折后的价格
     * @Date 13:08 2020/4/18
     * @Param [booksPrice] 图书的原价
     * @return double
     **/
    public double calcPrice(double booksPrice);
}
