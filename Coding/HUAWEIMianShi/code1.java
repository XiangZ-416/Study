import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/9/16 11:42
 */
public class code1 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) == 2) {
                    ans.add(num);
                }
            } else {
                map.put(num, 1);
            }
        }
        HashSet<Integer> set = new HashSet<>(ans);
        System.out.println(set.toString());
    }
}
