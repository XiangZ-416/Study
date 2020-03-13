import java.util.ArrayList;
/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class main17 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：两个移动节点moveNode1、moveNode2初始分别指向list1和list2的头节点，比较两个移动节点的值
     *        如果moveNode1的值 <= moveNode2的值，将moveNode1存到arrayList中，向右移动moveNode1；
     *        如果moveNode1的值 > moveNode2的值，将moveNode2存到arrayList中，向右移动moveNode2；
     * 注意：将arrayList中的节点连接起来，形成链表。因为上面只是将节点放在arrayList，仍是两个独立的链表，没有形成一个链表。
     * 时间复杂度：O(N)
     * @param list1
     * @param list2
     * @return 新链表的头节点
     */
    public static ListNode Merge1(ListNode list1, ListNode list2) {
        // base case
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ArrayList<ListNode> arrayList = new ArrayList<>();
        ListNode moveNode1 = list1; // 移动节点1
        ListNode moveNode2 = list2; // 移动节点2

        int i = 0; // 统计arrayList里一共存放的节点数
        // 双指针判断、右移、存放
        while (moveNode1 != null && moveNode2 != null) {
            if (moveNode1.val <= moveNode2.val) {
                arrayList.add(moveNode1);
                moveNode1 = moveNode1.next;
                i++;
            }else {
                arrayList.add(moveNode2);
                moveNode2 = moveNode2.next;
                i++;
            }
        }

        // list1或list2哪个没遍历完，将哪个剩余的节点全部存到arrayList中
        while (moveNode1 != null) {
            arrayList.add(moveNode1);
            moveNode1 = moveNode1.next;
        }
        while (moveNode2 != null) {
            arrayList.add(moveNode2);
            moveNode2 = moveNode2.next;
        }

        // 改变arrayList里面各个节点的索引
        for (int j = 0; j < i; j++) {
            arrayList.get(j).next = arrayList.get(j + 1);
        }

        return arrayList.get(0);
    }

    /**
     * 方法2：思路同方法1，代码优化，变量少
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge2(ListNode list1, ListNode list2) {
        // base case
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode headNode; /// 最终合成链表得头节点。
        if (list1.val > list2.val) {
            headNode = list2;
            list2 = list2.next;
        } else {
            headNode = list1;
            list1 = list1.next;
        }
        ListNode endNode = headNode; /// 其实在当前位置就是合成链表得长度为1，头节点和尾节点是一样的。

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                endNode.next = list2; /// 将合成链表的尾部节点添加链表2中当前所指向的节点
                endNode = list2; /// 去更新合成链表的尾部节点
                list2 = list2.next;
            } else {
                endNode.next = list1; /// 将合成链表的尾部节点添加链表2中当前所指向的节点
                endNode = list1; /// 去更新合成链表的尾部节点
                list1 = list1.next;
            }
        }

        /// 其实就是将剩余的链表1中的节点放入到合成链表中
        while (list1 != null) {
            endNode.next = list1;
            endNode = list1;
            list1 = list1.next;
        }
        /// 其实就是将剩余的链表2中的节点放入到合成链表中
        while (list2 != null) {
            endNode.next = list2;
            endNode = list2;
            list2 = list2.next;
        }
        return headNode;
    }

    public static void main(String[] args) {
        // list1：1->3->5
        ListNode head1 = new ListNode(1);
        ListNode end1 = head1;
        for (int i = 3; i < 6; i = i + 2) {
            ListNode newNode1 = new ListNode(i);
            newNode1.next = null;
            end1.next = newNode1;
            end1 = newNode1;
        }
        // list2：2->4->6
        ListNode head2 = new ListNode(2);
        ListNode end2 = head2;
        for (int j = 4; j < 7; j = j + 2) {
            ListNode newNode2 = new ListNode(j);
            newNode2.next = null;
            end2.next = newNode2;
            end2 = newNode2;
        }
        // 方法1
        ListNode head = Merge1(head1, head2);
        while (head != null) {
            System.out.print("\t" + head.val);
            head = head.next;
        }
        // 方法2
        ListNode Head = Merge2(head1, head2);
        while (Head != null) {
            System.out.print("\t" + Head.val);
            Head = Head.next;
        }
    }
}