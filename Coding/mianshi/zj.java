import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/26 15:41
 */
public class zj {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] sortData = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
            sortData[i] = nums[i];
        }
        /**
         * 思路：1、创建一个排好序的辅助数组， p 原数组指针，q：排好序的数组指针
         * 2、从后向前挨个对比，刚开始p == q == n - 1; 判断当前是否相等。
         * 3、相等说明不用移动，两个一起向前移动。
         * 4、不相等，则把原始数组的指针p向后移动，一直找到相等的时候，两个指针一起向前移动。
         * 5、如果p移到了头，说明q之前的数字都要移动。所以直接返回下标位置+1即可。
         */
        Arrays.sort(sortData);
        int p = n - 1;
        int q = n - 1;
        while(p >= 0 && q >= 0) {
            if(nums[p] == sortData[q]) {
                //相等两个一起向前移动
                p--;
                q--;
            } else {
                //不相等，原始数据指针向前移动，直到移动到头就结束
                while(p >= 0 && nums[p] != sortData[q]) {
                    p--;
                }
            }
        }
        System.out.println(q + 1);
    }
}

