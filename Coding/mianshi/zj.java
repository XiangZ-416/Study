import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/26 15:41
 */
public class zj {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] sortData = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
            sortData[i] = nums[i];
        }
        /**
         * ˼·��1������һ���ź���ĸ������飬 p ԭ����ָ�룬q���ź��������ָ��
         * 2���Ӻ���ǰ�����Աȣ��տ�ʼp == q == n - 1; �жϵ�ǰ�Ƿ���ȡ�
         * 3�����˵�������ƶ�������һ����ǰ�ƶ���
         * 4������ȣ����ԭʼ�����ָ��p����ƶ���һֱ�ҵ���ȵ�ʱ������ָ��һ����ǰ�ƶ���
         * 5�����p�Ƶ���ͷ��˵��q֮ǰ�����ֶ�Ҫ�ƶ�������ֱ�ӷ����±�λ��+1���ɡ�
         */
        Arrays.sort(sortData);
        int p = n - 1;
        int q = n - 1;
        while(p >= 0 && q >= 0) {
            if(nums[p] == sortData[q]) {
                //�������һ����ǰ�ƶ�
                p--;
                q--;
            } else {
                //����ȣ�ԭʼ����ָ����ǰ�ƶ���ֱ���ƶ���ͷ�ͽ���
                while(p >= 0 && nums[p] != sortData[q]) {
                    p--;
                }
            }
        }
        System.out.println(q + 1);
    }
}

