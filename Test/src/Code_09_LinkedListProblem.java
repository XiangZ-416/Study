import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @Description: //TODO 链表问题
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/6/11 22:06
 */
public class Code_09_LinkedListProblem {

    /**
     * @Description //TODO 含有随机指针的链表
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
     * @Description //TODO 单向链表的反转
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
     * @Description //TODO 双向链表的反转
     * @Author ZX
     * @Date 10:52 2020/6/13
     **/
    public static class doublyLinkedListReversal {
        public static node reverseProcess(node head) {

            return null;
        }
    }

    /**
     * @Description //TODO 打印两个有序链表的公共部分
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
     * @Description //TODO 判断链表是否是回文结构
     * @Author ZX
     * @Date 10:50 2020/6/15
     **/
    public static class isPalindrome {
        // 用栈
        public static boolean palindromeWithStack(node head) {

            boolean result = true;
            // 链表反转
            node Cur = head;
            Stack<node> stack = new Stack<>();
            while (Cur != null) {
                stack.push(Cur);
                Cur = Cur.next;
            }

            // 判断是否回文
            while (!stack.isEmpty() && head != null) {
                if (stack.pop().val != head.val) {
                    result = false;
                }
                head = head.next;
            }

            return result;
        }

        // 不用栈
        public static boolean palindromeNotStack(node head) {

            boolean result = true;

            // base case
            if (head == null || head.next ==null) {
                return result;
            }

            node slow = head;
            node fast = head;
            // 慢指针依次走一步，快指针一次走两步
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 此时slow在原链表中间位置，fast在原链表末尾
            // 反转slow和fast之间的链表
            node pre = null;
            node next = null;
            while (slow != null) {
                next = slow.next;
                slow.next = pre;
                pre = slow;
                slow = next;
            }
            // 此时原链表的后半段是一个独立的链表，头节点是pre。逐个比较head为头节点的链表、pre为头节点的链表
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
     * @Description //TODO 将链表按某个数调整为小于、等于、大于三个区域
     * @Author ZX
     * @Date 21:03 2020/6/15
     **/
    public static class LinkedListPartition {
        public static node listPartition(node head, int num) {
            // base case
            if (head == null || head.next == null) {
                return head;
            }

            // 获取所需数组的大小
            int arrSize = 0;
            node Cur = head;
            while (Cur != null) {
                arrSize++;
                Cur = Cur.next;
            }

            // 将链表各个节点存在数组中
            node[] arr = new node[arrSize];
            int i = 0;
            while (head != null) {
                arr[i] = head;
                head = head.next;
                i++;
            }

            // 将数组中的节点按照num划分为3部分
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

            // 将数组中的节点串成链表
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
     * @Description //TODO 复制含有随机指针的链表
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
            // 复制主节点
            while (cur != null) {
                randomNode copyRandomNode = new randomNode(cur.value);
                map.put(cur, copyRandomNode);
                cur = cur.next;
            }
            cur = head;
            // 复制主节点的next、rand
            while (cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).rand = map.get(cur.rand);
                cur = cur.next;
            }
            return map.get(head);

        }
    }

    /**
     * @Description //TODO 两个单链表相交的一系列问题
     *                          先判断两个链表各自是否有环
     *                              有环链表和无环链表的相交问题
     *                              两个无环链表的相交问题
     *                              两个有环链表的相交问题
     * @Author ZX
     * @Date 20:44 2020/6/17
     **/
    public static class judgeTwoLinkedListIsAcross {

        /**
         * @Description //TODO 判断两个有环链表是否相交；若相交，返回第一个相交的节点
         * @Author ZX
         * @Date 22:41 2020/6/17
         **/
        public static node judgeLoopLinkedListIsAcross(node head1, node head2) {

            node loop1 = judgeLinkedListIsLoop(head1); // head1链表的第一个入环节点
            node loop2 = judgeLinkedListIsLoop(head2); // head2链表的第一个入环节点

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
         * @Description //TODO 判断两个无环链表是否相交；若相交，返回第一个相交的节点
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

            int len1 = 0, len2 = 0; // 初始化两个链表的长度
            node cur1 = head1, cur2 = head2;
            while (cur1 != null) {
                len1++;
                cur1 = cur1.next;
            }
            while (cur2 != null) {
                len2++;
                cur2 = cur2.next;
            }
            // 此时已知两个链表各自的长度，以及尾节点
            if (cur1 != cur2) { // 两个无环链表的尾节点不一样，则两个链表必定不相交
                return null;
            }
            // 如果两个无环链表的尾节点一样，则必定相交
            // 此时让长度较长的链表先走 |len1 - len2|步，然后两个链表一起走，第一个相遇的节点就是第一个相交的节点
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
         * @Description //TODO 判断一个链表是否有环，如果有，返回第一个入环的节点
         * @Author ZX
         * @Date 21:46 2020/6/17
         **/
        public static node judgeLinkedListIsLoop(node head) {
            // base case
            if (head == null || head.next == null || head.next.next == null) { // 小于等于三个节点的链表不可能成环
                return null;
            }
// 不用辅助空间
//            node slow = head.next; // 快指针
//            node fast = head.next.next; // 快指针
//            while (slow != fast) {
//                if (slow.next == null || fast.next.next == null) { // 如果fast为空则无环
//                    return null;
//                }
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//            // 此时slow已经和fast相遇，则此链表必定有环
//            // 下面找出第一个入环的节点
//            fast = head; // 快指针回到头节点
//            while (slow != fast) {
//                slow = slow.next;
//                fast = fast.next;
//            }
//            return slow;

// 用辅助空间
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

//        System.out.println("单链表反转");
//        node reversalHead = singlyLinkedListReversal.reverseProcess(head);
//
//        while ( reversalHead != null) {
//            System.out.print(reversalHead.val + " ");
//            reversalHead = reversalHead.next;
//        }
//
//        System.out.println();
//        System.out.println("============");
//        System.out.println("打印两个有序链表的公共部分");
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
//        System.out.println("利用栈判断链表是否是回文结构");
//        System.out.println(isPalindrome.palindromeWithStack(head));
//        System.out.println(isPalindrome.palindromeNotStack(head));

        System.out.println();
        System.out.println("============");
        System.out.println("将链表按某个数调整为小于、等于、大于三个区域");
        node newHead = LinkedListPartition.listPartition(head, 2);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

    }

}
