package ������;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * ����List�еĻ�������
 * @author nlpzhengxiang
 */
public class Code_00_TestListMethod {
	public  static void main(String[] args) {
		List list = new ArrayList();
		
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);	//��װ�࣬�Զ�װ��
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.remove(1);    //hashcode��equals
		System.out.println(list.size());
		
		
		String str = (String) list.get(0);
		System.out.println(str);
		list.set(0, "bbb");
		System.out.println(list.get(0));
	}
}

class Dog {

}
