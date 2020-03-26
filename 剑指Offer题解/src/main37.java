import java.util.Stack;

/**
 * @Description: //TODO 输入两个链表，找出它们的第一个公共结点。
 *                      （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/24 18:16
 */
public class main37 {
    /**
     * @Author ZX
     * @Description //TODO 为什么长的要先走？？？？？长度不一致可能遇到公共节点，但没有公共尾部。就会判断出假的第一个公共节点
     * @Date 23:29 2020/3/24
     * @Param [pHead1, pHead2]
     * @return main37.ListNode
     **/
    public ListNode getIntersectionNode2(ListNode pHead1, ListNode pHead2) {
        // base case
        if (pHead1 == null || pHead2 == null)
            return null;

        ListNode ans = null;


        return ans;
    }

    /**
     * @Author ZX
     * @Description //TODO 从节点类型看出是单链表，故加入相交只可能是Y型，不会是X型；
     *                     从两个链表的尾部开始往前比较，那么最后一个相同的节点就是第它们的第一个公共节点；
     *                     要先从尾部开始需要借助栈，草能首次取到链表的尾部；
     *                     时间复杂度：O(N + M)
     * @Date 22:49 2020/3/24
     * @Param [pHead1, pHead2]
     * @return main37.ListNode
     **/
    public ListNode getIntersectionNode1(ListNode pHead1, ListNode pHead2) {
        // base case
        if (pHead1 == null || pHead2 == null)
            return null;

        Stack<ListNode> stackA = new Stack<>(); // 存放pHead1链表节点
        Stack<ListNode> stackB = new Stack<>(); // 存放pHead2链表节点

        while (pHead1 != null) {
            stackA.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stackB.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode ans = null; // 第一个相交的节点
        // 取栈顶节点，两个栈顶元素初次不相等的上一个节点就是两个链表第一个相遇的节点
        while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek().equals(stackB.peek())) {
            ans = stackA.pop();
            stackB.pop();
        }
        return ans;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
