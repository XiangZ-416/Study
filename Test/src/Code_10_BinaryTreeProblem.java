import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: //TODO ����������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/18 13:58
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
     * @Description //TODO �������ı���
     * @Author ZX
     * @Date 14:03 2020/6/18
     **/
    public static class traverseBinaryTree {

// �ݹ��

        /**
         * @Description //TODO �������
         * @Author ZX
         * @Date 14:08 2020/6/18
         **/
        public static void PreOrderTraversalRecursive(treeNode root) {

            System.out.print("�ݹ�����������" + " ");

            // base case
            if (root == null) {
                return;
            }
            System.out.print(root.val + " ");
            PreOrderTraversalRecursive(root.left);
            PreOrderTraversalRecursive(root.right);
        }

        /**
         * @Description //TODO �������
         * @Author ZX
         * @Date 15:02 2020/6/18
         **/
        public static void midOrderTraversalRecursive(treeNode root) {

            System.out.print("�ݹ�����������" + " ");

            // base case
            if (root == null) {
                return;
            }
            midOrderTraversalRecursive(root.left);
            System.out.print(root.val + " ");
            midOrderTraversalRecursive(root.right);
        }

        /**
         * @Description //TODO �������
         * @Author ZX
         * @Date 15:03 2020/6/18
         **/
        public static void postOrderTraversalRecursive(treeNode root) {

            System.out.print("�ݹ����������" + " ");

            // base case
            if (root == null) {
                return;
            }
            postOrderTraversalRecursive(root.left);
            postOrderTraversalRecursive(root.right);
            System.out.print(root.val + " ");
        }

        /**
         * @Description //TODO �������
         * @Author ZX
         * @Date 23:55 2020/6/18
         **/
        public static class traverseByLayer {
            public static void layerTraverse(treeNode root) {

                System.out.print("���������" + " ");

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

// �ǵݹ��

        /**
         * @Description //TODO �������
         * @Author ZX
         * @Date 17:12 2020/6/18
         **/
        public static void preOrderTraversal(treeNode root) {

            System.out.print("�ǵݹ�����������" + " ");

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
         * @Description //TODO �������
         *                          ��ǰ�ڵ�Ϊ�գ���ջ���ó����Ҵ�ӡ���ѵ�ǰ�ڵ����ң�
         *                          ��ǰ�ڵ㲻Ϊ�գ�����ǰ�ڵ�ѹ��ջ�У���ǰ�ڵ�����
         * @Author ZX
         * @Date 17:28 2020/6/18
         **/
        public static void minOrderTraversal(treeNode root) {

            System.out.print("�ǵݹ�����������" + " ");

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
         * @Description //TODO �������
         *                          �����÷ǵݹ���������˼��ʵ�֣������󣩣�
         *                          ��ʵ�ֺ��������������У���
         * @Author ZX
         * @Date 20:39 2020/6/18
         **/
        public static void postOrderTraversal(treeNode root) {

            System.out.print("�ǵݹ����������" + " ");

            if (root != null) {
                Stack<treeNode> s1 = new Stack<>();
                Stack<treeNode> s2 = new Stack<>();
                s1.push(root);
                while (!s1.isEmpty()) {
                    root = s1.pop();
                    s2.push(root); // s1�����Ĵ浽s2��ʵ�֣�������-->������
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
     * @Description //TODO �ڶ���������һ���ڵ�ĺ�̽��
     *                          ��ǰ�ڵ��������������̽���������������Ľڵ�
     *                          ��ǰ�ڵ�û�������������̽������Ե�ǰ�ڵ�Ϊ�����������һ���ڵ�ĸ��ڵ�
     * @Author ZX
     * @Date 20:44 2020/6/18
     **/
    public static class findSuccessorNode {
        public static Node findSuccessor(Node node) {
            // base case-
            if (node == null) {
                return null;
            }

            if (node.right != null) { // ��ǰ�ڵ���������
                return findRightMostLeftNode(node.right);
            } else { // ��ǰ�ڵ�û��������
                Node parent = node.parent;
                while (parent != null && parent.left != node) {
                    node = parent;
                    parent = node.parent;
                }
                return parent;
            }
        }

        // ���ص�ǰ�ڵ�������������ߵĽڵ�
        private static Node findRightMostLeftNode(Node node) {

            while (node.left != null) {
                node = node.left;
            }

            return node;
        }
    }

    /**
     * @Description //TODO �ڶ���������һ���ڵ��ǰ�����
     *                          ��ǰ�ڵ�������������ǰ�����������������ҵĽڵ�
     *                          ��ǰ�ڵ�û������������ǰ���������Ե�ǰ�ڵ�Ϊ�����������һ���ڵ�ĸ��ڵ�
     * @Author ZX
     * @Date 21:35 2020/6/18
     **/
    public static class findPredecessorNode {
        public static Node findPredecessor(Node node) {
            // base case
            if (node == null) {
                return null;
            }

            if (node.left != null) { // ��ǰ�ڵ���������
                return findLeftMostRight(node.left);
            } else { // ��ǰ�ڵ�û��������
                Node parent = node.parent;
                while (parent != null && parent.right != node) {
                    node = parent;
                    parent = node.parent;
                }
                return parent;
            }

        }

        // ���ص�ǰ�ڵ�����������ҵĽڵ�
        private static Node findLeftMostRight(Node node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }
    }

    /**
     * @Description //TODO �����������л��ͷ����л�
     * @Author ZX
     * @Date 21:52 2020/6/18
     **/
    public static class binaryTreeSerializationAndDeserialization {

        /**
         * @Description //TODO ��������������л�
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
         * @Description //TODO ���������л������л�
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
     * @Description //TODO �ж�һ�ö������Ƿ���ƽ��������������κ�һ�����������������������ĸ߶Ȳ����1
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
            System.out.print("�Ƿ���BST��" + " ");
            return judgeProcess(root);
        }

        private static returnData judgeProcess(treeNode root) {
            // base case
            if (root == null) { // ��ǰ�ڵ��ǿսڵ�
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
     * @Description //TODO �ж�һ�ö������Ƿ��������������������κ�һ���������������ȸ��ڵ�С���������ȸ��ڵ��
     *                                              ������������������
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
     * @Description //TODO �ж�һ�ö������Ƿ�����ȫ������
     *                              ���в������ÿ����㣺
     *                                  ���1���������ң���һ��������ȫ������������false;
     *                                  ���2��<1>����˫ȫ��������һ���ڵ㣻
     *                                        <2>�������ң�����������Ľ����붼��Ҷ�ڵ����ʹ��ȫ������������false;
     * 			                              <3>�������ң�����������Ľ����붼��Ҷ�ڵ����ʹ��ȫ������������false��
     * @Author ZX
     * @Date 23:36 2020/6/18
     **/
    public static class isCompleteBinaryTree {

        public static boolean judgeIsCompleteBinaryTree(treeNode root) {

            System.out.print("�Ƿ���CBT��" + " ");

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
     * @Description //TODO ��ȫ�������Ľڵ���(Ҫ��ʱ�临�Ӷȵ���O(N))
     *                          ���������ĸ߶���L����ڵ������ 2^L - 1
     * @Author ZX
     * @Date 23:58 2020/6/18
     **/
    public static class numberOfNodesCompleteBinaryTree {

        private static int process(treeNode root) {
            // base case
            if (root == null) {
                return 0;
            }

            int leftDepth = getTreeHeight(root.left); // �������߶�
            int rightDepth = getTreeHeight(root.right); // �������߶�
            if (leftDepth == rightDepth) { // ���������߶���ͬ --> ������Ϊ��������
                return 1 + (1 << leftDepth) - 1 + process(root.right); // 1(���ڵ�) + (1 << ld)-1(����ȫ�������ڵ���) + �������ڵ�����
            } else { // ���������߶Ȳ�ͬ --> ������Ϊ��������
                return 1 + (1 << rightDepth) - 1 + process(root.left); // 1(���ڵ�) + (1 << rd)-1(����ȫ�������ڵ���) + �������ڵ�����
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
        System.out.print("�Ƿ���SBT��" + " ");
        System.out.println(isSearchBinaryTree.judgeIsSearchBinaryTree(root));

        traverseBinaryTree.traverseByLayer.layerTraverse(root);
        System.out.println();

        System.out.println(isCompleteBinaryTree.judgeIsCompleteBinaryTree(root));
        System.out.println();

        System.out.print("��ȫ�������Ľڵ������");
        System.out.println(numberOfNodesCompleteBinaryTree.process(root));

    }

}
