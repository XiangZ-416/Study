package 左神算法初级班04;

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

        Queue<Node> queue = new LinkedList<Node>(); // 双端链表实现队列
        Boolean afterMustLeaf = false;   // 当前节点后面的节点都必须是子节点的开启标志
        Node left = null;
        Node right = null;
        queue.offer(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            // 两个标准：
            // 当开启所有子节点都必须为叶节点时，出现非叶节点，
            // 情况1：或者出现左空右不空的情况，直接返回false
            if(afterMustLeaf && (left != null || right != null)
                    || (left == null && right != null)){
                return false;
            }
            // 情况2：非左空右不空
            // <1>左右双全
            // 压入左子节点
            if(left != null){
                queue.offer(left);
            }
            // 压入右子节点
            if(right != null){
                queue.offer(right);
            }if (left == null || right == null){ // <2>有左无右<3>无左无右
                // 前面的节点都是左右双全，但是到这里少了右子节点【左子节点可能有也可能没有】，后序节点都必须为叶节点，开启标志
                afterMustLeaf = true;
            }
        }
        return true;
    }
}
