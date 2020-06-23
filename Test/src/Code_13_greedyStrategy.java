import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: //TODO ̰�Ĳ���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/21 11:10
 */
public class Code_13_greedyStrategy {

    /**
     * @Description //TODO ��ɰ��ֵ���������С���ַ���
     * @Author ZX
     * @Date 11:24 2020/6/21
     **/
    public static class CombineStrMin {

        static class myComparator implements Comparator<String> {

            @Override
            public int compare(String o1, String o2) {
                // ����̰�Ĳ���
                return (o1 + o2).compareTo(o2 + o1); // o1 + o2�ֵ���С��o2 + o1���ֵ���o1�ͷ���o2ǰ��
            }
        }

        public static String minCombStr(String[] strs) {
            // base case
            if (strs == null || strs.length == 0) {
                return null;
            }

            StringBuilder res = new StringBuilder();
            Arrays.sort(strs, new myComparator());
            for (String str : strs) {
                res.append(str);
            }

            return res.toString();
        }
    }

    /**
     * @Description //TODO �н�������ͭǮ��С�����������룩
     * @Author ZX
     * @Date 15:47 2020/6/21
     * @Param [args]
     * @return void
     **/
    public static class CutGold {
        public static int cutGold(int[] arr) {
            // base case
            if (arr == null || arr.length == 0) {
                return 0;
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(); // С����pq
            for (int cur : arr) { // ���зֽ��װ��С����
                pq.add(cur);
            }
            int sum = 0; // �зֻ��ѵ�ͭǮ��
            while (pq.size() > 1) {
                // ȡ��С�����н�С��������ӣ��ٷ���С���ѡ��ظ���ֱ��С������ֻ��һ����
                sum += pq.poll();
                sum += pq.poll();
                pq.add(sum);
            }
            return sum;
        }
    }

    /**
     * @Description //TODO �������
     * @Author ZX
     * @Date 16:48 2020/6/21
     * @Param
     * @return
     **/
    public static class maxProfit {
        // ��Ŀ
        static class project {
            int cost;
            int profit;

            public project(int cost, int profit) {
                this.cost = cost;
                this.profit = profit;
            }
        }

        static class minCostComparator implements Comparator<project> {
            @Override
            public int compare(project o1, project o2) {
                return o1.cost - o2.cost;
            }
        }

        static class maxProfitComparator implements Comparator<project> {
            @Override
            public int compare(project o1, project o2) {
                return -(o1.profit - o2.profit);
            }
        }

        public static int findMaximizedCapital(int K, int W, int[] profits, int[] costs) {
            project[] projects = new project[profits.length]; // ׼������projects���������Ŀ
            for (int i = 0; i < profits.length; i++) { // ��������Ŀ����������
                projects[i] = new project(costs[i], profits[i]);
            }
            PriorityQueue<project> minCostPq = new PriorityQueue<>(new minCostComparator()); // ����С�����ŵ�С����
            PriorityQueue<project> maxProfitPq = new PriorityQueue<>(new maxProfitComparator()); // ����������ŵ�С����
            for (project project : projects) { // ��������Ŀ�ӵ�minCostPq���Ѷ�Ԫ���ǻ�����С����Ŀ
                minCostPq.add(project);
            }

            for (int i = 0; i < K; i++) { // ��������Ŀ�������K��
                while (!minCostPq.isEmpty() && minCostPq.peek().cost <= W) {
                    maxProfitPq.add(minCostPq.poll());
                }
                if (maxProfitPq.isEmpty()) {
                    return W;
                }
                W += maxProfitPq.poll().profit;
            }
            return W;
        }

    }

    /**
     * @Description //TODO ��������
     * @Author ZX
     * @Date 20:54 2020/6/21
     * @Param
     * @return
     **/
    public static class bestArrange {

        static class Program {
            int startTime;
            int endTime;

            public Program(int startTime, int endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }
        }

        static class myComparator implements Comparator<Program> { // �Ƚ���������ǰ��
            @Override
            public int compare(Program o1, Program o2) {
                return o1.endTime - o2.endTime;
            }
        }

        public static int arrangeProcess(Program[] programs, int curTime) {

            int res = 0; // һ�����԰���res��

            Arrays.sort(programs, new myComparator());
            for (Program program : programs) {
                if (program.startTime >= curTime) {
                    res++;
                    curTime = program.endTime;
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {

//        System.out.print("�ֵ�����С����ϣ�");
//        String[] strs = {"a", "ab"};
//        System.out.println(CombineStrMin.minCombStr(strs));
//
//        System.out.print("�н�������ͭǮ��С��");
//        int[] arr = {10, 20, 30};
//        System.out.println(CutGold.cutGold(arr));

        System.out.print("�������: ");
        int k = 2, W = 0;
        int[] Profits = {1, 2, 3};
        int[] costs= {0, 1, 1};
        System.out.println(maxProfit.findMaximizedCapital(k, W, Profits, costs));

    }

}
