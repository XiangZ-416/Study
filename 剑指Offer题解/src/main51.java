import java.util.HashMap;

/**
 * @Description: //TODO �������ظ������֣���һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 *                                      Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 *                                      ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/6 21:34
 */
public class main51 {
    /**
     * @Author ZX
     * @Description //TODO �������Σ�1.��һ��ͳ��numbers������ÿ��Ԫ�س��ֵĴ���
     *                              2.�ڶ�������numbers��Ԫ�ض�Ӧ��value > 1�͸�ֵ��duplication[0]������true
     *                     ʱ�临�Ӷȣ�0(N)
     *                     ����ռ临�Ӷȣ�O(N)
     * @Date 21:57 2020/4/6
     * @Param [numbers, length, duplication]
     * @return boolean
     **/
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        // base case
        if (numbers == null || length == 0)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], 1);
            } else {
                map.put(numbers[i], map.get(numbers[i]) + 1);
            }
        }

        for (int i = 0; i < length; i++) {
            if (map.get(numbers[i]) > 1) {
                duplication[0] = numbers[i];
                return true;
            }
        }

        return false;
    }
}
