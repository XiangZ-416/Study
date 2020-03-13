package 左神算法初级班02;

import java.util.Arrays;

public class Code_08_NetherlandsFlag {
    /**
     * 划分问题
     * @param arr 测试数组
     * @param current 当前遍历到的位置
     * @param r 测试数组的右边界
     * @param num 需比较的值
     */
    public static void partition(int[]arr, int current, int r ,int num) {
        // 定义小于区域的右边界
        int less = current - 1;
        // 定义大于区域的左边界
        int more = r + 1;
        // 判断并交换
        // 当前位置与大于区域的左边界时
        while (current != more) { // 当前位置重叠大于区域左边界位置时停止划分
            if (arr[current] < num) { // 当前位置元素小于num
                // 当前位置元素与小于区域右边界下一位位置元素交换，当前位置右移一位，小于区域右边界右移一位
                Swap(arr, current++, ++less);
            }else if (arr[current] == num) { // 当前位置元素等于num
                // 当前位置右移一位
                current++;
            }else { // 当前位置元素大于num
                // 当前位置元素与大于区域左边界前一位元素交换，当前位置不变，大于区域左边界左移一位
                Swap(arr, current, --more);
            }
        }
    }

    public static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 创建测试数组
        int[] arr = {1, 5, 3, 4, 2, 8};
        // 调用划分方法
        partition(arr, 0, arr.length - 1, 5);
        // 将划分后的字符串打印
        System.out.println(Arrays.toString(arr));
    }
}