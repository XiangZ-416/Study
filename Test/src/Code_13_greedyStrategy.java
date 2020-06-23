import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: //TODO 贪心策略
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/21 11:10
 */
public class Code_13_greedyStrategy {

    /**
     * @Description //TODO 组成按字典序排列最小的字符串
     * @Author ZX
     * @Date 11:24 2020/6/21
     **/
    public static class CombineStrMin {

        static class myComparator implements Comparator<String> {

            @Override
            public int compare(String o1, String o2) {
                // 定制贪心策略
                return (o1 + o2).compareTo(o2 + o1); // o1 + o2字典序小于o2 + o1的字典序，o1就放在o2前面
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
     * @Description //TODO 切金条花费铜钱最小（哈夫曼编码）
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

            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小根堆pq
            for (int cur : arr) { // 将切分结果装进小根堆
                pq.add(cur);
            }
            int sum = 0; // 切分花费的铜钱数
            while (pq.size() > 1) {
                // 取出小根堆中较小的两个相加，再放入小根堆。重复，直到小根堆中只有一个数
                sum += pq.poll();
                sum += pq.poll();
                pq.add(sum);
            }
            return sum;
        }
    }

    /**
     * @Description //TODO 利润最大化
     * @Author ZX
     * @Date 16:48 2020/6/21
     * @Param
     * @return
     **/
    public static class maxProfit {
        // 项目
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
            project[] projects = new project[profits.length]; // 准备数组projects存放所有项目
            for (int i = 0; i < profits.length; i++) { // 将所有项目存在数组中
                projects[i] = new project(costs[i], profits[i]);
            }
            PriorityQueue<project> minCostPq = new PriorityQueue<>(new minCostComparator()); // 按最小花费排的小根堆
            PriorityQueue<project> maxProfitPq = new PriorityQueue<>(new maxProfitComparator()); // 按最大收益排的小根堆
            for (project project : projects) { // 将所有项目加到minCostPq，堆顶元素是花费最小的项目
                minCostPq.add(project);
            }

            for (int i = 0; i < K; i++) { // 依次做项目，最多做K次
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
     * @Description //TODO 宣讲场次
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

        static class myComparator implements Comparator<Program> { // 先结束的排在前面
            @Override
            public int compare(Program o1, Program o2) {
                return o1.endTime - o2.endTime;
            }
        }

        public static int arrangeProcess(Program[] programs, int curTime) {

            int res = 0; // 一共可以安排res场

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

//        System.out.print("字典序最小的组合：");
//        String[] strs = {"a", "ab"};
//        System.out.println(CombineStrMin.minCombStr(strs));
//
//        System.out.print("切金条花费铜钱最小：");
//        int[] arr = {10, 20, 30};
//        System.out.println(CutGold.cutGold(arr));

        System.out.print("利润最大化: ");
        int k = 2, W = 0;
        int[] Profits = {1, 2, 3};
        int[] costs= {0, 1, 1};
        System.out.println(maxProfit.findMaximizedCapital(k, W, Profits, costs));

    }

}
