package 左神算法进阶班;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: //TODO 二叉树问题：树形DP
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/7/1 15:21
 */
public class Code_08_binaryTreeProblem {

    static class Node {
        public int val;
        public Node right;
        public Node left;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * @Description //TODO 求整棵树的最大搜索二叉子树
     * @Author ZX
     * @Date 15:36 2020/7/1
     **/
    public static class MaxSearchSubTree {

        // 递归遍历每个节点需要返回的信息
        static class returnType {
            public int size; // 当前节点的最大搜索二叉子树的大小
            public Node head; // 当前节点的最大搜索二叉子树的头部
            public int min; // 当前节点的最大搜索二叉子树的最小值
            public int max; // 当前节点的最大搜索二叉子树的最大值

            public returnType(int size, Node head, int min, int max) {
                this.size = size;
                this.head = head;
                this.min = min;
                this.max = max;
            }
        }

        public static returnType process(Node head) {
            // 递归终止条件
            if (head == null) {
                return new returnType(0, null, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            // 黑盒
            Node left = head.left;
            returnType leftReturnData = process(left);
            Node right = head.right;
            returnType rightReturnData = process(right);

            // 可能性3
            int includeItSelf = 0;
            if (leftReturnData.head == head.left
                    && rightReturnData.head == head.right
                    && head.val > leftReturnData.max
                    && head.val < rightReturnData.min) {
                includeItSelf = leftReturnData.size + 1 + rightReturnData.size;
            }
            // 可能性1、2
            int p1 = leftReturnData.size;
            int p2 = rightReturnData.size;

            // 拆黑盒
            // 返回当前节点整棵树的四个信息
            // 当前节点的最大搜索二叉子树的大小maxSize
            int maxSize = Math.max(Math.max(p1, p2), includeItSelf);
            // 当前节点的最大搜索二叉子树的头部maxHead
            Node maxHead = p1 > p2 ? leftReturnData.head : rightReturnData.head;
            if (maxSize == includeItSelf) {
                maxHead = head;
            }
            // 当前节点的最大搜索二叉子树的最小值min、最大值max
            int min = Math.min(head.val, Math.min(leftReturnData.min, rightReturnData.min));
            int max = Math.max(head.val, Math.max(leftReturnData.max, rightReturnData.max));

            return new returnType(maxSize, maxHead, min, max);
        }

    }

    /**
     * @Description //TODO 求整棵树的最大搜索二叉子树
     * @Author ZX
     * @Date 15:36 2020/7/1
     **/
    public static class MaxDistance {
        static class returnType {
            public int maxDistance; // 以当前节点为头节点的树的最大距离
            public int h; // 以当前节点为头节点的树的深度

            public returnType(int maxDistance, int h) {
                this.maxDistance = maxDistance;
                this.h = h;
            }
        }

        // 递归过程
        public static returnType process(Node head) {
            if (head == null) {
                return new returnType(0, 0);
            }

            // 黑盒
            returnType leftReturnData = process(head.left);
            returnType rightReturnData = process(head.right);
            // 可能性1
            int p1 = leftReturnData.maxDistance;
            // 可能性2
            int p2 = rightReturnData.maxDistance;
            // 可能性3
            int includeHeadDistance = leftReturnData.maxDistance + 1 + rightReturnData.maxDistance;

            // 拆黑盒
            // 以当前节点为头节点的树的最大距离
            int resultDistance = Math.max(Math.max(p1, p2), includeHeadDistance);
            // 以当前节点为头节点的树的深度
            int hitSelf = Math.max(leftReturnData.h, rightReturnData.h) + 1;
            return new returnType(resultDistance, hitSelf);
        }

        // 主函数
        public static int getMaxD(Node head) {
            return process(head).maxDistance;
        }

    }

    /**
     * @Description //TODO 公司员工参加晚会问题
     * @Author ZX
     * @Date 18:34 2020/7/1
     **/
    public static class AttendParty {

        static class Node {
            public int huo;
            public List<Node> nexts;
            public Node(int huo) {
                this.huo = huo;
                this.nexts = new ArrayList<>();
            }
        }

        static class returnType {
            public int lai_huo;
            public int bulai_huo;
            public returnType(int lai_huo, int bulai_huo) {
                this.lai_huo = lai_huo;
                this.bulai_huo = bulai_huo;
            }
        }

        public static returnType process(Node cur) {
            if (cur == null) {
                return new returnType(0, 0);
            }
            int lai_huo = cur.huo;
            int bulai_huo = 0;
            for (int i = 0; i < cur.nexts.size(); i++) { // 遍历cur的所有子节点
                Node next = cur.nexts.get(i);
                // 黑盒
                returnType nextReturnData = process(next);
                // 拆黑盒
                lai_huo += nextReturnData.bulai_huo;
                bulai_huo += Math.max(nextReturnData.lai_huo, nextReturnData.bulai_huo);
            }
            return new returnType(lai_huo, bulai_huo);
        }

        public static int getMaxHuo(Node head) {
            returnType data = process(head);
            return Math.max(data.lai_huo, data.bulai_huo);
        }
    }

    /**
     * @Description //TODO 判断二叉树是否是平衡二叉树
     * @Author ZX
     * @Date 19:35 2020/7/1
     **/
    public static class isBST {

        static class returnType {
            public boolean isBalance;
            public int h;
            public returnType(boolean isBalance, int h) {
                this.isBalance = isBalance;
                this.h = h;
            }
        }

        // 递归过程
        public static returnType process(Node cur) {
            if (cur == null) {
                return new returnType(true, 0);
            }
            // 黑盒
            returnType leftReturnData = process(cur.left);
            returnType rightReturnData = process(cur.right);
            // 可能性2
            // 情况1
            if (!leftReturnData.isBalance) { // 左树不平衡
                return new returnType(false, 0);
            }
            // 情况2
            if (!rightReturnData.isBalance) { // 右树不平衡
                return new returnType(false, 0);
            }
            // 情况3
            if (Math.abs(leftReturnData.h - rightReturnData.h) > 1) {
                return new returnType(false, 0);
            }
            // 程序走到这就是可能性1
            // 拆黑盒
            return new returnType(true, Math.max(leftReturnData.h, rightReturnData.h) + 1);
        }

        // 主函数
        public static boolean isBst(Node head) {
            return process(head).isBalance;
        }
    }

}
