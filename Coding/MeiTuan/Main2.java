import java.util.Scanner;

/**
 * @Description: //TODO С����������ʡǮ�ƻ�
 *                          ʱ�����ƣ� 3000MS
 *                          �ڴ����ƣ� 589824KB
 *                          ��Ŀ������
 *                              2020���618���ٽ����ǹ��������ͬʱҲ�����������ڣ�С�������׼�����˸�����������ȯ��Ϊ�����̶ȵġ�ʡǮ������Ȼ��ѡ�����Щ����ȯ���ù�����
 *                              ��Щ����ȯ����һ��ʹ���ż�����������Ԫ�Ķ����ſ���ʹ�á����ʹ��һ����Ԫ��<x,y>��ʾһ�Ŵ���ȯ������Ҫ��xԪ�����Ż�yԪ����ô��Ҫע����ǣ���
 *                              �������д���ȯ��x���Ǵ��ڵ���y�ģ���������Ҳ���Ƴ�һЩx<y�Ĵ���ȯ�����x<y,����x=1��y=2������1Ԫ��Ʒ����������踶������˿���û���
 *                              ����С�������������Щ����ȯ���ڱ�֤�ܸ�������С������£�����๺�����Ǯ�������أ�
 *                          ˵����
 *                              1.һ������ֻ����һ�Ŵ���ȯ��
 *                              2.ͬʱ�����ܸ��������٣��ҹ����������ֵ��ߣ����������Ż��궼��1Ԫ��������һ��ԭ��3Ԫ��һ��ԭ��4Ԫ����ѡ��Ԫ�ġ�
 *                              3.���������̻��ܶ࣬���Զ����κ�һ���۸����Ƕ������ҵ�����һ����Ʒ����
 *                          ��������
 *                              �����һ�н�����һ��������n����ʾС��ӵ�еĴ���ȯ������(1<=n<=50000)
 *                              ��������n�У�ÿ������������x��y����ʾһ�Ŵ���ȯ��Ҫ���������xԪ����ʹ�ã��ܹ��Ż�yԪ��(1<=x<=10000,1<=y<=10000)
 *                          �������
 *                              ����������������������м��ÿո����,�ֱ��ʾС�������������ֵ������ʵ�ʸ����
 *                          ��������
 *                              3
 *                              5 3
 *                              10 5
 *                              1 2
 *                          �������
 *                              17 7
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/8 16:24
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        int[] youHui = new int[n];
        int res = 0;//�ܼ�ֵ
        int sum = 0;//����
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