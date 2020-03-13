package �����㷨������06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_48_IPO {
    /**
     * ÿһ��Node����ÿһ����Ŀ
     */
    public static class Node {
        public int p; // ����
        public int c; // ����

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
    /**
     * ��С������
     * �����ѵıȽ��������ѵ͵ķŵ�����
     */
    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }
    /**
     * �Ӵ�С��
     * ������ıȽ���������ߵķŵ�����
     */
    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }
    /**
     * ������
     * @param k �����K����Ŀ
     * @param W ��ʼ����
     * @param Profits ��������
     * @param Capital ��������
     * @return ��õ����Ǯ��
     */
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length]; // ׼������nodes���������Ŀ
        for (int i = 0; i < Profits.length; i++) { // ��������Ŀ�浽������
            nodes[i] = new Node(Profits[i], Capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator()); // �����Ѵ�С���������С����
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator()); // ������Ӵ�С����Ĵ����
        for (int i = 0; i < nodes.length; i++) { // ��������Ŀ�ӵ�С����
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) { // ��������Ŀ�������K��
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) { // ���С�����ﻹ����Ŀ����С���ѶѶ���Ŀ����<=����
                maxProfitQ.add(minCostQ.poll()); // ��С���ѶѶ���Ŀ�����ŵ������
            }
            if (maxProfitQ.isEmpty()) { // ��������Ϊ�գ�˵�����ڵ��ʽ������˻�����С����Ŀ��ֱ�ӷ��ص�ǰ��Ǯ������Ϊ��õ����Ǯ��
                return W;
            }
            W += maxProfitQ.poll().p; // ����һ����Ŀ�󣬱����������õ����󣬼���ǰ��õ����Ǯ��
        }
        return W; // ��õ����Ǯ��
    }
}
