package 容器类;

import java.util.HashMap;

/**
 * 自定义自己的HashSet
 * @author nlpzhengxiang
 *
 */
public class Code_05_SxHashSet {
	
	HashMap map;
	private static final Object PRESSENT = new Object();//实现set的map中的value始终是PRESSENT这个对象
	
	public int size(){
		return map.size();                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	}
	
	public Code_05_SxHashSet() {
		map = new HashMap();
	}
	
	public void add(Object obj) {
		map.put(obj, PRESSENT); //Set不可重复就是利用了map里面键对象的而不可重复，把加入的对象作为map中的key
	}

	public static void main(String[] args) {
		Code_05_SxHashSet set = new Code_05_SxHashSet();
		set.add("aaa");
		set.add("aaa");
		System.out.println(set.size());
	}
}
