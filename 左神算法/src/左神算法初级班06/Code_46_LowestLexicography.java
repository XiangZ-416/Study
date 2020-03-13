package �����㷨������06;
/**
 * ����һ���ַ������͵�����strs���ҵ�һ��ƴ�ӷ�ʽ��
 * ʹ�ð������ַ���ƴ����֮���γɵ��ַ���������͵��ֵ���
 */
import java.util.Arrays;
import java.util.Comparator;

public class Code_46_LowestLexicography {
    /**
     * �Ƚ���
     * ������ǰ���С
     * �����������С
     */
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            // String���compareTo()�����ֵ�˳��Ƚ������ַ�����ǰС��󷵻ظ���
            return (a + b).compareTo(b + a);
       }
    }

    /**
     * �����ֵ��ź�����ַ�������ƴ������
     * @param strs
     * @return
     */
    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // ����ָ���Ƚ���������˳���ָ�����������ָ����Χ��������
        Arrays.sort(strs, new MyComparator());
        // �����ֵ��ź�����ַ�������ƴ������
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
