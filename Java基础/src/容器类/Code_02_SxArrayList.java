package 容器类;

/**
 * 自己实现一个ArrayList,理解ArrayList类的底层结构！
 * @author nlpzhengxiang
 * 重点：get()、set()、remove()
 */
public class Code_02_SxArrayList {
	
	private Object[] elementData;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Code_02_SxArrayList() {
		this(10);//数组长度默认为10
	}
	
	public Code_02_SxArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			try {
				throw new Exception("List非法");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		elementData = new Object[initialCapacity];
	}
	
	public void rangeCheck (int index) {
		if (index < 0 || index >= size) {
			try {
				throw new Exception("超出索引位置！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void ensureCapacity() {
		//数组扩容
		if (size == elementData.length) {
			Object[] newArray = new Object[size*2+1];//数组扩容
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
	}

	public void add(Object obj) {	
		ensureCapacity();
		elementData[size++]=obj;
	}
	
	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}
	
	public void remove(int index) {
		//删除指定位置对象
		//a b c d e
		rangeCheck(index);
		
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
			elementData[--size] = null;
		}
	}
	
	public void remove (Object  obj) {
		for (int index = 0; index < size; index++) {
			if (get(index).equals(obj)) { //注意底层调用的是equals而不是==
				remove(index);
			}
		}
	}
	
	public Object set(int index, Object obj) {
		rangeCheck(index);
		Object oldvalue = elementData[index];
		elementData[index] = obj;
		 
		return oldvalue;
	}
	
	public void add(int index, Object obj) {
		ensureCapacity();
		
		rangeCheck(index);
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = obj;
		size++;
	}

	public static void main(String[] args) {
		Code_02_SxArrayList list = new Code_02_SxArrayList();
		list.add("333");
		list.add("444");
		list.add("5");
		list.add("333");
		list.add("333");
		list.add("333");
		System.out.println(list.size);
		System.out.println(list.get(0));
		System.out.println(list.get(6));
		list.remove(0);
		System.out.println(list.get(0));
		list.set(0, "aaa");
		System.out.println(list.get(0));
		list.add(2, "4");
		System.out.println(list.get(2));
	}
}

