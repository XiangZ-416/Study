package 左神算法初级班04;

import java.util.LinkedList;
import java.util.Queue;

public class Code_32_SerializeAndReconstructTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 先序序列化
     * @param head 当前节点
     * @return 序列化后的字符串
     */
    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        // 先序序列化：根左右
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res; // 序列化后的字符串
    }

    /**
     * 分割字符串
     * @param preStr 先序序列化产生的字符串
     * @return 分割后的字符串
     */
    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("_"); // 用下划线分割先序序列化后的字符串
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]); // 将每个分割后的每个字符添加到队列中
        }
        return reconPreOrder(queue); // 根据队列中的元素建树
    }

    /**
     * 根据队列中的元素建树
     * @param queue 分割后的字符串
     * @return 树的头节点
     */
    public static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) { // 队列中第一个弹出的数为空，返回空树
            return null;
        }
        // 序列化是中左右；建树也是中左右
        // Integer.valueOf(s)把字符串value解析成Integer对象类型，返回的integer可以调用对象中的方法
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    /**
     * 按层序列化
     * @param head
     * @return 按层序列化后的字符串
     */
    public static String serialByLevel(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "_";
                queue.offer(head.left);
            } else {
                res += "#_";
            }
            if (head.right != null) {
                res += head.right.value + "_";
                queue.offer(head.right);
            } else {
                res += "#_";
            }
        }
        return res;
    }

    /**
     * 分割字符串&建树
     * @param levelStr
     * @return 树的头节点
     */
    public static Node reconByLevelString(String levelStr) {
        String[] values = levelStr.split("_");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<Node>();
        if (head != null) {
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    public static Node generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = null;
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");
    }
}
