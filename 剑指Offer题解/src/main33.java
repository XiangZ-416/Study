import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: //TODO 题目描述 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/3/20 17:09
 */
public class main33 {
    public String PrintMinNumber(int [] nums) {
        // base case
        if (nums == null || nums.length == 0)
            return "";

        // 将整型数组存到String类型的list中
        List<String> list = new ArrayList<>();
        for (int temp : nums) {
            list.add("" + temp);
        }
        // 按规则排序
        list.sort(new myComparator());

        // 拼接排序后list中的各个元素
        StringBuilder ans = new StringBuilder();
        for (String str : list) {
            ans.append(str);
        }
        return ans.toString();
    }

    // 确定一个规则：M,N拼接时，M+N < N+M 时，M应该在前
    // 数字的字典序：如：全排列 {1,2,3} 按照字典序的下一个排列分别是 123、132、213、231、312 和 321。（维基百科）
    public static class myComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s1 + s2).compareTo(s2 + s1);
        }
    }
}
