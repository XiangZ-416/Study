/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分,
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class main14 {
    /**
     * 方法1：开辟两个空间分别存放奇数、偶数
     * 时间复杂度：O(N)
     * @param array
     */
    public static void reOrderArray1 (int [] array) {
        // base case
        if (array == null || array.length <=1) {
            return;
        }

        // 1、提取奇、偶
        int[] help1 = new int[array.length]; // 存偶数
        int[] help2 = new int[array.length]; // 存奇数
        int j = 0;
        int h = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){ // 当前数为偶数
                help1[j++] = array[i]; // 一共j个偶数
            } else { // 当前数是奇数
                help2[h++] = array[i]; // 一共h个奇数
            }
        }

        // 2、存回
        int c = 0;
        for (int i = 0; i < h; i++) { // 将h个奇数存到array
            array[c++] = help2[i];
        }
        for (int i = 0; i < j; i++) { // 将j个偶数存到array
            array[c++] = help1[i];
        }
    }

    /**
     * 方法2：利用插入排序的思想
     * 时间复杂度O(N^2)
     * @param array
     */
    public static void reOrderArray2 (int [] array) {
        // base case
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length; i++) { // 从1开始遍历数组array
            if (array[i] % 2 != 0) { //当前数是奇数
                for (int j = i - 1; j >= 0; j--) {
                    if (array[j] % 2 == 0) { // 当前数前一个数是偶数就交换array[j + 1]和array[j]
                        int temp = array[j + 1];
                        array[j + 1] = temp;
                        array[j] = array[j + 1];
                    }else {  // 当前数前一个是奇数，停止交换
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 7, 6, 9};
        reOrderArray1(array);
        System.out.println("方法1：");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("------");
        reOrderArray2(array);
        System.out.println("方法2：");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}