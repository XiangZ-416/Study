package ������;

/**
 * �Լ�ʵ��һ��ArrayList,���ArrayList��ĵײ�ṹ��
 * @author nlpzhengxiang
 * �ص㣺get()��set()��remove()
 */
public class Code_03_SxLinkedList {

	private Code_01_Node first;
	private Code_01_Node last;
	
	private int size;
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			try {
				throw new Exception("����Խ�磡");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void add(Object obj) {
		Code_01_Node n = new Code_01_Node();
		if (first == null) {
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			
			first = n;
			last = n;
		}else {
			//ֱ����last�������µĽڵ�
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			
			last.setNext(n);
			
			last = n;
		}
		size++;
	}
	
	public Object get(int index) {  //2
		//����indexԽ��
		rangeCheck(index);
		//0 1 2 3 4
		//����ָ�������Ľ��
		Code_01_Node temp = search(index);
		if (temp != null) {
			return temp.obj;
		}
		return null;
	}

	public void remove(int index) {
		//����indexԽ��
		rangeCheck(index);
		//����ָ�������Ľ��
		Code_01_Node temp = search(index);
		if (temp != null) {
			Code_01_Node up = temp.previous;
			Code_01_Node down = temp.next;
			up.next = down;
			down.previous = up;
			
			size--;
		}		
	}	
	
	public void add(int index, Object obj) {
		//����ָ�������Ľ��
		Code_01_Node temp = search(index);
		
		Code_01_Node newnode = new Code_01_Node();
		newnode.obj = obj;
		
		if (temp != null) {
			Code_01_Node up = temp.previous;
			up.next = newnode;
			newnode.previous = up;
			
			newnode.next = temp;
			temp.previous = newnode;			
			
			size++;
		}
	}
	
	public Code_01_Node search(int index) {
		rangeCheck(index);
		//����ָ�������Ľ��
		Code_01_Node temp = null;
		if (first != null) {
			//��߲���Ч��
			if (index < size >> 1) {
				temp = first;
				for (int i = 0; i < index; i++) {
					temp = temp.next;
				}
			}else {
				temp = last;
				for (int i = size - 1; i > index; i--) {
					temp = temp.previous;
				}
			}

		}
		return temp;
	}
	
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		Code_03_SxLinkedList list = new Code_03_SxLinkedList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add(2, "ccc");
		System.out.println(list.get(2));
	}
}
