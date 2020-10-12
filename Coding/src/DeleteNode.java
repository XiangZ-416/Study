import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/8/6 22:22
 */
public class DeleteNode {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * ֻ������ɾ���ڵ㣬Ҫ���� O(1)ʱ����ɾ��
     *
     * @param toDelete
     * @return
     */
    public void deleteSpecNode(ListNode toDelete) {
        if (toDelete.next == null) {
            // ����ɾ��β���
            throw new RuntimeException("β����޷�ɾ��");
        }
        toDelete.val = toDelete.next.val;
        toDelete.next = toDelete.next.next;
    }

    /**
     * ������ɾ���ڵ�� ͷ���
     * Ҫ���� O(1)ʱ����ɾ��
     * <p>
     * �����ɾ���ڵ���ͷ��㣬ֱ�ӷ��� head.next
     * �����ɾ���ڵ㲻��β��㣬�������O(1)ʱ����ɾ��
     * ��β��㣬�����ͷ�������ҵ� �����ڶ����ڵ�,�����̽ڵ���Ϊ  null
     *
     * @param head
     * @param toDelete
     * @return
     */
    public ListNode deleteSpecNode(ListNode head, ListNode toDelete) {
        if (head == null) return null;
        if (head == toDelete) return head.next; // head = toDelete ����������⴦��(�������������ֻ��һ���ڵ�/����ڵ�)

        if (toDelete.next != null) {
            // ��β���
            toDelete.val = toDelete.next.val;
            toDelete.next = toDelete.next.next;
        } else {

            ListNode prev = head;
            while (prev != null && prev.next != toDelete) {
                prev = prev.next;
            }
            if (prev == null) {
                throw new RuntimeException("δ�ҵ���ɾ���ڵ�");
            }
            prev.next = null;
        }
        return head;
    }


    /**
     * ɾ����������������ֵ���� val �Ľڵ�
     * ͷ�����ܻᱻɾ��
     * <p>
     * ʱ�临�Ӷ�: O(n)
     * �ռ临�Ӷ�: O(1)
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteSpecNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode prev = null, cur = head;  //prev Ϊ��һ�������� val ֵ�Ľڵ�
        ListNode newHead = null;  // ���µ� newHead ��������ֹ����������Ԫ�ض���Ҫɾ��ʱ������ head ����
        while (cur != null) {
            // �ж� cur �Ƿ���� val
            if (cur.val == val) {
                // cur ��Ҫɾ��
                if (newHead != null) {
                    prev.next = cur.next;
                }
            } else {
                // cur ����
                if (newHead == null) {
                    newHead = cur;
                }
                prev = cur;
            }
            cur = cur.next;
        }
        return newHead;
    }

    /**
     * ɾ������������ظ��ڵ㣨�ظ��ڵ�ֻ����һ����
     * Ҫ��ռ临�Ӷ� O(1)
     * ͷ��㲻��Ҫɾ��
     * <p>
     * �����ù�ϣ��ֻ��˫��ѭ����
     * ʱ�临�Ӷ�:O(n^2)
     *
     * @param head
     * @return
     */
    public ListNode deleteDupNode0(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode first = head, second = head.next;
        while (first.next != null) {
            // �� first ��Ϊ���գ�ɾ�� first �������к� first.val ��ͬ�Ľڵ�
            prev = first;
            second = first.next;
            while (second != null) {
                if (second.val == first.val) {
                    // ��Ҫɾ��
                    prev.next = second.next;
                } else {
                    prev = second;
                }
                second = second.next;
            }
            first = first.next;
        }
        return head;
    }

