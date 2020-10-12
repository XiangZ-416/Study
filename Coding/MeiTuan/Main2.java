import java.util.Scanner;

/**
 * @Description: //TODO 小美的外卖节省钱计划
 *                          时间限制： 3000MS
 *                          内存限制： 589824KB
 *                          题目描述：
 *                              2020年的618不再仅仅是购物节啦，同时也是美团外卖节，小美早早就准备好了各种满减代金券，为了最大程度的“省钱”，当然是选择把这些代金券都用光啦！
 *                              这些代金券都有一个使用门槛，即满多少元的订单才可以使用。如果使用一个二元组<x,y>表示一张代金券，即需要满x元才能优惠y元，那么需要注意的是，并
 *                              不是所有代金券的x都是大于等于y的，良心美团也会推出一些x<y的代金券。如果x<y,例如x=1，y=2，则购买1元商品的情况下无需付款，不会退款给用户。
 *                              请问小美如果想用完这些代金券，在保证总付款金额最小的情况下，她最多购买多少钱的外卖呢？
 *                          说明：
 *                              1.一个订单只能用一张代金券。
 *                              2.同时满足总付款金额最少，且购买的外卖价值最高，例如两个优惠完都是1元的外卖，一个原价3元另一个原价4元，则选四元的。
 *                              3.由于美团商户很多，所以对于任何一个价格我们都可以找到至少一种商品购买。
 *                          输入描述
 *                              输入第一行仅包含一个正整数n，表示小美拥有的代金券数量。(1<=n<=50000)
 *                              接下来有n行，每行有两个整数x和y，表示一张代金券需要订单金额满x元可以使用，能够优惠y元。(1<=x<=10000,1<=y<=10000)
 *                          输出描述
 *                              输出仅包含两个正整数，中间用空格隔开,分别表示小美购买的外卖价值和她的实际付款金额。
 *                          样例输入
 *                              3
 *                              5 3
 *                              10 5
 *                              1 2
 *                          样例输出
 *                              17 7
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/8 16:24
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        int[] youHui = new int[n];
        int res = 0;//总价值
        int sum = 0;//付款
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
            youHui[i] = sc.nextInt();
            if(prices[i]>=youHui[i]){
                sum += prices[i]-youHui[i];
                res +=prices[i];
            }else{
                res +=youHui[i];
            }
        }
        System.out.println(res+","+ sum);
    }
}
