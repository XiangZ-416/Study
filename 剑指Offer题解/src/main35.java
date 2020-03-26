import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description: //TODO ��Ŀ���� ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��,
 *                              ���û���򷵻� -1����Ҫ���ִ�Сд��.
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/23 21:11
 */
public class main35 {
    /**
     * @Author ZX
     * @Description //TODO ������������Ƚ�iλ�ô����ַ��Ƿ���i֮ǰ��֮����ֹ�
     *                          ʱ�临�Ӷȣ�O(N^2)
     * @Date 22:24 2020/3/23
     * @Param [str]
     * @return int
     **/
    public static int FirstNotRepeatingChar1(String str) {
        // base case
        if (str == null || str.length() == 0)
            return -1;

        int ans = -1;
        ArrayList<Character> behind = new ArrayList<>();
        ArrayList<Character> before = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            int j = i + 1;
            while (j < str.length()) {
                behind.add(str.charAt(j));
                j++;
            }
            int h = i - 1;
            while (h >= 0 && h < i) {
                before.add(str.charAt(h));
                h++;
            }
            if (!before.contains(temp) && !behind.contains(temp))
                return ans = i;
            behind.clear();
        }
        return ans;
    }

    /**
     * @Author ZX
     * @Description //TODO ���ù�ϣ��Key���ַ���Value�����ַ����ֵĴ���
     *                          ʱ�临�Ӷȣ�O(N)
     * @Date 22:27 2020/3/23
     * @Param [s]
     * @return int
     **/
    public static int FirstNotRepeatingChar2(String str) {
        // base case
        if (str == null || str.length() == 0)
            return -1;

        int ans = -1; // ��Ҫ���صĽ��
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), 0);
        }
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("����1��" + FirstNotRepeatingChar1("abaccdeff"));
        System.out.println("����2��" + FirstNotRepeatingChar2("abaccdeff"));
    }
}
