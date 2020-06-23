import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @Description: //TODO ��������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/11 22:06
 */
public class Code_09_LinkedListProblem {

    /**
     * @Description //TODO �������ָ�������
     * @Author ZX
     * @Date 16:29 2020/6/16
     **/
    public static class randomNode {
        public int value;
        public randomNode next;
        public randomNode rand;
        public randomNode(int data) {
            this.value = data;
        }
    }

    public static class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    /**
     * @Description //TODO ��������ķ�ת
     * @Author ZX
     * @Date 10:51 2020/6/13
     **/
    public static class singlyLinkedListReversal {
        public static node reverseProcess(node head) {
            node pre = null;
            node next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    /**
     * @Description //TODO ˫������ķ�ת
     * @Author ZX
     * @Date 10:52 2020/6/13
     **/
    public static class doublyLinkedListReversal {
        public static node reverseProcess(node head) {

            return null;
        }
    }

    /**
     * @Description //TODO ��ӡ������������Ĺ�������
     * @Author ZX
     * @Date 10:44 2020/6/15
     **/
    public static class printCommonPart {
        public static void printProcess(node head1, node head2) {
            // base case
            if (head1 == null || head2 == null) {
                return;
            }

            while (head1 != null && head2 != null) {
                if (head1 == head2) {
                    System.out.print(head1.val + " ");
                }
                head1 = head1.next;
                head2 = head2.next;
            }

        }
    }

    /**
     * @Description //TODO �ж������Ƿ��ǻ��Ľṹ
     * @Author ZX
     * @Date 10:50 2020/6/15
     **/
    public static class isPalindrome {
        // ��ջ
        public static boolean palindromeWithStack(node head) {

            boolean result = true;
            // ����ת
            node Cur = head;
            Stack<node> stack = new Stack<>();
            while (Cur != null) {
                stack.push(Cur);
                Cur = Cur.next;
            }

            // �ж��Ƿ����
            while (!stack.isEmpty() && head != null) {
                if (stack.pop().val != head.val) {
                    result = false;
                }
                head = head.next;
            }

            return result;
        }

        // ����ջ
        public static boolean palindromeNotStack(node head) {

            boolean result = true;

            // base case
            if (head == null || head.next ==null) {
                return result;
            }

            node slow = head;
            node fast = head;
            // ��ָ��������һ������ָ��һ��������
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // ��ʱslow��ԭ�����м�λ�ã�fast��ԭ����ĩβ
            // ��תslow��fast֮�������
            node pre = null;
            node next = null;
            while (slow != null) {
                next = slow.next;
                slow.next = pre;
                pre = slow;
                slow = next;
            }
            // ��ʱԭ����ĺ�����һ������������ͷ�ڵ���pre������Ƚ�headΪͷ�ڵ������preΪͷ�ڵ������
            while (head != null && pre != null) {
                if (head.val != pre.val) {
                    result = false;
                    break;
                }
                head = head.next;
                pre = pre.next;
            }

            return result;
        }

    }

    /**
     * @Description //TODO ������ĳ��������ΪС�ڡ����ڡ�������������
     * @Author ZX
     * @Date 21:03 2020/6/15
     **/
    public static class LinkedListPartition {
        public static node listPartition(node head, int num) {
            // base case
            if (head == null || head.next == null) {
                return head;
            }

            // ��ȡ��������Ĵ�С
            int arrSize = 0;
            node Cur = head;
            while (Cur != null) {
                arrSize++;
                Cur = Cur.next;
            }

            // ����������ڵ����������
            node[] arr = new node[arrSize];
            int i = 0;
            while (head != null) {
                arr[i] = head;
                head = head.next;
                i++;
            }

            // �������еĽڵ㰴��num����Ϊ3����
            int less = -1, more = arr.length, cur = 0;
            while (cur < more) {
                if (arr[cur].val < num) {
                    swap(arr, less + 1, cur);
                    less++;
                    cur++;
                } else if (arr[cur].val == num) {
                    cur++;
                } else {
                    swap(arr, more - 1, cur);
                    more--;
                }
            }

            // �������еĽڵ㴮������
            node newHead = arr[0];
            node curNode = newHead;
            for (i = 1; i < arr.length; i++) {
                curNode.next = arr[i];
                curNode = curNode.next;
            }

            return newHead;
        }

        private static void swap(node[] arr, int i, int j) {
            node help = arr[i];
            arr[i] = arr[j];
            arr[j] = help;
        }
    }

    /**
     * @Description //TODO ���ƺ������ָ�������
     * @Author ZX
     * @Date 16:26 2020/6/16
     **/
    public static class copyListWithRandom {
        public static randomNode copyProcess(randomNode head) {
            // base case
            if (head == null) {
                return null;
            }

            HashMap<randomNode, randomNode> map = new HashMap<>();
            randomNode cur = head;
            // �������ڵ�
            while (cur != null) {
                randomNode copyRandomNode = new randomNode(cur.value);
                map.put(cur, copyRandomNode);
                cur = cur.next;
            }
            cur = head;
            // �������ڵ��next��rand
            while (cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).rand = map.get(cur.rand);
                cur = cur.next;
            }
            return map.get(head);

        }
    }

    /**
     * @Description //TODO �����������ཻ��һϵ������
     *                          ���ж�������������Ƿ��л�
     *                              �л�������޻�������ཻ����
     *                              �����޻�������ཻ����
     *                              �����л�������ཻ����
     * @Author ZX
     * @Date 20:44 2020/6/17
     **/
    public static class judgeTwoLinkedListIsAcross {

