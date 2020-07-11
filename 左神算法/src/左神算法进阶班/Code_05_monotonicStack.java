package 左神算法进阶班;

import java.util.Stack;

/**
 * @Description: //TODO 单调栈
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/28 17:27
 */
public class Code_05_monotonicStack {

    /**
     * @Description //TODO 求最大子矩阵的大小
     * @Author ZX
     * @Date 10:36 2020/6/29
     **/
    public static class maxSubMatrix {
        public static int maxRecSize(int[][] map) {
            if (map == null || map.length == 0 || map[0].length == 0) {
                return 0;
            }
            int maxArea = 0;
            int[] height = new int[map[0].length];
            for (int i = 0; i < map.length; i++) { // 行
                for (int j = 0; j < map[0].length; j++) { // 列
                    height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
                }
                maxArea = Math.max(maxRecFromBottom(height), maxArea);
            }
            return maxArea;
        }

        // 一个数组表示直方图，找到最大矩形面积。如：[4, 3, 2, 5, 6]
        public static int maxRecFromBottom(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) { // 遍历数组中的每一个数
                // 单调栈压数
                while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {  // 结算height[stack.peek()]位置的面积
                    int j = stack.pop();
                    int k = stack.isEmpty() ? -1 : stack.peek(); // k：stack.peek()弹出时其下面的值：弹出位置的左边界
                    int curArea = (i - k - 1) * height[j]; // 弹出值j的为下标的值作为高能扩的面积
                    maxArea = Math.max(maxArea, curArea);
                }
                stack.push(i);
            }
            // 此时数组中的数已经全部压入过栈中
            while (!stack.isEmpty()) { // 结算栈中剩下的元素
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (height.length - k - 1) * height[j]; // 此时右边界固定为数组长度
                maxArea = Math.max(maxArea, curArea);
            }
            return maxArea;
        }
    }

    /**
     * @Description //TODO 环形山可见山峰数
     * @Author ZX
     * @Date 11:52 2020/6/29
     **/
    public static class NumberOfVisiblePeaks {

        // 栈中存放的数据类型：当前值，及当前值出现的次数
        static class Pair {
            public int value;
            public int times;

            public Pair(int value) {
                this.value = value;
                this.times = 1; // 当前数初次入栈默认是1次
            }
        }

        public static long communications(int[] arr) {
            if (arr == null || arr.length < 2) {
                return 0;
            }
            int size = arr.length;
            int maxIndex = 0;
            // 找到最大值的位置
            for (int i = 0; i < size; i++) {
                maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
            }
            int value = arr[maxIndex]; // 最大值
            int index = nextIndex(size, maxIndex); // 最大值下标的下一个。从此位置开始遍历依次入栈
            long res = 0L;
            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(value)); // 最大值最先入栈
            while (index != maxIndex) {
                value = arr[index];
                // 单调栈底到栈顶由大到小栈结构
                while (!stack.isEmpty() && stack.peek().value < value) {
                    int times = stack.pop().times;
                    res += getInternalSum(times) + 2 * times; // C(2 , times) + 2 * times
                }
                // 栈中只剩最后一个元素了：待进数等于栈底的值；不等于栈底的值
                if (!stack.isEmpty() && stack.peek().value == value) {
                    stack.peek().times++;
                } else {
                    stack.push(new Pair(value));
                }
                index = nextIndex(size, index); // 遍历数组中下一个元素
            }

            // 清算阶段
            // 清算阶段的第1阶段
            while (stack.size() > 2) {
                int times = stack.pop().times;
                res += getInternalSum(times) + 2 * times;
            }
            // 清算阶段的第2阶段
            if (stack.size()==2){
                int times = stack.pop().times;
                res += getInternalSum(times) + (stack.peek().times == 1 ? times : 2*times);
            }
            // 清算阶段的第3阶段
            res += getInternalSum(stack.peek().times);

            return res;
        }

        // C(2, N)
        private static long getInternalSum(int n) {
            return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
        }

        // 环形数组中i位置的下一个位置的坐标
        private static int nextIndex(int size, int i) {
            return i < (size - 1) ? (i + 1) : 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5};
        System.out.println("环形山可见山峰数:" + NumberOfVisiblePeaks.communications(arr));
    }

}
