package �����㷨������04;

class Code_34_IsBalancedTree {
    public static class Node {
        private  int value;
        private Node left;
        private Node right;

        public Node(int value) {
            value = this.value;
        }
    }

    public static class ReturnData {
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB; // �Ƿ�ƽ��
            this.h = h; // �߶�
        }
    }

    public static ReturnData Process(Node head) {
        // base case
        if (head == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = Process(head.left); // �õ��������Ƿ�ƽ��͸߶���Ϣ
        if (!leftData.isB) { // ��ǰ�ڵ����������ƽ�⣬����������ƽ���ˣ��߶���Ϣû�����ˣ�ֱ�Ӿ�0
            return new ReturnData(false, 0);
        }
        ReturnData rightData = Process(head.right); // �õ��������Ƿ�ƽ��͸߶���Ϣ
        if (!rightData.isB) { // ��ǰ�ڵ����������ƽ�⣬����������ƽ���ˣ��߶���Ϣû�����ˣ�ֱ�Ӿ�0
            return new ReturnData(false, 0);
        }
        // �������˵����ǰ�ڵ������������ƽ�⣬��Ҫ�Ա����������ĸ߶Ȳ��Ƿ����1
        if (Math.abs(leftData.h - rightData.h) > 1) {
            return new ReturnData(false, 0);
        }
        // ����������ƽ�⣬�Ҹ߶Ȳ�С�ڵ���1����˽ڵ���Ϊ���ڵ��������ƽ���
        // �߶���Ϊ������������ߵĸ߶�+1
        return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
    }
    // ������
    public static boolean isB(Node head) {
        return Process(head).isB;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isB(head));
    }
}
