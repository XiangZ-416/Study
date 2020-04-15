/**
 * @Description: //TODO �����˻����飺����һ������A[0, 1, ..., n-1]���빹��һ������B[0, 1, ..., n - 1]������B�е�Ԫ��
 *                                   B[i] = A[0] * A[1] * ... * A[i - 1] * A[i + 1] * ... * A[n - 1]������ʹ�ó�����
 *                                   ע�⣺�涨B[0] = A[1] * A[2] * ... * A[n - 1]��B[n - 1] = A[0] * A[1] * ... * A[n - 2]��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/6 21:37
 */

public class main52 {
    /**
     * @Author ZX
     * @Description //TODO ������������������lefts��rights��һ����¼B[i]ֵ����˽��A[0] * A[1] * ... * A[i - 1]��
     *                                                    һ����¼B[i]ֵ���ҳ˽��A[i + 1] * A[i+2] * ... * A[n - 1]��
     *                                                    Ȼ��B[i] = lefts[i] * rights[i];
     *                           ʱ�临�Ӷ�O(N)
     * @Date 23:47 2020/4/8
     * @Param [A]
     * @return int[]
     **/
    public int[] multiply(int[] a) {
        int len = a.length;
        int[] ans = new int[len];
        // base case
        if(a.length == 0)
            return ans;

        int[] leftMultiply = new int[len]; // ������ÿһ��Ԫ����ߵ����˻�
        int[] rightMultiply = new int[len]; // ������ÿһ��Ԫ���ұߵ����˻�
        leftMultiply[0] = rightMultiply[len - 1] = 1; // ��������λ��

        // ��ȡÿһ��Ԫ����ߵ����˻�
        for(int i = 1; i < len; i++) {
            leftMultiply[i] = a[i - 1] * leftMultiply[i - 1];
        }
        // ��ȡÿһ��Ԫ���ұߵ����˻�
        for(int i = len - 2; i >= 0; i--) {
            rightMultiply[i] = a[i + 1] * rightMultiply[i + 1];
        }
        // ���յĳ˻�����
        for(int i = 0; i < len; i++) {
            ans[i] = leftMultiply[i] * rightMultiply[i];
        }

        return ans;
    }
}
