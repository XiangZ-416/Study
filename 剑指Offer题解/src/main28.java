import java.util.*;

/**
 * @Description: //TODO 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/18 22:18
 */
public class main28 {
    private static String change(char[] strs) { // 将字符串数组转成字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (char value : strs) {
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }
    /**
     * @Author ZX
     * @Description
     * 实现递归函数Process
     *       1.输入参数是字符串类型链表、字符类型数组、当前位置、字符类型数组长度
     *       2.功能是固定第一个字符，求后面所有字符的排列
     *       3.返回值null
     **/
    public static void Process(char[] Strs, int begin, int length, ArrayList<String> Ans) {
        // base case
        if (begin == length - 1){ // 第一个字符串数组中最后一个元素时，添加此结果
            Ans.add(change(Strs));
        }else { // 求Strs的排列
            for (int i = begin; i < length; i++) { // 求所有可能出现在第i个位置的字符（把第一个字符与后面所有字符交换）
                char help = Strs[begin];
                Strs[begin] = Strs[i];
                Strs[i] = help;
                Process(Strs, begin + 1, length, Ans); // 固定第i个字符，求后面所有字符的排列
                // 回溯到父问题状态的Strs
                help = Strs[begin];
                Strs[begin] = Strs[i];
                Strs[i] = help;
            }
        }
    }
    /**
     * @Author ZX
     * @Description
     * 思路：1，2，3的全排列问题，可以看做1与23的全排列，2与13的全排列，3与21的全排列的总和。
     *      也就是我们可以把原始排列问题划分为2部分，第一部分固定，第二部分为剩余元素全排列。
     *      所以只要让第一部分不断与后面的交换元素，然后继续处理当前新组成第二部分的全排列问题即可。
     *      而我们求剩余元素的全排列的时候，又可以按下面划分为2部分继续搞，直到剩余的元素个数为1，那么当前组成一个排列。
     *      这时向上回溯即可，开始更新各个子问题的第一部分的元素，继续处理新的排列问题。
     * 方法1：
     *      1.递归获取字符串的全排列
     *      2.去重
     *      3.按字典序排序
     * @Date 23:31 2020/3/18
     * @Param [str]
     * @return java.util.ArrayList<java.lang.String>
     **/
    public static ArrayList<String> Permutation1(String str) {
        // base case
        if (str == null)
            return null;

        char[] strs = str.toCharArray(); // 将字符串转换成字符类型数组
        ArrayList<String> ans = new ArrayList<>(); // 返回结果
        Process(strs, 0, strs.length, ans); // 1.得到全排列
        ans = new ArrayList<String>(new HashSet<>(ans)); // 2.去重
        Collections.sort(ans);// 3.按字典序排序

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
//        System.out.println(Permutation2("abc").toString());
    }
}
