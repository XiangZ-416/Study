package �����㷨���װ�;

import java.util.Stack;

/**
 * @Description: //TODO ����ջ
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/28 17:27
 */
public class Code_05_monotonicStack {

    /**
     * @Description //TODO ������Ӿ���Ĵ�С
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
            for (int i = 0; i < map.length; i++) { // ��
                for (int j = 0; j < map[0].length; j++) { // ��
                    height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
                }
                maxArea = Math.max(maxRecFromBottom(height), maxArea);
            }
            return maxArea;
        }

        // һ�������ʾֱ��ͼ���ҵ�������������磺[4, 3, 2, 5, 6]
        public static int maxRecFromBottom(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) { // ���������е�ÿһ����
                // ����ջѹ��
                while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {  // ����height[stack.peek()]λ�õ����
                    int j = stack.pop();
                    int k = stack.isEmpty() ? -1 : stack.peek(); // k��stack.peek()����ʱ�������ֵ������λ�õ���߽�
                    int curArea = (i - k - 1) * height[j]; // ����ֵj��Ϊ�±��ֵ��Ϊ�����������
                    maxArea = Math.max(maxArea, curArea);
                }
                stack.push(i);
            }
            // ��ʱ�����е����Ѿ�ȫ��ѹ���ջ��
            while (!stack.isEmpty()) { // ����ջ��ʣ�µ�Ԫ��
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (height.length - k - 1) * height[j]; // ��ʱ�ұ߽�̶�Ϊ���鳤��
                maxArea = Math.max(maxArea, curArea);
            }
            return maxArea;
        }
    }

    /**
     * @Description //TODO ����ɽ�ɼ�ɽ����
     * @Author ZX
     * @Date 11:52 2020/6/29
     **/
    public static class NumberOfVisiblePeaks {

        // ջ�д�ŵ��������ͣ���ǰֵ������ǰֵ���ֵĴ���
        static class Pair {
            public int value;
            public int times;

            public Pair(int value) {
                this.value = value;
                this.times = 1; // ��ǰ��������ջĬ����1��
            }
        }

        public static long communications(int[] arr) {
            if (arr == null || arr.length < 2) {
                return 0;
            }
            int size = arr.length;
            int maxIndex = 0;
            // �ҵ����ֵ��λ��
            for (int i = 0; i < size; i++) {
                maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
            }
            int value = arr[maxIndex]; // ���ֵ
            int index = nextIndex(size, maxIndex); // ���ֵ�±����һ�����Ӵ�λ�ÿ�ʼ����������ջ
            long res = 0L;
            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(value)); // ���ֵ������ջ
            while (index != maxIndex) {
                value = arr[index];
                // ����ջ�׵�ջ���ɴ�Сջ�ṹ
                while (!stack.isEmpty() && stack.peek().value < value) {
                    int times = stack.pop().times;
                    res += getInternalSum(times) + 2 * times; // C(2 , times) + 2 * times
                }
                // ջ��ֻʣ���һ��Ԫ���ˣ�����������ջ�׵�ֵ��������ջ�׵�ֵ
                if (!stack.isEmpty() && stack.peek().value == value) {
                    stack.peek().times++;
                } else {
                    stack.push(new Pair(value));
                }
                index = nextIndex(size, index); // ������������һ��Ԫ��
            }

            // ����׶�
            // ����׶εĵ�1�׶�
            while (stack.size() > 2) {
                int times = stack.pop().times;
                res += getInternalSum(times) + 2 * times;
            }
            // ����׶εĵ�2�׶�
            if (stack.size()==2){
                int times = stack.pop().times;
                res += getInternalSum(times) + (stack.peek().times == 1 ? times : 2*times);
            }
            // ����׶εĵ�3�׶�
            res += getInternalSum(stack.peek().times);

            return res;
        }

        // C(2, N)
        private static long getInternalSum(int n) {
            return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
        }

        // ����������iλ�õ���һ��λ�õ�����
        private static int nextIndex(int size, int i) {
            return i < (size - 1) ? (i + 1) : 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5};
        System.out.println("����ɽ�ɼ�ɽ����:" + NumberOfVisiblePeaks.communications(arr));
    }

}
