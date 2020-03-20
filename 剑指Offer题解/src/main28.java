import java.util.*;

/**
 * @Description:
 * ����һ���ַ���, ���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/18 22:18
 */
public class main28 {
    private static String change(char[] strs) { // ���ַ�������ת���ַ���
        StringBuilder stringBuilder = new StringBuilder();
        for (char value : strs) {
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }
    /**
     * @Author ZX
     * @Description
     * ʵ�ֵݹ麯��Process
     *       1.����������ַ������������ַ��������顢��ǰλ�á��ַ��������鳤��
     *       2.������ȷ�����п�����indexλ�õ��ַ������뵱ǰindexλ���ַ��������һ��������
     *       3.����ֵnull
     **/
    public static void Process(char[] Strs, int cur, int length, ArrayList<String> Ans) {
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
    /**
     * @Author ZX
     * @Description
     * ����1��
     *      1.�ݹ��ȡ�ַ�����ȫ����
     *      2.ȥ��
     *      3.���ֵ�������
     * @Date 23:31 2020/3/18
     * @Param [str]
     * @return java.util.ArrayList<java.lang.String>
     **/
    public static ArrayList<String> Permutation1(String str) {
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

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            // String���compareTo()�����ֵ�˳��Ƚ������ַ�����ǰС��󷵻ظ���
            return (s1 + s2).compareTo(s2 + s1);
        }
    }

    /**
     * @Author ZX
     * @Description
     * ����2��
     *      ���ñȽ�������ƴ�Ӻ���ַ�����������ַ����ֵ�����С��ƴ�ӷ���
     * @Date 22:19 2020/3/18
     * @Param [str]
     * @return java.util.ArrayList<java.lang.String>
     **/
    public static ArrayList<String> Permutation2(String str) {
        // base case
        if (str == null)
            return null;

        ArrayList<String> arrayList = new ArrayList<>();

        // ����ȡ���ַ����е��ַ��浽�ַ�������������
        String[] strs = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strs[i] = String.valueOf(str.charAt(i));
        }

        // ���ձȽ��������ַ�������
        Arrays.sort(strs, new MyComparator());

        // ���ź�����ַ�������ƴ������
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
