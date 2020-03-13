package 左神算法初级班06;
/**
 * 给定一个字符串类型的数组strs，找到一种拼接方式，
 * 使得把所有字符串拼起来之后形成的字符串具有最低的字典序
 */
import java.util.Arrays;
import java.util.Comparator;

public class Code_46_LowestLexicography {
    /**
     * 比较器
     * 负数：前面的小
     * 正数：后面的小
     */
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            // String类的compareTo()：按字典顺序比较两个字符串，前小后大返回负数
            return (a + b).compareTo(b + a);
       }
    }

    /**
     * 将按字典排好序的字符串数组拼接起来
     * @param strs
     * @return
     */
    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 根据指定比较器产生的顺序对指定对象数组的指定范围进行排序
        Arrays.sort(strs, new MyComparator());
        // 将按字典排好序的字符串数组拼接起来
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
