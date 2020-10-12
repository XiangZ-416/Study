/**
 * @Description: //TODO 荷兰国旗问题
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/5 21:09
 */
public class Code_04_netherlands {

    private static void swap(int[] arr, int i, int j) {
        int help = arr[i];
        arr[i] = arr[j];
        arr[j] = help;
    }

    /**
     * @Author ZX
     * @Description //TODO 划分为小于等于、大于这两个区域
     * @Date 21:26 2020/6/5
     * @Param [arr, num]
     * @return void
     **/
    public static void partition1(int[] arr, int num) {

        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        int less = -1; // 初始化小于等于区域的右边界
        int cur = 0; // 当前位置

        while (cur < arr.length) {
              if (arr[cur] <= num) { // 如果当前数小于等于num
                  // 当前数与小于等于区域右边界的下一个元素交换
                  swap(arr, cur, less + 1);
                  // 小于等于区域向右扩1
                  // 更新当前位置
                  less++;
                  cur++;
              } else {
                  // 更新当前位置
                  cur++;
              }
        }

    }

    /**
     * @Author ZX
     * @Description //TODO 划分为小于、等于、大于这三个区域
     * @Date 21:39 2020/6/5
     * @Param [arr, num]
     * @return void
     **/
    public static void partition2(int[] arr, int num) {

        // base case
        if (arr == null || arr.length < 2) {
            return;
        }

        int less = -1;
        int more = arr.length;
        int cur = 0;

        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr, cur, less + 1);
                less++;
                cur++;
            } else if (arr[cur] == num) {
                cur++;
            } else {
                // 注意此处cur不能动，因为大于区域的前一个是待定区，不知道其与num的大小关系
                swap(arr, cur, more -1);
                more--;
            }
        }

    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 3, 4, 2, 8};
        partition1(arr, 6);
        for (int i : arr) {
            System.out.print(" " + i);
        }
        System.out.println();
        partition2(arr, 5);
        for (int i : arr) {
            System.out.print(" " + i);
        }

    }

}
