package 容器类;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试Set的常用方法
 * @author nlpzhengxiang
 * 无序、不可重复
 */
public class Code_04_TestSetMethod {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add("aaa");//与"aaa"重重复，加不进去
		System.out.println(set.size());
		
	}
}
