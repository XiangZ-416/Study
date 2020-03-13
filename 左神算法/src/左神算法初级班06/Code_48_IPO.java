package 左神算法初级班06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_48_IPO {
    /**
     * 每一个Node就是每一个项目
     */
    public static class Node {
        public int p; // 收益
        public int c; // 花费

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
    /**
     * 从小到大排
     * 按花费的比较器：花费低的放到上面
     */
    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }
    /**
     * 从大到小排
     * 按收益的比较器：收益高的放到上面
     */
    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }
    /**
     * 主方法
     * @param k 最多做K个项目
     * @param W 初始本金
     * @param Profits 利润数组
     * @param Capital 花费数组
     * @return 获得的最大钱数
     */
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length]; // 准备数组nodes存放所有项目
        for (int i = 0; i < Profits.length; i++) { // 将所有项目存到数组中
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator()); // 按花费从小到大排序的小根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator()); // 按利润从大到小排序的大根堆
        for (int i = 0; i < nodes.length; i++) { // 将所有项目加到小根堆
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) { // 依次做项目，最多做K个
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) { // 如果小根堆里还有项目，且小根堆堆顶项目花费<=本金
                maxProfitQ.add(minCostQ.poll()); // 将小根堆堆顶项目弹出放到大根堆
            }
            if (maxProfitQ.isEmpty()) { // 如果大根堆为空，说明现在的资金做不了花费最小的项目，直接返回当前总钱数，即为获得的最大钱数
                return W;
            }
            W += maxProfitQ.poll().p; // 做完一个项目后，本金加上所获得的利润，即当前获得的最大钱数
        }
        return W; // 获得的最大钱数
    }
}
