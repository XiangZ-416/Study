package �����㷨���װ�;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: //TODO ���������⣺����DP
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/7/1 15:21
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
     * @Description //TODO �������������������������
     * @Author ZX
     * @Date 15:36 2020/7/1
     **/
    public static class MaxSearchSubTree {

        // �ݹ����ÿ���ڵ���Ҫ���ص���Ϣ
        static class returnType {
            public int size; // ��ǰ�ڵ������������������Ĵ�С
            public Node head; // ��ǰ�ڵ�������������������ͷ��
            public int min; // ��ǰ�ڵ���������������������Сֵ
            public int max; // ��ǰ�ڵ����������������������ֵ

            public returnType(int size, Node head, int min, int max) {
                this.size = size;
                this.head = head;
                this.min = min;
                this.max = max;
            }
        }

        public static returnType process(Node head) {
            // �ݹ���ֹ����
            if (head == null) {
                return new returnType(0, null, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            // �ں�
            Node left = head.left;
            returnType leftReturnData = process(left);
            Node right = head.right;
            returnType rightReturnData = process(right);

            // ������3
            int includeItSelf = 0;
            if (leftReturnData.head == head.left
                    && rightReturnData.head == head.right
                    && head.val > leftReturnData.max
                    && head.val < rightReturnData.min) {
                includeItSelf = leftReturnData.size + 1 + rightReturnData.size;
            }
            // ������1��2
            int p1 = leftReturnData.size;
            int p2 = rightReturnData.size;

            // ��ں�
            // ���ص�ǰ�ڵ����������ĸ���Ϣ
            // ��ǰ�ڵ������������������Ĵ�СmaxSize
            int maxSize = Math.max(Math.max(p1, p2), includeItSelf);
            // ��ǰ�ڵ�������������������ͷ��maxHead
            Node maxHead = p1 > p2 ? leftReturnData.head : rightReturnData.head;
            if (maxSize == includeItSelf) {
                maxHead = head;
            }
            // ��ǰ�ڵ���������������������Сֵmin�����ֵmax
            int min = Math.min(head.val, Math.min(leftReturnData.min, rightReturnData.min));
            int max = Math.max(head.val, Math.max(leftReturnData.max, rightReturnData.max));

            return new returnType(maxSize, maxHead, min, max);
        }

    }

    /**
     * @Description //TODO �������������������������
     * @Author ZX
     * @Date 15:36 2020/7/1
     **/
    public static class MaxDistance {
        static class returnType {
            public int maxDistance; // �Ե�ǰ�ڵ�Ϊͷ�ڵ������������
            public int h; // �Ե�ǰ�ڵ�Ϊͷ�ڵ���������

            public returnType(int maxDistance, int h) {
                this.maxDistance = maxDistance;
                this.h = h;
            }
        }

        // �ݹ����
        public static returnType process(Node head) {
            if (head == null) {
                return new returnType(0, 0);
            }

            // �ں�
            returnType leftReturnData = process(head.left);
            returnType rightReturnData = process(head.right);
            // ������1
            int p1 = leftReturnData.maxDistance;
            // ������2
            int p2 = rightReturnData.maxDistance;
            // ������3
            int includeHeadDistance = leftReturnData.maxDistance + 1 + rightReturnData.maxDistance;

            // ��ں�
            // �Ե�ǰ�ڵ�Ϊͷ�ڵ������������
            int resultDistance = Math.max(Math.max(p1, p2), includeHeadDistance);
            // �Ե�ǰ�ڵ�Ϊͷ�ڵ���������
            int hitSelf = Math.max(leftReturnData.h, rightReturnData.h) + 1;
            return new returnType(resultDistance, hitSelf);
        }

        // ������
        public static int getMaxD(Node head) {
            return process(head).maxDistance;
        }

    }

    /**
     * @Description //TODO ��˾Ա���μ��������
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
            for (int i = 0; i < cur.nexts.size(); i++) { // ����cur�������ӽڵ�
                Node next = cur.nexts.get(i);
                // �ں�
                returnType nextReturnData = process(next);
                // ��ں�
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
     * @Description //TODO �ж϶������Ƿ���ƽ�������
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

        // �ݹ����
        public static returnType process(Node cur) {
            if (cur == null) {
                return new returnType(true, 0);
            }
            // �ں�
            returnType leftReturnData = process(cur.left);
            returnType rightReturnData = process(cur.right);
            // ������2
            // ���1
            if (!leftReturnData.isBalance) { // ������ƽ��
                return new returnType(false, 0);
            }
            // ���2
            if (!rightReturnData.isBalance) { // ������ƽ��
                return new returnType(false, 0);
            }
            // ���3
            if (Math.abs(leftReturnData.h - rightReturnData.h) > 1) {
                return new returnType(false, 0);
            }
            // �����ߵ�����ǿ�����1
            // ��ں�
            return new returnType(true, Math.max(leftReturnData.h, rightReturnData.h) + 1);
        }

        // ������
        public static boolean isBst(Node head) {
            return process(head).isBalance;
        }
    }

}
