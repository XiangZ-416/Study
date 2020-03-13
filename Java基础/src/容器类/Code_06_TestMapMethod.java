package ������;

import java.util.HashMap;
import java.util.Map;

/**
 * ����Map�Ļ����÷�
 * @author nlpzhengxiang
 * Map��һ��һ�Դ�ŵģ�Key��Value���Ƕ���
 */
public class Code_06_TestMapMethod {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("����", new Wife("������"));
		map.put(new Integer(333), new Wife("����"));
		
//		map.remove("����");   ��remove����delete
		Wife w1 = (Wife) map.get("����");
		System.out.println(w1.name);
		Wife w2 = (Wife)map.get(333);
		System.out.println(w2.name);
		System.out.println(map.size());
		
		System.out.println(map.containsKey("����"));
		System.out.println(map.containsKey("111"));
		
		System.out.println(map.containsValue(w1));
		System.out.println(map.containsValue("������"));
	}
	
}

class Wife {
	String name;
	public Wife (String name) {
		this.name = name;
	}
}
