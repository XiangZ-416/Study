import java.util.ArrayList;

/**
 * @Description: //TODO 和为S的两个数字:输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 *                                     如果有多对数字的和等于s，则输出乘积最小的一对即可。
 *                      例子：
 *                          输入：nums = [2,7,11,15], target = 9
 *                          输出：[2,7] 或者 [7,2]
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/30 19:57
 */
public class main43 {
        /**
         * @Author ZX
         * @Description //TODO 双指针：一个头、一个尾 ----> 夹逼
         *                     1. 基于一个普遍的认识。周长相同的图形中，正方形面积 > 长方形面积。同样的道理，和相同的两个数字，相差越远，乘积越小。
         *                     2. 因为数组是排序的，所以可以设置一头（i）一尾（j）两个指针。
         *                     3. 若指针指向的两个数字和大于给定的target，则尾指针向前移动一个。若指针指向的两个数字的和小于给定的target，则头指针向后移动一个位置。
         *                     4. 在满足i<j的情况下，找到的第一组符合要求的值，即所求的乘机最小的两个。时间复杂度为O(n)。
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

            int p1 = 0; // 左指针
            int p2 = array.length - 1; // 右指针
            while(p1 < p2){
                if(array[p1] + array[p2] == sum){
                    list.add(array[p1]);
                    list.add(array[p2]);
                    return list; // 第一个找到等于sum即乘积最小的一对（第一对距离最远）
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
     * @Description //TODO 方法1：暴力法
     *                           1.循环数组，找出和为S的所有组合。
     *                           2.在所有的组合中，找出乘机最小的组合。
     *                     时间复杂度：0(N^2)
     * @Date 23:46 2020/3/31
     * @Param [array, sum]
     * @return java.util.ArrayList<java.lang.Integer>
     **/
    public static ArrayList<Integer> FindNumbersWithSum1(int [] array, int sum) {
        // base case
        if (array == null || array.length < 2) {
            return null;
        }

        int mul = (sum * sum) / 2; // a * (sum - a)的最大值是(sum * sum) / 2
        // 1.循环数组，找出和为S的所有组合
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int a : array){
            if(contains(array, sum - a)){
                ArrayList<Integer> list = new ArrayList<>();
                // 对应每个测试案例，输出两个数，小的先输出
                list.add(Math.min(a, sum - a));
                list.add(Math.max(a, sum - a));
                lists.add(list);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // 2.在所有的组合中，找出乘机最小的组合
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
