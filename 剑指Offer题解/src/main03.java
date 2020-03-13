/**
 * ��β��ͷ��ӡ����
 */
import java.util.ArrayList;
import java.util.Stack;

class main03 {
	/**
	 * ����1������ջ
	 * �Ƚ�����Ԫ�ش���ջ�У��ٴ�ջ��ȡ��Ԫ�طŻ�ԭ����
	 * @param listNode
	 * @return
	 */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
    	// ����ջ
    	Stack<Integer> stack = new Stack<>();
    	// �������е� ֵ �浽ջ��
    	while (listNode != null) {
			stack.add(listNode.val);
			listNode = listNode.next;
		}
    	// ������������������ֵ
    	ArrayList<Integer> list = new ArrayList<>();
    	// ��ջ��Ԫ�������ŵ�������
    	while (!stack.isEmpty()) {
			list.add(stack.pop());
		}

    	return list;
    }

	/**
	 * ����2������
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		// 1����ԭ��������
		ListNode Cur = listNode;
		ListNode myNext = null;
		while (Cur != null) {
			ListNode nextTemp = Cur.next;
			Cur.next = myNext;
			myNext = Cur;
			Cur = nextTemp;
		}

		// 2�����������������ArrayList
		ArrayList list = new ArrayList();
		while (myNext != null) {
			list.add(myNext.val);
			myNext = myNext.next;
		}

		return list;
	}
    
    public static void main(String[] args) {
		//��������
    	//����ͷ�ڵ�
    	ListNode head = new ListNode(0); // �ڱ��ڵ�
    	//����β�ڵ�(��ʾ�����β��)
    	ListNode endNode = head;
    	for(int i = 1; i < 5; i++) {
    		ListNode x = new ListNode(i);
    		x.next = null;
    		endNode.next = x;
    		endNode = x;
    	}
    	
    	System.out.println("����1��" + printListFromTailToHead1(head));
		System.out.println("-----------------");
		System.out.println("����2��" + printListFromTailToHead2(head));
 	}
}
    
class ListNode {
	int val;
	ListNode next = null;
	ListNode(int val){
		this.val = val;
	}
}