import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 *（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author ZX
 * @date 2020/3/13 - 21:20
 */
public class main26 {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 方法1：利用map<RandomListNode, RandomListNode>
     *          1.pHead作为key，复制节点作为value
     *          2.设置复制链表各个节点的next和random
     * 时间复杂度：O(N)
     * 额外空间复杂度：O(N)
     * @param pHead
     * @return
     */
    public RandomListNode Clone1(RandomListNode pHead) {
        // 1.pHead作为key，复制节点作为value
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode Cur = pHead;
        while (Cur != null) {
            map.put(Cur, new RandomListNode(Cur.label));
            Cur = Cur.next;
        }

        Cur = pHead;
        // 2.设置复制链表各个节点的next和random
        while (Cur != null) {
            map.get(Cur).next = map.get(Cur.next);
            map.get(Cur).random = map.get(Cur.random);
            Cur = Cur.next;
        }
        return map.get(pHead);
    }

    /**
     * 方法2：
     * 时间复杂度：O(N)
     * 额外空间复杂度：O(1)
     * @param pHead
     * @return
     */
    public RandomListNode Clone2(RandomListNode pHead) {

        return null;
    }
}
