import java.util.HashMap;
import java.util.Map;

/**
 * ��Ŀ����
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬
 * ��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
 *��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
     * ����1������map<RandomListNode, RandomListNode>
     *          1.pHead��Ϊkey�����ƽڵ���Ϊvalue
     *          2.���ø�����������ڵ��next��random
     * ʱ�临�Ӷȣ�O(N)
     * ����ռ临�Ӷȣ�O(N)
     * @param pHead
     * @return
     */
    public RandomListNode Clone1(RandomListNode pHead) {
        // 1.pHead��Ϊkey�����ƽڵ���Ϊvalue
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode Cur = pHead;
        while (Cur != null) {
            map.put(Cur, new RandomListNode(Cur.label));
            Cur = Cur.next;
        }

        Cur = pHead;
        // 2.���ø�����������ڵ��next��random
        while (Cur != null) {
            map.get(Cur).next = map.get(Cur.next);
            map.get(Cur).random = map.get(Cur.random);
            Cur = Cur.next;
        }
        return map.get(pHead);
    }

    /**
     * ����2��
     * ʱ�临�Ӷȣ�O(N)
     * ����ռ临�Ӷȣ�O(1)
     * @param pHead
     * @return
     */
    public RandomListNode Clone2(RandomListNode pHead) {

        return null;
    }
}
