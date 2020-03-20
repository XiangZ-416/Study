/**
 * @Description:
 * ����һ������ n ����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
 * ���磬����12��1��12��Щ�����а���1 ��������1��10��11��12��1һ��������5�Ρ�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/20 12:00
 */
public class main32 {
    /**
     * @Author ZX
     * @Description
     * ����1��ֱ�ӷ�
     *      1.����ж�0-nÿ����1�ĸ���
     *      3.�ۼ�1�ĸ���
     * ʱ�临�Ӷȣ�O(N*logN)
     * @Date 14:01 2020/3/20
     * @Param [n]
     * @return int
     **/
    public int NumberOf1Between1AndN_Solution1(int n) {
        // base case
        if (n < 1)
            return 0;

        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            ans += get1nums(i);
        }
        return ans;
    }

    // ��ȡ0-n��ÿһ������1���ֵĴ���
    public int get1nums(int num) {
        int oneNums = 0;
        while (num != 0) {
            if (num % 10 == 1) { // �жϸ�λ�Ƿ���1
                oneNums++;
            }
            num = num / 10; // ���˸�λʣ�µ���
        }
        return oneNums;
    }

    /**
     * @Author ZX
     * @Description
     * ����2���ݹ�
     * ʱ�临�Ӷȣ�O(logN)
     * @Date 14:07 2020/3/20
     * @Param [n]
     * @return int
     **/
    public int NumberOf1Between1AndN_Solution2(int n) {
        // base case
        if (n < 1)
            return 0;

        int ans = 0; // ���ս��

        String str = "" + n; // ��nת��Ϊ�ַ������ڻ�ȡn��λ��
        int length = str.length(); // nһ��lengthλ
        int res = (int) Math.pow(10, length - 1); // ��ȡ��λ���ݼ���
        int firstBit = n / res; // ��ȡ���λ����
        int otherBit = n % res; // �����λ����λ��ɵ�����
        // �õ���λ�̶�ʱ1���ֵĴ���
        ans = firstBit == 1 ? otherBit + 1 : res; // ��λ��1������λ�̶�ʱ1���ֵĴ����ǳ����λʣ�µ�����+1�����������λ���ݼ���
        // ����λ1���ֵĴ��� = ��λ���� * otherBit��λ�� * 10^(otherBit��λ�� - 1)
        ans += firstBit * (length - 1) * Math.pow(10, length - 1 - 1);

        return ans + NumberOf1Between1AndN_Solution1(otherBit);
    }
}
