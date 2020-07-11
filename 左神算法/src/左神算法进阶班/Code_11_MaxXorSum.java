package 左神算法进阶班;

/**
 * @Description: //TODO 子数组的最大异或和
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/2 19:54
 */
public class Code_11_MaxXorSum {

    // 暴力解：O(N^3)
    public static int maxXorSum1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int start = 0; start <= i; start++) {
                int res = 0;
                for (int k = start; k <= i; k++) {
                    res ^= arr[k];
                }
                max = Math.max(max, res);
            }
        }
        return max;
    }

    // 优化后的暴力解：O(N^2)
    public static int maxXorSum2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; // 0 ~ i的异或结果
            max = Math.max(max, eor);
            for (int start = 1; start <= i; start++) {
                int startToIEor = eor ^ dp[start - 1]; // startToIEOR：start ~ i的异或结果
            }
            dp[i] = eor;
        }
        return max;
    }

    // 利用前缀树：O(N)
    public static int maxXorSum3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; // 0 ~ i的异或结果
            max = Math.max(max, numTrie.maxXor(eor)); // 选出0 ~ i的中最大的异或结果
            numTrie.add(eor);
        }
        return max;
    }

    //前缀树节点
    public static class Node {
        public Node[] nexts = new Node[2];//只有两个路，0/1
    }

    //前缀树
    public static class NumTrie {
        public Node head = new Node();

        public void add(int num) {
            Node cur = head;
            //位移，整数是31位
            for (int move = 31; move >= 0; move--) {
                //提取出每个进制里面的数字
                //例如：0101 >> 3 = 0
                //在和1进行与运算
                //0 0 0 0
                //0 0 0 1
                //0 0 0 0 //取出了第一位为0
                int path = ((num >> move) & 1);
                //查看是否有路，没有就新建
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        //num：0~i的异或结果，选出最优再返回
        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                //如果考察符号位希望和path是一样的 1^1=0 0^0=0
                //其他位置，希望是相反的 1^0=1 0^1=1
                int best = move == 31 ? path : (path ^ 1);//期待
                best = cur.nexts[best] != null ? best : (best ^ 1);//实际
                //当前位的最优选择，左移当前位的数值后，加入结果(或一下)
                res |= (path ^ best) << move;//设置每一位的答案
                cur = cur.nexts[best];//下一层
            }
            return res;
        }
    }

}
