import java.util.HashMap;

/**
 * @Description: //TODO ���鼯
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/20 22:13
 */
public class Code_12_UnionFindSet {

    /**
     * @Description //TODO �������鼯
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

            HashMap<Node, Node> fatherMap; // key���ڵ�node��value��node�ڵ�Ĵ���ڵ�
            HashMap<Node, Integer> numMap; // key���ڵ�node��value��node�ڵ����ڵļ��ϵĽڵ�����

            // ��ʼ�����鼯
            public unionFindSet(Node[] nodes) {
                fatherMap = new HashMap<>();
                numMap = new HashMap<>();
                makeSets(nodes);
            }

            /**
             * @Description //TODO �������鼯
             * @Author ZX
             * @Date 22:20 2020/6/20
             * @Param [list]
             * @return void
             **/
            private void makeSets(Node[] nodes) {
                for (Node node : nodes) {
                    fatherMap.put(node, node); // ÿ���ڵ㵥�����һ�����ϡ�������������ڼ��ϵĴ�����
                    numMap.put(node, 1); // ÿ���ڵ��Ӧ���Ͻڵ��������Ϊ1
                }
            }

            /**
             * @Description //TODO ���ҽڵ�node���ڼ��ϵĴ���ڵ㣬���Ż����鼯
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
                fatherMap.put(node, father); // �Ż�
                return father;
            }

            /**
             * @Description //TODO node1��node2�Ƿ���һ������
             * @Author ZX
             * @Date 22:56 2020/6/20
             * @Param [node1, node2]
             * @return boolean
             **/
            private boolean isSameSet(Node node1, Node node2) {
                Node node1Represent = searchAndOptimization(node1); // node1�Ĵ���ڵ�
                Node node2Represent = searchAndOptimization(node2); // node2�Ĵ���ڵ�
                return node1Represent == node2Represent;
            }

            /**
             * @Description //TODO ��node1���ڼ�����node2���ڼ��Ϻϲ�
             * @Author ZX
             * @Date 22:50 2020/6/20
             * @Param [node1, node2]
             * @return void
             **/
            private void unionSets(Node node1, Node node2) {
                if (node1 == null || node2 == null) {
                    return;
                }

                Node node1Represent = searchAndOptimization(node1); // node1�Ĵ���ڵ�
                Node node2Represent = searchAndOptimization(node2); // node2�Ĵ���ڵ�
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
     * @Description //TODO ������(�������ܴ󣬾���Ҫ��Ƭ����ͳ�ƣ�Ȼ��ͨ�����鼯���߽粢�ϲ�)
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
            int res = 0; // ��ʼ�����ĸ���
            // ����matrix
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
            matrix[i][j] = 2; // ��ǰλ����1����Ⱦ��2
            infect(matrix, i + 1, j, height, width); // ��Ⱦ��
            infect(matrix, i - 1, j, height, width ); // ��Ⱦ��
            infect(matrix, i, j + 1, height, width); // ��Ⱦ��
            infect(matrix, i, j - 1, height, width); // ��Ⱦ��
        }
    }

    public static void main(String[] args) {
        int[][] m1 = { {0, 0, 1, 0, 1, 0},
                       {1, 1, 1, 0, 1, 0},
                       {1, 0, 0, 1, 0, 0},
                       {0, 0, 0, 0, 0, 0},
                       {1, 1, 0, 0, 0, 0}
                     };
        System.out.println("����������" + islandProblem.islandNums(m1));

    }


}
