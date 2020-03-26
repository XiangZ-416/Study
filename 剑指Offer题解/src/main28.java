import java.util.*;

/**
 * @Description: //TODO ����һ���ַ���, ���ֵ����ӡ�����ַ������ַ����������С�
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
     *       2.�����ǹ̶���һ���ַ�������������ַ�������
     *       3.����ֵnull
     **/
    public static void Process(char[] Strs, int begin, int length, ArrayList<String> Ans) {
        // base case
        if (begin == length - 1){ // ��һ���ַ������������һ��Ԫ��ʱ����Ӵ˽��
            Ans.add(change(Strs));
        }else { // ��Strs������
            for (int i = begin; i < length; i++) { // �����п��ܳ����ڵ�i��λ�õ��ַ����ѵ�һ���ַ�����������ַ�������
                char help = Strs[begin];
                Strs[begin] = Strs[i];
                Strs[i] = help;
                Process(Strs, begin + 1, length, Ans); // �̶���i���ַ�������������ַ�������
                // ���ݵ�������״̬��Strs
                help = Strs[begin];
                Strs[begin] = Strs[i];
                Strs[i] = help;
            }
        }
    }
    /**
     * @Author ZX
     * @Description
     * ˼·��1��2��3��ȫ�������⣬���Կ���1��23��ȫ���У�2��13��ȫ���У�3��21��ȫ���е��ܺ͡�
     *      Ҳ�������ǿ��԰�ԭʼ�������⻮��Ϊ2���֣���һ���̶ֹ����ڶ�����Ϊʣ��Ԫ��ȫ���С�
     *      ����ֻҪ�õ�һ���ֲ��������Ľ���Ԫ�أ�Ȼ���������ǰ����ɵڶ����ֵ�ȫ�������⼴�ɡ�
     *      ��������ʣ��Ԫ�ص�ȫ���е�ʱ���ֿ��԰����滮��Ϊ2���ּ����㣬ֱ��ʣ���Ԫ�ظ���Ϊ1����ô��ǰ���һ�����С�
     *      ��ʱ���ϻ��ݼ��ɣ���ʼ���¸���������ĵ�һ���ֵ�Ԫ�أ����������µ��������⡣
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
        ans = new ArrayList<String>(new HashSet<>(ans)); // 2.ȥ��
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
//        System.out.println(Permutation2("abc").toString());
    }
}
