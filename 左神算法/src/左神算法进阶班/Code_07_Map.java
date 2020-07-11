package �����㷨���װ�;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: //TODO map��ص���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/1 10:37
 */
public class Code_07_Map {

    /**
     * @Description //TODO ��������0���������и��������������ۼӺ�Ϊaim���������ĳ��ȡ�
     * @Author ZX
     * @Date 10:38 2020/7/1
     **/
    public static class maxSubArray1 {
        public static int maxLength(int[] arr, int aim) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1); // important
            int len = 0;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (map.containsKey(sum - aim)) {
                    len = Math.max(i - map.get(sum - aim), len);
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
            return len;
        }
    }

    /**
     * @Description //TODO �����ж�����������������������ż����ȵ��������ĳ���
     *                      ���������˼·������������Ϊ1��ż����Ϊ-1�������ۼӺ�Ϊ0���������ĳ��ȡ�
     * @Author ZX
     * @Date 11:04 2020/7/1
     **/
    public static class maxSubArray2 {

    }
    
    /**
     * @Description //TODO ������ֻҪ0��1��2����������1����������2���������������ĳ���
     *                      ���������˼·������2��Ϊ-1�������ۼӺ�Ϊ0���������ĳ��ȡ�
     * @Author ZX
     * @Date 11:08 2020/7/1
     **/
    public static class maxSubArray3 {

    }


    /**
     * @Description //TODO �з����飬ʹ���зֵ�����������ڲ�����Ϊ0��ࡣ�������������ĸ�����
     * @Author ZX
     * @Date 11:39 2020/7/1
     **/
    public static class mostEOR {
        public static int mostEor(int[] arr) {
            int ans = 0;
            int xor = 0; // ����
            int[] dp = new int[arr.length];
            Map<Integer, Integer> map = new HashMap<>(); // key��ʾ�������value��ʾ���������������±�
            map.put(0, -1); // �������Ϊ0��λ��Ϊ-1
            for (int i = 0; i < arr.length; i++) {
                xor ^= arr[i];
                if (map.containsKey(xor)) {
                    int pre = map.get(xor);
                    dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
                }
                if (i > 0) {
                    dp[i] = Math.max(dp[i - 1], dp[i]);
                }
                map.put(xor, i);
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }

}
