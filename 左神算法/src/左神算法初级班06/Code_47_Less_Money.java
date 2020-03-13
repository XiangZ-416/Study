package 左神算法初级班06;

import java.util.PriorityQueue;

public class Code_47_Less_Money {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(); // 优先队列（系统实现的小根堆）
        for (int i = 0; i < arr.length; i++) { // 所有的数加到堆中
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll(); // 依次拿出两个数
            sum += cur; // 作为代价累加起来
            pQ.add(cur); // 再重新放回堆中
        }
        return sum;
    }

    public static void main(String[] args) {
        // solution
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));
    }
}
