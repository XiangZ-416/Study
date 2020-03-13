package ������;

import java.util.LinkedList;

/**
 * �Զ���Map��������
 * 1��������ѯ��Ч��
 * 2��Map�ĵײ�ʵ�֣�����+����������hashcode�ظ������⣩��������������������
 * Map�ײ�ṹ������0��1��2��3��key.hashCode()%arr.length�Ľ�����������keyȡ������ͬ�����ٺ�����γ�����
 * [ 0 ]����>o����>o����>o����>o
 * [ 1 ]
 * [ 2 ]����>o
 * [ 3 ]����>o����>o
 * @author nlpzhengxiang
 *
 */
public class Code_08_SxMapSenior {
	
	LinkedList[] arr = new LinkedList[999]; //Map�ĵײ�ʵ�֣����飨+����
	int size;
	
	public void put(Object key, Object value) {
		SxEntry e = new SxEntry(key, value);
		
		//hashcode����Ϊ����
		int hash = key.hashCode();
		hash = hash<0?0-hash:hash;
		
		int a = hash%arr.length;
//		int a = key.hashCode()%arr.length; //hashcode����Ϊ����
		if (arr[a] == null) { //hashcode���ظ���ֱ�����
			LinkedList list = new LinkedList(); //Map�ĵײ�ʵ�֣�������+������
			arr[a] = list;
			list.add(e);
		}else { //hashcode�ظ��������µĶ���浽��֮��
			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				SxEntry e2 = (SxEntry) list.get(i);
				if (e2.key.equals(key)) {
					e2.value = value; //���ظ���ֱֵ�Ӹ���
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
		m.put("����", new Wife("����"));
		m.put("����", new Wife("����"));
		m.put("����", new Wife("����"));
		
		Wife w1 = (Wife)m.get("����");
		System.out.println(w1.name);
	}
}
