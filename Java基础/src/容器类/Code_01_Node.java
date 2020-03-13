package 容器类;

//用来表示一个节点: [previous | obj | next]
public class Code_01_Node {
	Code_01_Node previous;  //上一个节点
	Object obj;
	Code_01_Node next;	//下一个节点
	
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
