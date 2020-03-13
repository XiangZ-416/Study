/**
 * 从尾到头打印链表
 */
import java.util.ArrayList;
import java.util.Stack;

class main03 {
	/**
	 * 方法1：利用栈
	 * 先将链表元素存入栈中，再从栈中取出元素放回原链表
	 * @param listNode
	 * @return
	 */
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
    	// 创建栈
    	Stack<Integer> stack = new Stack<>();
    	// 将链表中的 值 存到栈中
    	while (listNode != null) {
			stack.add(listNode.val);
			listNode = listNode.next;
		}
    	// 创建链表对象存放输入的值
    	ArrayList<Integer> list = new ArrayList<>();
    	// 将栈顶元素逐个存放到链表中
    	while (!stack.isEmpty()) {
			list.add(stack.pop());
		}

    	return list;
    }

	/**
	 * 方法2：递推
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		// 1、将原链表逆序
		ListNode Cur = listNode;
		ListNode myNext = null;
		while (Cur != null) {
			ListNode nextTemp = Cur.next;
			Cur.next = myNext;
			myNext = Cur;
			Cur = nextTemp;
		}

		// 2、将逆序后的链表存入ArrayList
		ArrayList list = new ArrayList();
		while (myNext != null) {
			list.add(myNext.val);
			myNext = myNext.next;
		}

		return list;
	}
    
    public static void main(String[] args) {
		//创建链表
    	//创建头节点
    	ListNode head = new ListNode(0); // 哨兵节点
    	//创建尾节点(表示链表的尾部)
    	ListNode endNode = head;
    	for(int i = 1; i < 5; i++) {
    		ListNode x = new ListNode(i);
    		x.next = null;
    		endNode.next = x;
    		endNode = x;
    	}
    	
    	System.out.println("方法1：" + printListFromTailToHead1(head));
		System.out.println("-----------------");
		System.out.println("方法2：" + printListFromTailToHead2(head));
 	}
}
    
class ListNode {
	int val;
	ListNode next = null;
	ListNode(int val){
		this.val = val;
	}
}