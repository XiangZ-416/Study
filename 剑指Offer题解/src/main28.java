import java.util.*;

/**
 * @Description: ����һ���ַ���, ���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/18 22:18
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
     * ʵ�ֵݹ麯��Process
     *       1.����������ַ������������ַ��������顢��ǰλ�á��ַ��������鳤��
     *       2.������ȷ�����п�����indexλ�õ��ַ������뵱ǰindexλ���ַ��������һ��������
     *       3.����ֵnull
     **/
    private static void Process(ArrayList<String> ans, char[] array, int cur, int length) {
        if (cur == length - 1) {
            String res = change(array); // ���ַ���������תΪ�ַ���
            ans.add(res);
        } else {
            // ��˵������Ҫȥȷ��indexλ�õ��ַ�
            for (int i = cur; i < length; i++) {
                // ����index��iλ���ַ�-->��ȡһ������
                char temp = array[i];
                array[i] = array[cur];
                array[cur] = temp;
                // ��ǰindexλ�õ��ַ��Ѿ�ͨ�������ҵ��ˣ���ô�͵ݹ�ȥ����һ��λ�õ��ַ�
                Process(ans, array, cur + 1, length);
                // ��ʵ����ȥΪ��������ǰ��ȥ�ݹ��ʱ��Ľ��н����ַ���Ӱ�죬
                // ����������Ļ�����ô�ͻ����ԭindexλ�õ��ַ������仯
                temp = array[i];
                array[i] = array[cur];
                array[cur] = temp;
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
        char[] Array = str.toCharArray(); // ���ַ���ת��Ϊ�ַ���������
        ArrayList<String> ans = new ArrayList<>(); // ��Ҫ���صĽ��
        Process(ans, Array, 0, str.length()); // 1.�ݹ��ȡ�ַ�����ȫ����
        ans = new ArrayList<String>(new HashSet<String>(ans)); // 2.ȥ�ز���
        Collections.sort(ans); // 3.�ֵ����� -> ans.sort(null);
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