        /**
         * @Description //TODO �ж������л������Ƿ��ཻ�����ཻ�����ص�һ���ཻ�Ľڵ�
         * @Author ZX
         * @Date 22:41 2020/6/17
         **/
        public static node judgeLoopLinkedListIsAcross(node head1, node head2) {

            node loop1 = judgeLinkedListIsLoop(head1); // head1����ĵ�һ���뻷�ڵ�
            node loop2 = judgeLinkedListIsLoop(head2); // head2����ĵ�һ���뻷�ڵ�

            if (loop1 == loop2) {
                int len1 = 0, len2 = 0;
                node cur1 = head1, cur2 = head2;
                while (cur1 != loop1) {
                    len1++;
                    cur1 = cur1.next;
                }
                while (cur2 != loop2) {
                    len2++;
                    cur2 = cur2.next;
                }
                cur1 = head1;
                cur2 = head2;
                int Len = len1 - len2;
                if (Len <= 0) {
                    while (Len > 0) {
                        cur2 = cur2.next;
                        Len--;
                    }
                } else {
                    while (Len > 0) {
                        cur1 = cur1.next;
                        Len--;
                    }
                }
                while (cur1 != cur2) {
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }

                return cur1;
            } else {
                while (head1 != null && head2 != null) {
                    if (head1 == head2) {
                        return head1;
                    }
                    head1 = head1.next;
                    head2 = head2.next;
                }
                return null;
            }

        }

        /**
         * @Description //TODO �ж������޻������Ƿ��ཻ�����ཻ�����ص�һ���ཻ�Ľڵ�
         * @Author ZX
         * @Date 22:18 2020/6/17
         **/
        public static node judgeNoLoopLinkedListIsAcross(node head1, node head2) {
            // base case
            if ( (head1 == null || head2 == null)
                    || (head1 == null && head2 != null)
                    || (head1 != null && head2 == null) ) {
                return null;
            }

            int len1 = 0, len2 = 0; // ��ʼ����������ĳ���
            node cur1 = head1, cur2 = head2;
            while (cur1 != null) {
                len1++;
                cur1 = cur1.next;
            }
            while (cur2 != null) {
                len2++;
                cur2 = cur2.next;
            }
            // ��ʱ��֪����������Եĳ��ȣ��Լ�β�ڵ�
            if (cur1 != cur2) { // �����޻������β�ڵ㲻һ��������������ض����ཻ
                return null;
            }
            // ��������޻������β�ڵ�һ������ض��ཻ
            // ��ʱ�ó��Ƚϳ����������� |len1 - len2|����Ȼ����������һ���ߣ���һ�������Ľڵ���ǵ�һ���ཻ�Ľڵ�
            cur1 = head1;
            cur2 = head2;
            int Len = len1 - len2;
            if (Len <= 0) {
                while (Len > 0) {
                    cur2 = cur2.next;
                    Len--;
                }
            } else {
                while (Len > 0) {
                    cur1 = cur1.next;
                    Len--;
                }
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }

        /**
         * @Description //TODO �ж�һ�������Ƿ��л�������У����ص�һ���뻷�Ľڵ�
         * @Author ZX
         * @Date 21:46 2020/6/17
         **/
        public static node judgeLinkedListIsLoop(node head) {
            // base case
            if (head == null || head.next == null || head.next.next == null) { // С�ڵ��������ڵ���������ܳɻ�
                return null;
            }
// ���ø����ռ�
//            node slow = head.next; // ��ָ��
//            node fast = head.next.next; // ��ָ��
//            while (slow != fast) {
//                if (slow.next == null || fast.next.next == null) { // ���fastΪ�����޻�
//                    return null;
//                }
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//            // ��ʱslow�Ѿ���fast�������������ض��л�
//            // �����ҳ���һ���뻷�Ľڵ�
//            fast = head; // ��ָ��ص�ͷ�ڵ�
//            while (slow != fast) {
//                slow = slow.next;
//                fast = fast.next;
//            }
//            return slow;

// �ø����ռ�
            HashSet<node> set = new HashSet<>();
            node cur = head;
            while (cur != null) {
                if (set.contains(cur)) {
                    return cur;
                }
                set.add(cur);
                cur = cur.next;
            }
            return null;
        }

    }

    public static void main(String[] args) {
        node head = new node(1);
        head.next = new node(2);
        head.next.next = new node(1);
        head.next.next.next = new node(3);

//        System.out.println("������ת");
//        node reversalHead = singlyLinkedListReversal.reverseProcess(head);
//
//        while ( reversalHead != null) {
//            System.out.print(reversalHead.val + " ");
//            reversalHead = reversalHead.next;
//        }
//
//        System.out.println();
//        System.out.println("============");
//        System.out.println("��ӡ������������Ĺ�������");
//
//        node head1 = new node(1);
//        head1.next = new node(2);
//        head1.next.next = new node(3);
//        node head2 = new node(1);
//        head2.next = new node(2);
//        printCommonPart.printProcess(head1, head2);
//
//        System.out.println();
//        System.out.println("============");
//        System.out.println("����ջ�ж������Ƿ��ǻ��Ľṹ");
//        System.out.println(isPalindrome.palindromeWithStack(head));
//        System.out.println(isPalindrome.palindromeNotStack(head));

        System.out.println();
        System.out.println("============");
        System.out.println("������ĳ��������ΪС�ڡ����ڡ�������������");
        node newHead = LinkedListPartition.listPartition(head, 2);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

    }

}
