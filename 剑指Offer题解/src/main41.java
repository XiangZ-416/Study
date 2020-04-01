import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: //TODO һ���������� nums �����������֮�⣬�������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 *                      Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
 *                      ���磺
 *                          ���룺nums = [4,1,4,6]
 *                          �����[1,6] �� [6,1]
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/27 16:11
 */
public class main41 {
    // �ж�num���ض���λ�Ƿ�Ϊ1
    // ��num��Ҫ�жϵ�λ����firstBit1����Ψһ��1���ڵ�λ
    //
    private boolean IsBit1(int num, int firstBit1) {
        return (num & firstBit1) != 0;
    }

    // ����num�����λ��1��������λ��Ϊ0
    private int FindFirstBit1(int num) {
        // ���ۣ�����һ������X��X&(-X)֮��õ������֣��ǰ�X�����ұߵ�1��������
        return num & (- num);
    }

    /**
     * @Author ZX
     * @Description //TODO ���ȥ�أ����ۣ�������ж��������������ظ���������������Щ�ظ������Ƿ����ڣ������Ը����������ʽ�����Щ�ظ�������ȥ��
     *                              ����ظ�������ż���Σ��������ȫ����ȥ������ظ������������Σ�������ᱣ��һ��
     *                     ���ۣ�����һ������X��X&(-X)֮��õ������֣��ǰ�X�����ұߵ�1��������
     *                     ʱ�临�Ӷ�O(N)
     *                     ����ռ临�Ӷ�O(1)
     *                              https://blog.csdn.net/ns_code/article/details/27649027
     * ��������
     *     1�������ɣ�a^b = b^a��s
     *     2������ɣ�(a^b)^c = a^(b^c)��
     *     3�����������a��a^a=0��a^0=a��a^(-1)=~a��
     * ���ۣ� ���������a����a^b^c^d^a^k = b^c^d^k^(a^a) = b^c^d^k^0 = b^c^d^k
     *       Ҳ����˵������ж��������������ظ���������������Щ�ظ������Ƿ����ڣ������Ը����������ʽ�����Щ�ظ�������ȥ
     *       ������˵������ظ�������ż���Σ��������ȫ����ȥ������ظ������������Σ�������ᱣ��һ����
     * @Date 0:10 2020/3/28
     * @Param [array, num1, num2]
     * @return void
     **/
    public void FindNumsAppearOnce3(int[] array, int[] num1, int[] num2) {
        // base case
        if (array == null || array.length < 2) {
            return;
        }

        int i = 0;
        int AllXor = 0;
        // ȫ����� --> �õ�����ֻ����һ�ε����������
        for (i = 0; i < array.length; i++) {
            AllXor ^= array[i];
        }

        int firstBit1 = FindFirstBit1(AllXor); // ����firstBit1�����λ��1��������λ��Ϊ0

        num1[0] = num2[0] = 0; // ��ʼ��������

        i = 0;
        for (i = 0; i < array.length; i++) { // ������array��Ϊ���飺��λ���Ϊ1���ͷֵ�һ�������飻���Ϊ0���ͷֵ���һ����������
            if (IsBit1(array[i], firstBit1)) {
                num1[0] ^= array[i]; // ��һ��������ȫ�������ȥ��ֻʣ����һ�ε�����
            } else {
                num2[0] ^= array[i]; // �ڶ���������ȫ�������ȥ��ֻʣ����һ�ε�����
            }
        }
    }

    /**
     * @Author ZX
     * @Description //TODO ����mapͳ��ÿ�����ֳ��ֵĴ���������main29��
     *                     ʱ�临�Ӷȣ�O(N)
     *                     ����ռ临�Ӷȣ�O(N)
     * @Date 23:52 2020/3/27
     * @Param [array, num1, num2]
     * @return void
     **/
    public void FindNumsAppearOnce2(int[] array, int[] num1, int[] num2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int temp : array) {
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }
        int[] nums = new int[2];
        int i = 0;
        for (int temp : array) {
            if (map.get(temp) == 1) {
                nums[i++] = temp;
            }
        }

        num1[0] = nums[0];
        num2[0] = nums[1];
    }
    /**
     * @Author ZX
     * @Description //TODO ����setȥ�أ�����set.add()����ֵ��boolean
     *                     ʱ�临�Ӷȣ�O(N)
     *                     ����ռ临�Ӷȣ�O(N)
     * @Date 23:24 2020/3/27
     * @Param [array, num1, num2]
     * @return void
     **/
    public void FindNumsAppearOnce1(int[] array, int[] num1, int[] num2) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                set.remove(value);
            }
        }

        Object[] help = set.toArray();
        num1[0] = (int) help[0];
        num2[0] = (int) help[1];
    }
}
