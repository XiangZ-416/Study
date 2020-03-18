import java.util.*;

/**
 * @Description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/18 22:18
 */
public class main28 {
    private static String change(char[] array) {
        StringBuilder res = new StringBuilder();
        for (char value : array) {
            res.append(value);
        }
        return res.toString();
    }
    /**
     * @Author ZX
     * @Description
     * 实现递归函数Process
     *       1.输入参数是字符串类型链表、字符类型数组、当前位置、字符类型数组长度
     *       2.功能是确定所有可能在index位置的字符，并与当前index位置字符交换组成一个新排列
     *       3.返回值null
     **/
    private static void Process(ArrayList<String> ans, char[] array, int cur, int length) {
        if (cur == length - 1) {
            String res = change(array); // 将字符类型数组转为字符串
            ans.add(res);
        } else {
            // 就说明现在要去确定index位置的字符
            for (int i = cur; i < length; i++) {
                // 交换index与i位置字符-->获取一个排列
                char temp = array[i];
                array[i] = array[cur];
                array[cur] = temp;
                // 当前index位置的字符已经通过交换找到了，那么就递归去找下一个位置的字符
                Process(ans, array, cur + 1, length);
                // 其实就是去为了消除当前层去递归的时候的进行交换字符的影响，
                // 如果不消除的话，那么就会造成原index位置的字符发生变化
                temp = array[i];
                array[i] = array[cur];
                array[cur] = temp;
            }
        }
    }
    /**
     * @Author ZX
     * @Description
     * 方法1：
     *      1.递归获取字符串的全排列
     *      2.去重
     *      3.按字典序排序
     * @Date 23:31 2020/3/18
     * @Param [str]
     * @return java.util.ArrayList<java.lang.String>
     **/
    public static ArrayList<String> Permutation1(String str) {
        char[] Array = str.toCharArray(); // 将字符串转化为字符类型数组
        ArrayList<String> ans = new ArrayList<>(); // 需要返回的结果
        Process(ans, Array, 0, str.length()); // 1.递归获取字符串的全排列
        ans = new ArrayList<String>(new HashSet<String>(ans)); // 2.去重操作
        Collections.sort(ans); // 3.字典排序 -> ans.sort(null);
        return ans;
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            // String类的compareTo()：按字典顺序比较两个字符串，前小后大返回负数
            return (s1 + s2).compareTo(s2 + s1);
        }
    }

    /**
     * @Author ZX
     * @Description
     * 方法2：
     *      利用比较器进行拼接后的字符串排序（输出字符串字典序最小的拼接法）
     * @Date 22:19 2020/3/18
     * @Param [str]
     * @return java.util.ArrayList<java.lang.String>
     **/
    public static ArrayList<String> Permutation2(String str) {
        // base case
        if (str == null)
            return null;

        ArrayList<String> arrayList = new ArrayList<>();

        // 挨个取出字符串中的字符存到字符串类型数组中
        String[] strs = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strs[i] = String.valueOf(str.charAt(i));
        }

        // 按照比较器排序字符串数组
        Arrays.sort(strs, new MyComparator());

        // 将排好序的字符串数组拼接起来
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }

        arrayList.add(res);

        return arrayList;
    }

    public static void main(String[] args) {
        System.out.println(Permutation1("abc").toString());
        System.out.println(Permutation2("abc").toString());
    }
}
