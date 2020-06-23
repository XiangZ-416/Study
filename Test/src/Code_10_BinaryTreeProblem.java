import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: //TODO 二叉树问题
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/18 13:58
 */
public class Code_10_BinaryTreeProblem {

    static class Node {
        public int value;
        public Node parent;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }

    static class treeNode {
        public int val;
        public treeNode left;
        public treeNode right;

        public treeNode(int val) {
            this.val = val;
        }
    }

    /**
     * @Description //TODO 二叉树的遍历
     * @Author ZX
     * @Date 14:03 2020/6/18
     **/
    public static class traverseBinaryTree {

// 递归版

        /**
         * @Description //TODO 先序遍历
         * @Author ZX
         * @Date 14:08 2020/6/18
         **/
        public static void PreOrderTraversalRecursive(treeNode root) {

            System.out.print("递归版先序遍历：" + " ");

            // base case
            if (root == null) {
                return;
            }
            System.out.print(root.val + " ");
            PreOrderTraversalRecursive(root.left);
            PreOrderTraversalRecursive(root.right);
        }

        /**
         * @Description //TODO 中序遍历
         * @Author ZX
         * @Date 15:02 2020/6/18
         **/
        public static void midOrderTraversalRecursive(treeNode root) {

            System.out.print("递归版中序遍历：" + " ");

            // base case
            if (root == null) {
                return;
            }
            midOrderTraversalRecursive(root.left);
            System.out.print(root.val + " ");
            midOrderTraversalRecursive(root.right);
        }

        /**
         * @Description //TODO 后序遍历
         * @Author ZX
         * @Date 15:03 2020/6/18
         **/
        public static void postOrderTraversalRecursive(treeNode root) {

            System.out.print("递归版后序遍历：" + " ");

            // base case
            if (root == null) {
                return;
            }
            postOrderTraversalRecursive(root.left);
            postOrderTraversalRecursive(root.right);
            System.out.print(root.val + " ");
        }

        /**
         * @Description //TODO 按层遍历
         * @Author ZX
         * @Date 23:55 2020/6/18
         **/
        public static class traverseByLayer {
            public static void layerTraverse(treeNode root) {

                System.out.print("按层遍历：" + " ");

                // base case
                if (root == null) {
                    return;
                }

                Queue<treeNode> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    treeNode treeNode = queue.poll();
                    System.out.print(treeNode.val + " ");
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                }
            }

        }

// 非递归版

        /**
         * @Description //TODO 先序遍历
         * @Author ZX
         * @Date 17:12 2020/6/18
         **/
        public static void preOrderTraversal(treeNode root) {

            System.out.print("非递归版先序遍历：" + " ");

            if (root != null) {
                Stack<treeNode> stack = new Stack<>();
                stack.push(root);
                while (!stack.isEmpty()) {
                    root = stack.pop();
                    System.out.print(root.val + " ");
                    if (root.right != null) {
                        stack.push(root.right);
                    }
                    if (root.left != null) {
                        stack.push(root.left);
                    }
                }
            }
        }

        /**
         * @Description //TODO 中序遍历
         *                          当前节点为空，从栈顶拿出并且打印，把当前节点向右；
         *                          当前节点不为空，将当前节点压入栈中，当前节点向左。
         * @Author ZX
         * @Date 17:28 2020/6/18
         **/
        public static void minOrderTraversal(treeNode root) {

            System.out.print("非递归版中序遍历：" + " ");

            if (root != null) {
                Stack<treeNode> stack = new Stack<>();
                while (!stack.isEmpty() || root != null) {
                    if (root != null) {
                        stack.push(root);
                        root = root.left;
                    } else {
                        root = stack.pop();
                        System.out.print(root.val + " ");
                        root = root.right;
                    }
                }
             }
        }

