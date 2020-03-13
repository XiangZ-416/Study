package �����㷨������04;

import java.util.Stack;

public class Code_35_IsBST {
    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    // �ж�һ�����Ƿ��Ƕ���������
    public Boolean isBinarySearchTree(Node head){
        if(head == null){
            return true;   // �����Ƕ���������
        }
        int pre = Integer.MIN_VALUE;  // ������ý�ֵ����Ϊint���͵���Сֵ����Ϊ�������һ���ڵ���ܴ��Ҳ�Ǻ�С��ֵ
        Stack<Node> stack = new Stack<Node>();
        // ѹһ���߽磬�ٴ��������������ϵ���ֱ������һ�����Һ��ӵĽڵ㣬ȥ���������Һ���
        while(!stack.isEmpty() || head != null){
            if(head != null){
                while (head != null){
                    stack.push(head.left);   // ѹһ���ڵ�
                    head = head.left;
                }
            }else{
                // ��ǰ�ڵ�Ϊ�գ�˵����߽�ѹ���ˣ��򵯳��ڵ㣨�У����ٴ����ұ߽�
                head = stack.pop();  // ��
                // �ж�ǰһ�����Ƿ�С�ڶ�����
                if(pre > head.val){
                    return false;
                }
                pre = head.val;
                head = head.right;   // ��
            }
        }
        return true;
    }
}
