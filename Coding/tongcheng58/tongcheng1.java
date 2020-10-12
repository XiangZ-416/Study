import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/8/31 19:56
 */
public class tongcheng1 {
    public static void main(String[] args) {

    }

    /**
     * @param values string×Ö·û´®ArrayList<ArrayList<>>
     * @return string×Ö·û´®ArrayList
     */
    public ArrayList<String> findCommonString1(ArrayList<ArrayList<String>> values) {
        // write code here
        if(values == null || values.size() == 0) {
            return new ArrayList<String>();
        }
        ArrayList<HashSet<ArrayList<String>>> list = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            HashSet<ArrayList<String>> set = new HashSet<>();
            set.add(values.get(i));
            list.add(set);
        }
        ArrayList<ArrayList<String>> Values = new ArrayList<>();

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < values.get(0).size(); i++) {
            String s = values.get(0).get(i);
            for (int j = 0; j < values.size(); j++) {
                if (!values.get(j).get(i).equals(s)) {
                    break;
                }
                if (j == values.size() - 1) {
                    ans.add(s);
                }
            }
        }
        return ans;
    }

    public ArrayList<String> findCommonString2(ArrayList<ArrayList<String>> values) {
        solve(values);
        ArrayList<String> strings = new ArrayList<>();
        int num = values.size();
        HashMap<String, Integer> map = new HashMap<>();
        for (ArrayList<String> list : values) {
            for (String s : list) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            if (map.get(s) == num) {
                strings.add(s);
            }
        }
        return strings;
    }

    private void solve(ArrayList<ArrayList<String>> values) {
        for (ArrayList<String> list : values) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = list.size() - 1; j > i; j--) {
                    if (list.get(j).equals(list.get(i))) {
                        list.remove(j);
                    }
                }
            }
        }
    }
}
