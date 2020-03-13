package ������;

/**
 * �Զ���ʵ��Map�Ĺ��ܣ��˰汾Ч�ʽϵͣ�ÿ�ζ�Ҫ������
 * @author nlpzhengxiang
 *Map����ż�ֵ�ԣ����ݶ����Ҷ�Ӧֵ���󣡼������ظ���
 */
public class Code_07_SxMapJunior {
	
	SxEntry[] arr = new SxEntry[990];
	int size;
	
	public void put(Object key, Object value) {
		SxEntry e = new SxEntry(key, value);
		//�����ֵ�ظ��Ĵ�������ļ�ֱ�Ӹ���
		for (int i = 0; i < size; i++) {
			if (arr[i].key == key) {
				arr[i].value = value;
				return;
			}
		}
		arr[size++] = e;
	}
	
	public Object get(Object key) {
		for (int i = 0;i < size;i++) {
			if (arr[i].key.equals(key)) {
				return arr[i].value;
			}
		}
		return null;
	}
	
	public boolean containsKey(Object key) {
		for (int i = 0; i < size; i++) {
			if (arr[i].key.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsvalue(Object value) {
		for (int i = 0; i < size; i++) {
			if (arr[i].value.equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Code_07_SxMapJunior m = new Code_07_SxMapJunior();
		m.put("����", new Wife("����"));
		m.put("����", new Wife("����"));
		m.put("����", new Wife("����"));
		
		Wife w1 = (Wife)m.get("����");
		System.out.println(w1.name);
	}
	
}

class SxEntry {
	Object key;
	Object value;
	
	public SxEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
}
