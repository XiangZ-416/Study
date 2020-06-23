import java.util.HashMap;

/**
 * @Description: //TODO 并查集
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/20 22:13
 */
public class Code_12_UnionFindSet {

    /**
     * @Description //TODO 创建并查集
     * @Author ZX
     * @Date 23:01 2020/6/20
     * @Param
     * @return
     **/
    public static class UnionFind {

        static class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        public static class unionFindSet {

            HashMap<Node, Node> fatherMap; // key：节点node，value：node节点的代表节点
            HashMap<Node, Integer> numMap; // key：节点node，value：node节点所在的集合的节点总数

            // 初始化并查集
            public unionFindSet(Node[] nodes) {
                fatherMap = new HashMap<>();
                numMap = new HashMap<>();
                makeSets(nodes);
            }

            /**
             * @Description //TODO 构建并查集
             * @Author ZX
             * @Date 22:20 2020/6/20
             * @Param [list]
             * @return void
             **/
            private void makeSets(Node[] nodes) {
                for (Node node : nodes) {
                    fatherMap.put(node, node); // 每个节点单独组成一个集合。故自身就是所在集合的代表集合
                    numMap.put(node, 1); // 每个节点对应集合节点的总数都为1
                }
            }

            /**
             * @Description //TODO 查找节点node所在集合的代表节点，并优化并查集
             * @Author ZX
             * @Date 22:44 2020/6/20
             * @Param [node]
             * @return Code_12_UnionFindSet.Node
             **/
            private Node searchAndOptimization(Node node) {
                Node father = fatherMap.get(node);
                if (father != node) {
                    father = searchAndOptimization(father);
                }
                fatherMap.put(node, father); // 优化
                return father;
            }

            /**
             * @Description //TODO node1和node2是否在一个集合
             * @Author ZX
             * @Date 22:56 2020/6/20
             * @Param [node1, node2]
             * @return boolean
             **/
            private boolean isSameSet(Node node1, Node node2) {
                Node node1Represent = searchAndOptimization(node1); // node1的代表节点
                Node node2Represent = searchAndOptimization(node2); // node2的代表节点
                return node1Represent == node2Represent;
            }

            /**
             * @Description //TODO 将node1所在集合与node2所在集合合并
             * @Author ZX
             * @Date 22:50 2020/6/20
             * @Param [node1, node2]
             * @return void
             **/
            private void unionSets(Node node1, Node node2) {
                if (node1 == null || node2 == null) {
                    return;
                }

                Node node1Represent = searchAndOptimization(node1); // node1的代表节点
                Node node2Represent = searchAndOptimization(node2); // node2的代表节点
                Integer node1SetNum = numMap.get(node1);
                Integer node2SetNum = numMap.get(node2);
                if (node1Represent != node2Represent) {
                    if (node1SetNum < node2SetNum) {
                        fatherMap.put(node1Represent, node2Represent);
                        node2SetNum = node2SetNum + node1SetNum;
                    } else {
                        fatherMap.put(node2Represent, node1Represent);
                        node1SetNum = node1SetNum + node2SetNum;
                    }
                }
            }
        }
    }

    /**
     * @Description //TODO 岛问题(如果矩阵很大，就需要分片并行统计，然后通过并查集检查边界并合并)
     * @Author ZX
     * @Date 23:02 2020/6/20
     * @Param
     * @return
     **/
    public static class islandProblem {
        private static int islandNums(int[][] matrix) {
            // base case
            if (matrix == null) {
                return 0;
            }

            int height = matrix.length;
            int width = matrix[0].length;
            int res = 0; // 初始化岛的个数
            // 遍历matrix
            for (int i = 0; i < height; i ++) {
                for (int j = 0; j < width; j++) {
                    if (matrix[i][j] == 1) {
                        res++;
                        infect(matrix, i, j, height, width);
                    }
                }
            }
            return res;
        }

        private static void infect(int[][] matrix, int i, int j, int height, int width) {
            if (i < 0 || i >= height || j < 0 || j >= width || matrix[i][j] != 1) {
                return;
            }
            matrix[i][j] = 2; // 当前位置是1，感染成2
            infect(matrix, i + 1, j, height, width); // 感染下
            infect(matrix, i - 1, j, height, width ); // 感染上
            infect(matrix, i, j + 1, height, width); // 感染右
            infect(matrix, i, j - 1, height, width); // 感染左
        }
    }

    public static void main(String[] args) {
        int[][] m1 = { {0, 0, 1, 0, 1, 0},
                       {1, 1, 1, 0, 1, 0},
                       {1, 0, 0, 1, 0, 0},
                       {0, 0, 0, 0, 0, 0},
                       {1, 1, 0, 0, 0, 0}
                     };
        System.out.println("岛的数量：" + islandProblem.islandNums(m1));

    }


}
