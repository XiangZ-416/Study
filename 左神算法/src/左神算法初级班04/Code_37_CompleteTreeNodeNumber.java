package �����㷨������04;

public class Code_37_CompleteTreeNodeNumber {
    /**
     * �ڵ�����
     */
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    /**
     * ������
     * @param head ��ȫ��������ͷ�ڵ�
     * @return �ڵ����
     * ʱ�临�Ӷȣ�O(logN^2)
     */
    public static int nodeNum(Node head) {
        // base case
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }
    /**
     * ���Ե�ǰ�ڵ�Ϊ�������Ľڵ����
     * @param node ��ǰ�ڵ�
     * @param level ��ǰ�ڵ��ڵڼ���
     * @param H �����������
     * @return �Ե�ǰ�ڵ�Ϊͷ�����Ľڵ����
     */
    public static int bs(Node node, int level, int H) {
        if (level == H) { // �����ǰ�ڵ��������һ��
            return 1; // ������Ҷ�ڵ�Ϊͷ�����Ľڵ����Ϊ1
        }
        // �Ե�ǰ�ڵ�Ϊͷ����������������߽絽û���ף�����������ȣ�
        if (mostLeftLevel(node.right, level + 1) == H) {
            // ���ף�������Ϊ���������Ҹ߶�ΪH - level����ʱ������Ϊ��ȫ����������ĸ������ͬ
            return (1 << (H - level)) - 1 + 1 + bs(node.right, level + 1, H);
        } else { // û���ף�������Ϊ���������Ҹ߶�ΪH - level - 1����ʱ������Ϊ��ȫ����������ĸ������ͬ
            return (1 << (H - level - 1)) - 1 + 1 + bs(node.left, level + 1, H);
        }
    }
    /**
     * �õ������������h
     * @param node ��ǰ�ڵ�
     * @param level
     * @return
     */
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left; // ��ǰ�ڵ㲻��������
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));
    }
}
