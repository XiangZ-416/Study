import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: //TODO 字符流中第一个不重复的字符：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *                                          例如：当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 *                                               当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *                                      输出描述：如果当前字符流没有存在出现一次的字符，返回#字符。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/13 22:14
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


    // 方法2：利用LinkedHashMap有序，直接遍历LinkedHashMap即可
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
