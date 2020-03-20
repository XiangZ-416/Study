/**
 * @Description:
 * ��Ŀ����
 * ����һ���������飬������������Ҳ�и����������е�һ������������������һ�������顣������������ĺ͵����ֵ��
 * Ҫ��ʱ�临�Ӷ�ΪO(n)��
 *
 * ʾ��1:
 * ����: array = [-2,1,-3,4,-1,2,1,-5,4]
 * ���: 6
 * ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
 *
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/19 21:06
 */
public class main31 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int max = Integer.MIN_VALUE; // ��ʼ��maxΪ�����ڵ���С������Ϊ�����п��ܳ��ָ��������Գ�ʼ������������ۼӺ�Ϊ�����е���С����
        int curSum = 0; // ��ʼ����ǰ�ۼӺ�Ϊ0
        // ÿ��һ�������е���Ԫ�صõ���curSum�����жϵ�ǰ�������ۼӺ�curSum����һ���ۼӺ�˭��˭����max��
        // �����ǰ�������ۼӺ�С��0����ǰ�����鲻�������������������벿�֣���ʱ����ǰ�������ۼӺ�����Ϊ0��
        // ���������ÿ��һ�������е���Ԫ�صõ���curSum�������������������
        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            max = Math.max(max, curSum);
//          curSum = curSum < 0 ? 0 : curSum;
            curSum = Math.max(curSum, 0);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
