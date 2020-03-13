package �����㷨������02;

public class Code_14_MaxGap {
    public static int maxGap(int[] nums) {
        // �������Ϊ�ջ�ֻ��1��Ԫ�أ�����ֵΪ0
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        // �������Ϊ��С����С��Ϊ���
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // ���������ҵ������е������Сֵ
        for (int i = 0; i < len; i++) {
            // ����֪��Сֵ�Ƚϣ������С�͸���
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        // ��Сֵ�������ֵ˵��������ͬһ����������ֵΪ0
        if (min == max) {
            return 0;
        }
        // len+1��Ͱ�д��3����Ϣ
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        // �ٴα�������arr��ȷ�������е�ÿ�����ڼ���Ͱ�������¸�Ͱ��3������
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        // �ҵ�ÿһ���ǿ�Ͱ�������������߷ǿ�Ͱ���õ�ǰ����С - ǰһ�����������Ĳ�ֵ�����Ƿ��ҵ��˸���Ĳ�ֵ
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    /**
     * ȷ����ǰ�����ڼ���Ͱ
     * @param num ��ǰ��
     * @param len Ͱ�ĸ���
     * @param min arr����Сֵ
     * @param max arr�����ֵ
     * @return Ͱ��
     */
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 5, 2};
        System.out.print(maxGap(arr));
    }
}
