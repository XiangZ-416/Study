package ������;

//������ʾһ���ڵ�: [previous | obj | next]
public class Code_01_Node {
	Code_01_Node previous;  //��һ���ڵ�
	Object obj;
	Code_01_Node next;	//��һ���ڵ�
	
	public Code_01_Node() {
		
	}

	public Code_01_Node(Code_01_Node previous, Object obj, Code_01_Node next) {
		super();
		this.previous = previous;
		this.obj = obj;
		this.next = next;
	}

	public Code_01_Node getPrevious() {
		return previous;
	}

	public void setPrevious(Code_01_Node previous) {
		this.previous = previous;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Code_01_Node getNext() {
		return next;
	}

	public void setNext(Code_01_Node next) {
		this.next = next;
	}
}
