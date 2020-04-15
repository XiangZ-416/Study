import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: //TODO �ַ����е�һ�����ظ����ַ�����ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 *                                          ���磺�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 *                                               ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 *                                      ��������������ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/13 22:14
 */
public class main55 {
    ArrayList<Character> list = new ArrayList<>();
    HashMap<Character, Integer> map1 = new HashMap<>();
    // Insert one char from stringstream
    public void Insert1(char ch) {
        list.add(ch);

        if (map1.containsKey(ch)) {
            map1.put(ch, map1.get(ch) + 1);
        } else {
            map1.put(ch, 1);
        }
    }
    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce1() {
        for (Character key : list) {
            if (map1.get(key) == 1) {
                return key;
            }
        }
        return '#';
    }


    // ����2������LinkedHashMap����ֱ�ӱ���LinkedHashMap����
    private Map<Character, Integer> map2 = new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert2(char ch) {
        if (map2.containsKey(ch)) {
            map2.put(ch, map2.get(ch) + 1);
        } else {
            map2.put(ch, 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce2() {
        for (Map.Entry<Character, Integer> set : map2.entrySet()) {
            if (set.getValue() == 1) {
                return set.getKey();
            }
        }
        return '#';
    }
}
