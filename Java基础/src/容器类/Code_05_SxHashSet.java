package ������;

import java.util.HashMap;

/**
 * �Զ����Լ���HashSet
 * @author nlpzhengxiang
 *
 */
public class Code_05_SxHashSet {
	
	HashMap map;
	private static final Object PRESSENT = new Object();//ʵ��set��map�е�valueʼ����PRESSENT�������
	
	public int size(){
		return map.size();                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	}
	
	public Code_05_SxHashSet() {
		map = new HashMap();
	}
	
	public void add(Object obj) {
		map.put(obj, PRESSENT); //Set�����ظ�����������map���������Ķ������ظ����Ѽ���Ķ�����Ϊmap�е�key
	}

	public static void main(String[] args) {
		Code_05_SxHashSet set = new Code_05_SxHashSet();
		set.add("aaa");
		set.add("aaa");
		System.out.println(set.size());
	}
}
