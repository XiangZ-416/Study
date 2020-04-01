import java.util.Arrays;

/**
 * @Description: //TODO �˿���˳��:���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�
 *                                2��10Ϊ���ֱ���AΪ1��JΪ11��QΪ12��KΪ13������С��Ϊ 0 �����Կ����������֡�A ������Ϊ 14��
 *                      ����
 *                          ����: [1,2,3,4,5]
 *                          ���: True
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/1 17:57
 */
public class main46 {
    public static boolean isContinuous(int[] nums) {
        // base case
        if (nums.length != 5)
            return false;

        // 1.��С��������
        Arrays.sort(nums);
        // 2.ͳ��0�ĸ���
        int count = 0; // ��ʼ��0�ĸ���
        for (int temp : nums) {
            if (temp == 0)
                count++;
        }
        // 3.ͳ������֮�����������������֮��Ŀ�ȱ����
        int res = 0; // ��ʼ����ȱ����
        int p1 = count; // ָ��1����������0��
        int p2 = count + 1; // ָ��2
        for (int i = p1; p2 < nums.length; i++) {
            if (nums[p2] - nums[p1] == 1 || nums[p2] - nums[p1] == -13) { // nums[p1]��nums[p2]���� --> �ж���һ��
                p1++;
                p2++;
            } else if (nums[p2] - nums[p1] == 0) { // ��0�������� --> �ж���һ������˳��
                return false;
            } else { // nums[p1]��nums[p2]������ --> ͳ�ƿ�ȱ����
                res += nums[p2] - nums[p1] - 1;
                p1++;
                p2++;
            }
        }
        // 4.��С���ĸ������� || ���ڿ�ȱ��������˳��
        return count == res || count > res;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(isContinuous(nums));
    }
}
