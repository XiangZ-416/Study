package �����㷨���װ�;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: //TODO ���鶼�����������ۼӺ�Ϊaim��������鳤��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/4 19:32
 */
public class Code_13_SumSubArray {

    // ���鶼�����������ۼӺ�Ϊaim��������鳤��
    public static class sumSubArr1 {
        // ������O(N^3)
        public static int maxSumArray1(int[] arr, int aim) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int S = 0;
            int E = 0;
            int max = E - S;
            for (int start = 0; start < arr.length; start++) {
                for (int end = 0; end < arr.length; end++) {
                    int sum = 0;
                    for (int i = start; i < end; i++) {
                        sum += arr[i];
                        if (sum == aim) {
                            S = start;
                            E = end;
                            max = Math.max(max, E - S);
                        }
                    }
                }
            }
            return max;
        }

        // ˫ָ�뷨
        public static int maxSumArray2(int[] arr, int aim) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int L = 0; // ��ָ��
            int R = 0; // ��ָ��
            int len = 0;
            int sum = arr[0]; // 0λ�ÿ�ʼʱsumΪarr[0]
            for (int i = 0; i < arr.length; i++) {
                if (sum == aim) {
                    len = Math.max(len, R - L + 1);
                    sum += arr[++R];
                } else if (sum < aim) {
                    if (R == arr.length)
                        break;
                    sum += arr[++R];
                } else {
                    sum -= arr[L++];
                }
            }
            return len;
        }
    }

    // ������Ԫ�ؿ����ɸ���Ϊ�㣬���Ϊaim��������
    public static class sumSubArr2 {
        // map���ۼӺͼ��ۼӺͳ��ֵĴ���
        public int subarraySum(int[] nums, int aim) {
            if (nums == null) {
                return 0;
            }
            Map<Integer, Integer> map = new HashMap<>(); // map��¼�ۼӺͳ��ֵĴ���
            map.put(0, 1); // ��Ϊ0��������������һ������[]
            int sum = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i]; // ����iλ��ʱ���ۼӺ�
                if (map.containsKey(sum - aim)) {
                    res += map.get(sum - aim);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }

    // ������Ԫ�ؿ����ɸ���Ϊ�㣬�ۼӺ�С�ڵ���aim�������O(N)
    public static class sumSubArr3 {
        public static int sumSubSmallEqual(int[] arr, int aim) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            int[] min_sum = new int[arr.length]; // iλ�õ���С�ۼӺ�
            int[] min_sum_index = new int[arr.length]; // iλ�õ���С�ۼӺ͵��ұ߽�
            min_sum[arr.length - 1] = arr[arr.length - 1];
            min_sum_index[arr.length - 1] = arr[arr.length - 1];

            for (int i = arr.length - 2; i >= 0; i--) { // ������������min_sum[i]��min_sum_index[i]
                if (min_sum[i + 1] < 0) {
                    min_sum[i] = arr[i] + min_sum[i + 1];
                    min_sum_index[i] = min_sum_index[i + 1];
                } else {
                    min_sum[i] = arr[i];
                    min_sum_index[i] = i;
                }
            }
            int R = 0; // �������ұ߽�
            int sum = 0;
            int len = 0;
            for (int start = 0; start < arr.length; start++) {
                while (R < arr.length && sum + min_sum[R] <= aim) {
                    sum += min_sum[R];
                    R = min_sum_index[R] + 1;
                }
                sum -= R > start ? arr[start] : 0;
                len = Math.max(len, R - start);
                R = Math.max(R, start + 1); // ��һ��λ�þ������ˣ�start�����ƶ�
            }
            return len;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        System.out.println(sumSubArr1.maxSumArray1(arr, 3));
        System.out.println(sumSubArr1.maxSumArray2(arr, 3));
        System.out.println(sumSubArr1.maxSumArray1(arr, 4));
        System.out.println(sumSubArr1.maxSumArray2(arr, 4));
    }

}
