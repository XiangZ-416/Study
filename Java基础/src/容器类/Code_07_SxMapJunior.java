package 容器类;

/**
 * 自定义实现Map的功能（此版本效率较低，每次都要遍历）
 * @author nlpzhengxiang
 *Map：存放键值对！根据对象找对应值对象！键不能重复！
 */
public class Code_07_SxMapJunior {
	
	SxEntry[] arr = new SxEntry[990];
	int size;
	
	public void put(Object key, Object value) {
		SxEntry e = new SxEntry(key, value);
		//解决键值重复的处理。后面的键直接覆盖
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
		m.put("高琪", new Wife("杨幂"));
		m.put("张三", new Wife("李四"));
		m.put("张三", new Wife("李三"));
		
		Wife w1 = (Wife)m.get("张三");
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
