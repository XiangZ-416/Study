import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Test {
    private String change(char[] strs) { // 将字符串数组转成字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (char value : strs) {
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }
    public void Process(char[] Strs, int cur, int length, ArrayList<String> Ans) {
        // base case
        if (cur == length - 1){ // 当前位置是字符串数组最后一个位置，当前位置只可能有一种情况，直接添加进结果中
            Ans.add(change(Strs));
        }else { // 需要判断当前位置可能有哪些字符，并将可能出现的字符与当前位置逐个交换组成新的排列
            for (int i = cur; i < length; i++) {
                char help = Strs[cur];
                Strs[cur] = Strs[i];
                Strs[i] = help;
                Process(Strs, cur + 1, length, Ans); // 再去判断下一个位置是否可能出现在当前位置
                // 交换一次后需要再换回来，否则当前位置字符就变了
                help = Strs[cur];
                Strs[cur] = Strs[i];
                Strs[i] = help;
            }
        }
    }
    public ArrayList<String> Permutation(String str) {
        // base case
        if (str == null)
            return null;

        char[] strs = str.toCharArray(); // 将字符串转换成字符类型数组
        ArrayList<String> ans = new ArrayList<>(); // 返回结果
        Process(strs, 0, strs.length, ans); // 1.得到全排列
        ans = new ArrayList<>(new HashSet<>(ans)); // 2.去重
        Collections.sort(ans);// 3.按字典序排序

        return ans;
     }
}
