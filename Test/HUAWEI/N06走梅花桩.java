import java.util.Scanner;

/**
 * @Description: //TODO 题目描述
 *                              Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，不知道为什么？
 *                              你能替Redraiment研究他最多走的步数吗？
 *                          样例输入
 *                              6
 *                              2 5 1 5 4 5
 *                          样例输出
 *                              3
 *                          提示
 *                              6个点的高度各为 2 5 1 5 4 5
 *                              如从第1格开始走,最多为3步, 2 4 5
 *                              从第2格开始走,最多只有1步,5
 *                              而从第3格开始走最多有3步,1 4 5
 *                              从第5格开始走最多有2步,4 5
 *                              所以这个结果是3。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/2 17:36
 */
public class N06走梅花桩 {
    public static int GetResult(int m,int[] num){
        int[] dp = new int[m];
        int max=1;
        for(int i=0;i<m;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(num[j]<num[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int m = scan.nextInt();
            int[] num = new int[m];
            for(int i=0;i<m;i++){
                num[i]= scan.nextInt();
            }

            System.out.println(GetResult(m, num));
        }
    }
}
