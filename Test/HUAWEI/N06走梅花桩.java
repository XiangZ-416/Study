import java.util.Scanner;

/**
 * @Description: //TODO ��Ŀ����
 *                              Redraiment����÷��׮�ĸ��֡�Redraiment������㲻�ޣ���ǰ�������ߵ�׮���ߣ����ߵĲ�����࣬��֪��Ϊʲô��
 *                              ������Redraiment�о�������ߵĲ�����
 *                          ��������
 *                              6
 *                              2 5 1 5 4 5
 *                          �������
 *                              3
 *                          ��ʾ
 *                              6����ĸ߶ȸ�Ϊ 2 5 1 5 4 5
 *                              ��ӵ�1��ʼ��,���Ϊ3��, 2 4 5
 *                              �ӵ�2��ʼ��,���ֻ��1��,5
 *                              ���ӵ�3��ʼ�������3��,1 4 5
 *                              �ӵ�5��ʼ�������2��,4 5
 *                              ������������3��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/2 17:36
 */
public class N06��÷��׮ {
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
