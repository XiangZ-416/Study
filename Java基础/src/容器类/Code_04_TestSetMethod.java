package ������;

import java.util.HashSet;
import java.util.Set;

/**
 * ����Set�ĳ��÷���
 * @author nlpzhengxiang
 * ���򡢲����ظ�
 */
public class Code_04_TestSetMethod {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add("aaa");//��"aaa"���ظ����Ӳ���ȥ
		System.out.println(set.size());
		
	}
}
