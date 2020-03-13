package 容器类;

import java.util.LinkedList;

/**
 * 自定义Map的升级版
 * 1、提升查询的效率
 * 2、Map的底层实现：数组+链表（链表解决hashcode重复的问题）（即：数组里面套链表）
 * Map底层结构：其中0、1、2、3是key.hashCode()%arr.length的结果，如果两个key取余结果相同，则再后面加形成链表
 * [ 0 ]——>o——>o——>o——>o
 * [ 1 ]
 * [ 2 ]——>o
 * [ 3 ]——>o——>o
 * @author nlpzhengxiang
 *
 */
public class Code_08_SxMapSenior {
	
	LinkedList[] arr = new LinkedList[999]; //Map的底层实现：数组（+链表）
	int size;
	
	public void put(Object key, Object value) {
		SxEntry e = new SxEntry(key, value);
		
		//hashcode可能为负数
		int hash = key.hashCode();
		hash = hash<0?0-hash:hash;
		
		int a = hash%arr.length;
//		int a = key.hashCode()%arr.length; //hashcode可能为负数
		if (arr[a] == null) { //hashcode不重复，直接添加
			LinkedList list = new LinkedList(); //Map的底层实现：（数组+）链表
			arr[a] = list;
			list.add(e);
		}else { //hashcode重复，即把新的对象存到其之后
			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				SxEntry e2 = (SxEntry) list.get(i);
				if (e2.key.equals(key)) {
					e2.value = value; //键重复，值直接覆盖
				}
			}
		arr[a].add(e);			
		}
	}
	
	public Object get(Object key) {
		int a = key.hashCode()%arr.length;
		if (arr[a] != null) { 
			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				SxEntry e = (SxEntry)list.get(i);
				if (e.key.equals(key)) {
					return e.value;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Code_08_SxMapSenior m = new Code_08_SxMapSenior();
		m.put("高琪", new Wife("杨幂"));
		m.put("张三", new Wife("李四"));
		m.put("张三", new Wife("李三"));
		
		Wife w1 = (Wife)m.get("张三");
		System.out.println(w1.name);
	}
}
