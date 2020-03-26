import java.util.Stack;

/**
 * @Description: //TODO �������������ҳ����ǵĵ�һ��������㡣
 *                      ��ע����Ϊ�����������������Դ���������ݵ���ʾ����������ʽ��ʾ�ģ���֤������������ȷ�ģ�
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/24 18:16
 */
public class main37 {
    /**
     * @Author ZX
     * @Description //TODO Ϊʲô����Ҫ���ߣ������������Ȳ�һ�¿������������ڵ㣬��û�й���β�����ͻ��жϳ��ٵĵ�һ�������ڵ�
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
     * @Description //TODO �ӽڵ����Ϳ����ǵ������ʼ����ֻཻ������Y�ͣ�������X�ͣ�
     *                     �����������β����ʼ��ǰ�Ƚϣ���ô���һ����ͬ�Ľڵ���ǵ����ǵĵ�һ�������ڵ㣻
     *                     Ҫ�ȴ�β����ʼ��Ҫ����ջ�������״�ȡ�������β����
     *                     ʱ�临�Ӷȣ�O(N + M)
     * @Date 22:49 2020/3/24
     * @Param [pHead1, pHead2]
     * @return main37.ListNode
     **/
    public ListNode getIntersectionNode1(ListNode pHead1, ListNode pHead2) {
        // base case
        if (pHead1 == null || pHead2 == null)
            return null;

        Stack<ListNode> stackA = new Stack<>(); // ���pHead1����ڵ�
        Stack<ListNode> stackB = new Stack<>(); // ���pHead2����ڵ�

        while (pHead1 != null) {
            stackA.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stackB.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode ans = null; // ��һ���ཻ�Ľڵ�
        // ȡջ���ڵ㣬����ջ��Ԫ�س��β���ȵ���һ���ڵ�������������һ�������Ľڵ�
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
