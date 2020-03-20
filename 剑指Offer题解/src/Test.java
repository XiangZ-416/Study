import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Test {
    private String change(char[] strs) { // ���ַ�������ת���ַ���
        StringBuilder stringBuilder = new StringBuilder();
        for (char value : strs) {
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }
    public void Process(char[] Strs, int cur, int length, ArrayList<String> Ans) {
        // base case
        if (cur == length - 1){ // ��ǰλ�����ַ����������һ��λ�ã���ǰλ��ֻ������һ�������ֱ����ӽ������
            Ans.add(change(Strs));
        }else { // ��Ҫ�жϵ�ǰλ�ÿ�������Щ�ַ����������ܳ��ֵ��ַ��뵱ǰλ�������������µ�����
            for (int i = cur; i < length; i++) {
                char help = Strs[cur];
                Strs[cur] = Strs[i];
                Strs[i] = help;
                Process(Strs, cur + 1, length, Ans); // ��ȥ�ж���һ��λ���Ƿ���ܳ����ڵ�ǰλ��
                // ����һ�κ���Ҫ�ٻ�����������ǰλ���ַ��ͱ���
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

        char[] strs = str.toCharArray(); // ���ַ���ת�����ַ���������
        ArrayList<String> ans = new ArrayList<>(); // ���ؽ��
        Process(strs, 0, strs.length, ans); // 1.�õ�ȫ����
        ans = new ArrayList<>(new HashSet<>(ans)); // 2.ȥ��
        Collections.sort(ans);// 3.���ֵ�������

        return ans;
     }
}