    /**
     * ɾ�����������е��ظ��ڵ㣨�ظ��ڵ�ֻ������һ����
     * ͷ���һ���ᱣ�����������ظ��ڵ㣬Ҳ��Ҫ����һ����
     * ����жϵ�ǰ�ڵ��Ƿ����ظ����ֵ��أ�hash ��
     * ʱ�临�Ӷ�:O(n)
     * �ռ临�Ӷ�:O(n)
     *
     * @param head
     * @return
     */
    public ListNode deleteDupNode1(ListNode head) {
        if (head == null || head.next == null) return head;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(head.val);
        ListNode prev = head, cur = head.next; // prev ָ��ǰ�������������ڵ�
        while (cur != null) {
            if (hashSet.contains(cur.val)) {
                // ��ǰ�ڵ�Ҫɾ��
                prev.next = cur.next;
            } else {
                hashSet.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    /**
     * ɾ�����������е������ظ��ڵ㣨�ظ��ڵ㲻������
     * ͷ�����ܻᱻɾ������������ظ��ڵ�Ļ���
     * <p>
     * Ҫ��ռ临�Ӷ�: O(1)
     * <p>
     * ʱ�临�Ӷ�: O(n^2)
     *
     * @param head
     * @return
     */
    public ListNode deleteDupNode2(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode first = head, second = head.next;
        ListNode newHead = null;
        ListNode prev = null;

        // Ϊ���ܱ�֤��֤ÿ���ڵ��Ƿ����ظ��ڵ㣬�����ƻ�ԭ����Ľṹ������

        while (first != null) {
            // �ж� first �Ƿ����ظ��ڵ�
            // ע������second �����ͷ���head��ʼ�����������Ǵ� first /newHead ֮�����
            second = head;
            while (second != null) {
                if (second != first && second.val == first.val) {
                    break;
                }
                second = second.next;
            }
            if (second == null) {
                // first �Ƿ��ظ��ڵ�
                if (newHead != null) {
                    // �Ѿ���ͷ�����
                    prev.next = new ListNode(first.val);
                    prev = prev.next;
                } else {
                    // �µ�ͷ���
                    newHead = new ListNode(first.val);
                    prev = newHead;
                }
            }
            first = first.next;
        }
        return newHead;
    }


    /**
     * ɾ�����������е������ظ��ڵ㣨�ظ��ڵ㲻������
     * ͷ�����ܻᱻɾ������������ظ��ڵ�Ļ���
     * ���ڱ�����һ���ڵ㣬�޷��жϸýڵ��Ƿ���Ҫɾ����������Ҫ�ȱ���һ�� hashMap ͳ��ÿ����ֵ��Ӧ�Ľڵ����
     * ���±���һ�Σ���ĳ����ֵ��Ӧ�Ľڵ��������1 ��ʾ��ǰ�ڵ���Ҫɾ��
     * <p>
     * ʱ�临�Ӷ�:O(n) 2n
     * �ռ临�Ӷ�:O(n)
     *
     * @param head
     * @return
     */
    public ListNode deleteDupNode3(ListNode head) {
        if (head == null || head.next == null) return head;
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
//          map.put(cur.val,map.getOrDefault(cur.val,0)+1);// �ۼ�+1
            map.merge(cur.val, 1, Integer::sum); //������д����ȡ�� map �ж�Ӧ�� cur.val��ֵcount��û����Ϊ0; �ٺ� 1��Ӵ���
            cur = cur.next;
        }

        ListNode prev = null;
        cur = head.next;
        while (cur != null) {
            if (map.get(cur.val) > 1) {
                if (prev != null) {
                    // ��ǰ�ڵ���Ҫɾ��
                    prev.next = cur.next;
                }
            } else {
                // ��ǰ�ڵ㱣��
                if (prev == null) {
                    head = cur;
                }
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    /**
     * ɾ�����������е��ظ��ڵ㣨�ظ��ڵ�ֻ����һ����
     * ͷ������ֱ�ӱ���
     * <p>
     * ʱ�临�Ӷ�:O(n)
     * �ռ临�Ӷ�:O(1)
     *
     * @param head
     * @return
     */
    public ListNode deleteSortedDupNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head, cur = head.next;

        while (cur != null) {
            // �ж� cur �Ƿ����ظ��ڵ�
            if (cur.val == prev.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        // ���ﲻ��Ҫ���ֶ��Ͽ� prev ����Ϊprev.next = cur.next ֱ�ӽ��ظ��ڵ� cur ɾ����
        return head;
    }

    /**
     * ɾ�����������е������ظ��ڵ㣨�ظ��ڵ㲻������
     * ͷ��������Ҫɾ��
     *
     * @param head
     * @return
     */
    public ListNode deleteSortedDupNode2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, newHead = null;
        ListNode cur = head, follow = null;

        while (cur != null) {
            // �ж� cur �Ƿ����ظ��ڵ�
            follow = cur.next;
            while (follow != null && follow.val == cur.val) {
                follow = follow.next;
            }
            // follow Ҫôָ���һ�������� cur �Ľڵ�, Ҫô���� null

            if (cur.next == follow) {
                // ˵�� cur �����ظ��ڵ�(���� follow�Ƿ�Ϊ null)
                if (newHead == null) {
                    newHead = cur;
                } else {
                    prev.next = cur;
                }
                prev = cur;
            }
            cur = follow; // �����ж���һ���ڵ��Ƿ����ظ��ڵ�
        }
        // �����漰���Ŀ�������Ҫһ��ɾ������ظ��ڵ㣬û�н���ɾ��������prev.next= follow��
        // �����ҵ�һ�����ظ��ڵ�����ӵ� prev �� prev.next= cur
        // �������һ���������������� prevָ�����һ�����ظ��ڵ�
        // ���prev ԭ�����ӵĺ���Ľڵ����ظ��ڵ�ʱ����û�жϿ���prev������. ���������������ֶ��Ͽ�
        if (prev != null) {  // ʾ�� 1 2 2
            prev.next = null;
        }
        return newHead;
    }

    // ��һ��д���������д����ʵ����Чһ�㣨���д����ظ��ڵ�ʱ��
    public ListNode deleteSortedDupNode2Another(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, newHead = null;
        ListNode cur = head, follow = null;

        while (cur != null) {
            // �ж� cur �Ƿ����ظ��ڵ�
            follow = cur.next;
            while (follow != null && follow.val == cur.val) {
                follow = follow.next;
            }
            // follow Ҫôָ���һ�������� cur �Ľڵ�, Ҫô���� null

            if (cur.next == follow) {
                // ˵�� cur �����ظ��ڵ�(���� follow�Ƿ�Ϊ null)
                if (newHead == null) {
                    newHead = cur;
                } else {
                    prev.next = cur;
                }
                prev = cur;
            } else {
                // cur ���ظ��ڵ�
                if (prev != null) {
                    prev.next = follow; // ɾ���м����е��ظ��ڵ㣬���ӵ���һ���ȽϵĽڵ�
                }
            }
            cur = follow; // �����ж���һ���ڵ��Ƿ����ظ��ڵ�
        }
        return newHead;
    }


    @Test
    public void test() {
        ListNode a0 = new ListNode(0);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(0);
        ListNode a3 = new ListNode(0);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(0);
        ListNode a6 = new ListNode(0);
        ListNode a7 = new ListNode(5);

        a0.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;

        print(deleteSpecNode(a0, 0));

    }

    public static void print(ListNode node) {
        if (node == null) {
            System.out.println("����Ϊ��");
            return;
        }
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
        System.out.println();
    }

}