        /**
         * @Description //TODO 后序遍历
         *                          先利用非递归的先序遍历思想实现（中右左）；
         *                          再实现后续遍历（左右中）。
         * @Author ZX
         * @Date 20:39 2020/6/18
         **/
        public static void postOrderTraversal(treeNode root) {

            System.out.print("非递归版后序遍历：" + " ");

            if (root != null) {
                Stack<treeNode> s1 = new Stack<>();
                Stack<treeNode> s2 = new Stack<>();
                s1.push(root);
                while (!s1.isEmpty()) {
                    root = s1.pop();
                    s2.push(root); // s1弹出的存到s2里实现：中右左-->左右中
                    if (root.left != null) {
                        s1.push(root.left);
                    }
                    if (root.right != null) {
                        s1.push(root.right);
                    }
                }
                while (!s2.isEmpty()) {
                    System.out.print(s2.pop().val + " ");
                }
            }
        }

    }

    /**
     * @Description //TODO 在二叉树中找一个节点的后继结点
     *                          当前节点有右子树，其后继结点就是右子树最左的节点
     *                          当前节点没有右子树，其后继结点就是以当前节点为左子树的最后一个节点的父节点
     * @Author ZX
     * @Date 20:44 2020/6/18
     **/
    public static class findSuccessorNode {
        public static Node findSuccessor(Node node) {
            // base case-
            if (node == null) {
                return null;
            }

            if (node.right != null) { // 当前节点有右子树
                return findRightMostLeftNode(node.right);
            } else { // 当前节点没有右子树
                Node parent = node.parent;
                while (parent != null && parent.left != node) {
                    node = parent;
                    parent = node.parent;
                }
                return parent;
            }
        }

        // 返回当前节点右子树的最左边的节点
        private static Node findRightMostLeftNode(Node node) {

            while (node.left != null) {
                node = node.left;
            }

            return node;
        }
    }

    /**
     * @Description //TODO 在二叉树中找一个节点的前驱结点
     *                          当前节点有左子树，其前驱结点就是左子树最右的节点
     *                          当前节点没有左子树，其前驱结点就是以当前节点为右子树的最后一个节点的父节点
     * @Author ZX
     * @Date 21:35 2020/6/18
     **/
    public static class findPredecessorNode {
        public static Node findPredecessor(Node node) {
            // base case
            if (node == null) {
                return null;
            }

            if (node.left != null) { // 当前节点有左子树
                return findLeftMostRight(node.left);
            } else { // 当前节点没有左子树
                Node parent = node.parent;
                while (parent != null && parent.right != node) {
                    node = parent;
                    parent = node.parent;
                }
                return parent;
            }

        }

        // 返回当前节点的左子树最右的节点
        private static Node findLeftMostRight(Node node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }
    }

    /**
     * @Description //TODO 二叉树的序列化和反序列化
     * @Author ZX
     * @Date 21:52 2020/6/18
     **/
    public static class binaryTreeSerializationAndDeserialization {

        /**
         * @Description //TODO 按照先序遍历序列化
         * @Author ZX
         * @Date 21:59 2020/6/18
         **/
        public static String serializationByPre(treeNode root) {
            // base case
            if (root == null) {
                return "#_";
            }

            String res = root.val + "_";
            res += serializationByPre(root.left);
            res += serializationByPre(root.right);

            return res;
        }

        /**
         * @Description //TODO 按先序序列化反序列化
         * @Author ZX
         * @Date 22:54 2020/6/18
         **/
        public static treeNode deserialization(String str) {

            String[] val = str.split("_");
            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < val.length; i++) {
                queue.add(val[i]);
            }
            return recover(queue);
        }

        private static treeNode recover(Queue<String> queue) {
            String val = queue.poll();
            if (val.equals("#")) {
                return null;
            }
            treeNode root = new treeNode(Integer.parseInt(val));
            root.left = recover(queue);
            root.right = recover(queue);

            return root;
        }
    }

    /**
     * @Description //TODO 判断一棵二叉树是否是平衡二叉树：对于任何一颗子树，左子树和右子树的高度差不超过1
     * @Author ZX
     * @Date 22:55 2020/6/18
     **/
    public static class isBalanceBinaryTree {

        static class returnData {
            public boolean isAVL;
            public int h;

            public returnData(boolean isAVL, int h) {
                this.isAVL = isAVL;
                this.h = h;
            }
        }

        public static returnData isBalanceTree(treeNode root) {
            System.out.print("是否是BST：" + " ");
            return judgeProcess(root);
        }

        private static returnData judgeProcess(treeNode root) {
            // base case
            if (root == null) { // 当前节点是空节点
                return new returnData(true, 0);
            }
            returnData leftReturnData = judgeProcess(root.left);
            if (!leftReturnData.isAVL) {
                return new returnData(false, 0);
            }
            returnData rightReturnData = judgeProcess(root.right);
            if (!rightReturnData.isAVL) {
                return new returnData(false, 0);
            }
            if (Math.abs(leftReturnData.h - rightReturnData.h) > 1) {
                return new returnData(false, 0);
            }

            return new returnData(true, Math.max(leftReturnData.h, rightReturnData.h) + 1);
        }

    }

    /**
     * @Description //TODO 判断一棵二叉树是否是搜索二叉树：对于任何一颗子树，左子树比根节点小，右子树比根节点大。
     *                                              即：中序遍历是升序的
     * @Author ZX
     * @Date 23:36 2020/6/18
     **/
    public static class isSearchBinaryTree {

        private static long pre = Long.MIN_VALUE;

        public static boolean judgeIsSearchBinaryTree(treeNode root) {

            // base case
            if (root == null) {
                return true;
            }

            boolean left = judgeIsSearchBinaryTree(root.left);
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            boolean right = judgeIsSearchBinaryTree(root.right);
            return left && right;
        }
    }

    /**
     * @Description //TODO 判断一棵二叉树是否是完全二叉树
     *                              进行层序遍历每个结点：
     *                                  情况1：无左有右，则一定不是完全二叉树，返回false;
     *                                  情况2：<1>左右双全，遍历下一个节点；
     *                                        <2>有左无右，则后面遇到的结点必须都是叶节点才能使完全二叉树，否则false;
     * 			                              <3>无左无右，则后面遇到的结点必须都是叶节点才能使完全二叉树，否则false。
     * @Author ZX
     * @Date 23:36 2020/6/18
     **/
    public static class isCompleteBinaryTree {

        public static boolean judgeIsCompleteBinaryTree(treeNode root) {

            System.out.print("是否是CBT：" + " ");

            // base case
            if (root == null) {
                return true;
            }

            Queue<treeNode> queue = new LinkedList<>();
            queue.add(root);
            treeNode treeNode = queue.poll();
            while (treeNode != null) {
                queue.add(treeNode.left);
                queue.add(treeNode.right);
                treeNode = queue.poll();
            }
            while (!queue.isEmpty()) {
                treeNode = queue.poll();
                if (treeNode != null) {
                    return false;
                }
            }
            return true;
        }


    }

    /**
     * @Description //TODO 完全二叉树的节点数(要求：时间复杂度低于O(N))
     *                          满二叉树的高度是L，其节点个数是 2^L - 1
     * @Author ZX
     * @Date 23:58 2020/6/18
     **/
    public static class numberOfNodesCompleteBinaryTree {

        private static int process(treeNode root) {
            // base case
            if (root == null) {
                return 0;
            }

            int leftDepth = getTreeHeight(root.left); // 左子树高度
            int rightDepth = getTreeHeight(root.right); // 右子树高度
            if (leftDepth == rightDepth) { // 左右子树高度相同 --> 左子树为满二叉树
                return 1 + (1 << leftDepth) - 1 + process(root.right); // 1(根节点) + (1 << ld)-1(左完全左子树节点数) + 右子树节点数量
            } else { // 左右子树高度不同 --> 右子树为满二叉树
                return 1 + (1 << rightDepth) - 1 + process(root.left); // 1(根节点) + (1 << rd)-1(右完全右子树节点数) + 左子树节点数量
            }

        }

        private static int getTreeHeight(treeNode node) {
            int depth = 0;
            while (node != null) {
                depth++;
                node = node.left;
            }
            return depth;
        }
    }

        public static void main(String[] args) {

        treeNode root = new treeNode(1);
        root.left = new treeNode(2);
        root.right = new treeNode(3);
        root.left.left = new treeNode(4);
        root.left.right = new treeNode(5);
        root.right.left = new treeNode(6);
        root.right.right = new treeNode(7);

        traverseBinaryTree.preOrderTraversal(root);
        System.out.println();
        traverseBinaryTree.minOrderTraversal(root);
        System.out.println();
        System.out.print("是否是SBT：" + " ");
        System.out.println(isSearchBinaryTree.judgeIsSearchBinaryTree(root));

        traverseBinaryTree.traverseByLayer.layerTraverse(root);
        System.out.println();

        System.out.println(isCompleteBinaryTree.judgeIsCompleteBinaryTree(root));
        System.out.println();

        System.out.print("完全二叉树的节点个数：");
        System.out.println(numberOfNodesCompleteBinaryTree.process(root));

    }

}
