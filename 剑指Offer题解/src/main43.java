import java.util.ArrayList;

/**
 * @Description: //TODO ��ΪS����������:����һ����������������һ������s���������в�����������ʹ�����ǵĺ�������s��
 *                                     ����ж�����ֵĺ͵���s��������˻���С��һ�Լ��ɡ�
 *                      ���ӣ�
 *                          ���룺nums = [2,7,11,15], target = 9
 *                          �����[2,7] ���� [7,2]
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/30 19:57
 */
public class main43 {
        /**
         * @Author ZX
         * @Description //TODO ˫ָ�룺һ��ͷ��һ��β ----> �б�
         *                     1. ����һ���ձ����ʶ���ܳ���ͬ��ͼ���У���������� > �����������ͬ���ĵ�������ͬ���������֣����ԽԶ���˻�ԽС��
         *                     2. ��Ϊ����������ģ����Կ�������һͷ��i��һβ��j������ָ�롣
         *                     3. ��ָ��ָ����������ֺʹ��ڸ�����target����βָ����ǰ�ƶ�һ������ָ��ָ����������ֵĺ�С�ڸ�����target����ͷָ������ƶ�һ��λ�á�
         *                     4. ������i<j������£��ҵ��ĵ�һ�����Ҫ���ֵ��������ĳ˻���С��������ʱ�临�Ӷ�ΪO(n)��
         * @Date 23:49 2020/3/31
         * @Param [array, sum]
         * @return java.util.ArrayList<java.lang.Integer>
         **/
        public static ArrayList<Integer> FindNumbersWithSum2(int [] array,int sum) {
            ArrayList<Integer> list = new ArrayList<>();
            // base case
            if (array == null || array.length < 2) {
                return list;
            }

            int p1 = 0; // ��ָ��
            int p2 = array.length - 1; // ��ָ��
            while(p1 < p2){
                if(array[p1] + array[p2] == sum){
                    list.add(array[p1]);
                    list.add(array[p2]);
                    return list; // ��һ���ҵ�����sum���˻���С��һ�ԣ���һ�Ծ�����Զ��
                }else if(array[p1] + array[p2] > sum){
                    p2--;
                }else{
                    p1++;
                }
            }
            return list;
        }

    public static boolean contains(int[] arr, int target){
        boolean flg = false;
        for(int a : arr){
            if(a == target){
                flg = true;
                break;
            }
        }
        return flg;
    }

    /**
     * @Author ZX
     * @Description //TODO ����1��������
     *                           1.ѭ�����飬�ҳ���ΪS��������ϡ�
     *                           2.�����е�����У��ҳ��˻���С����ϡ�
     *                     ʱ�临�Ӷȣ�0(N^2)
     * @Date 23:46 2020/3/31
     * @Param [array, sum]
     * @return java.util.ArrayList<java.lang.Integer>
     **/
    public static ArrayList<Integer> FindNumbersWithSum1(int [] array, int sum) {
        // base case
        if (array == null || array.length < 2) {
            return null;
        }

        int mul = (sum * sum) / 2; // a * (sum - a)�����ֵ��(sum * sum) / 2
        // 1.ѭ�����飬�ҳ���ΪS���������
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int a : array){
            if(contains(array, sum - a)){
                ArrayList<Integer> list = new ArrayList<>();
                // ��Ӧÿ�����԰����������������С�������
                list.add(Math.min(a, sum - a));
                list.add(Math.max(a, sum - a));
                lists.add(list);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // 2.�����е�����У��ҳ��˻���С�����
        for(ArrayList<Integer> list: lists){
            int temp = list.get(0) * list.get(1);
            if(mul > temp){
                mul = temp;
                ans = list;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        System.out.println(FindNumbersWithSum1(nums, 21));
    }
}
