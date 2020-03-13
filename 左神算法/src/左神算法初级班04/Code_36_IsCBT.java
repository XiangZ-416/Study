package �����㷨������04;

import java.util.LinkedList;
import java.util.Queue;

public class Code_36_IsCBT {
    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public Boolean isCompleteBT(Node head){
        if(head == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<Node>(); // ˫������ʵ�ֶ���
        Boolean afterMustLeaf = false;   // ��ǰ�ڵ����Ľڵ㶼�������ӽڵ�Ŀ�����־
        Node left = null;
        Node right = null;
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            // ������׼��
            // �����������ӽڵ㶼����ΪҶ�ڵ�ʱ�����ַ�Ҷ�ڵ㣬
            // ���1�����߳�������Ҳ��յ������ֱ�ӷ���false
            if(afterMustLeaf && (left != null || right != null)
                    || (left == null && right != null)){
                return false;
            }
            // ���2��������Ҳ���
            // <1>����˫ȫ
            // ѹ�����ӽڵ�
            if(left != null){
                queue.offer(left);
            }
            // ѹ�����ӽڵ�
            if(right != null){
                queue.offer(right);
            }if (left == null || right == null){ // <2>��������<3>��������
                // ǰ��Ľڵ㶼������˫ȫ�����ǵ������������ӽڵ㡾���ӽڵ������Ҳ����û�С�������ڵ㶼����ΪҶ�ڵ㣬������־
                afterMustLeaf = true;
            }
        }
        return true;
    }
}
