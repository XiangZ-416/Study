package 容器类;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 测试List中的基本方法
 * @author nlpzhengxiang
 */
public class Code_00_TestListMethod {
	public  static void main(String[] args) {
		List list = new ArrayList();
		
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);	//包装类，自动装箱
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.remove(1);    //hashcode和equals
		System.out.println(list.size());
		
		
		String str = (String) list.get(0);
		System.out.println(str);
		list.set(0, "bbb");
		System.out.println(list.get(0));
	}
}

class Dog {

}
