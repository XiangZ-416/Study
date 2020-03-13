package 容器类;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map的基本用法
 * @author nlpzhengxiang
 * Map是一对一对存放的，Key和Value都是对象
 */
public class Code_06_TestMapMethod {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("高琪", new Wife("张曼玉"));
		map.put(new Integer(333), new Wife("杨幂"));
		
//		map.remove("高琪");   是remove不是delete
		Wife w1 = (Wife) map.get("高琪");
		System.out.println(w1.name);
		Wife w2 = (Wife)map.get(333);
		System.out.println(w2.name);
		System.out.println(map.size());
		
		System.out.println(map.containsKey("高琪"));
		System.out.println(map.containsKey("111"));
		
		System.out.println(map.containsValue(w1));
		System.out.println(map.containsValue("张曼玉"));
	}
	
}

class Wife {
	String name;
	public Wife (String name) {
		this.name = name;
	}
}
