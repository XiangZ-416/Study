import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * ��Ŀ����
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 * ��������������0��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/19 0:20
 */
public class main29 {
    /**
     * @Author ZX
     * @Description
     *      1.����HashMap��ţ�key��array[i]��value��array[i]���ֵĴ���
     *      2.����key�����key��Ӧ��value����array���ȵ�һ�룬���key
     * ʱ�临�Ӷȣ�O(N)
     * ����ռ临�Ӷȣ�O(���ٸ���ͬ����)
     * @Date 16:43 2020/3/19
     * @Param [array]
     * @return int
     **/
    public static int MoreThanHalfNum_Solution(int[] array) {
        // base case
        if (array == null || array.length == 0)
            return 0;

        // 1
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : array) {
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            }else {
                map.put(temp, map.get(temp) + 1);
            }
        }

        // 2
        for (int key : map.keySet()) {
            if (map.get(key) > array.length / 2) {
                return key;
            }
        }
        return 0;
    }

    // For test
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}
