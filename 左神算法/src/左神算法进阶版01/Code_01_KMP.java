package �����㷨�߼���01;
/**
 *����Ŀ��
 * ���������ַ���str��match�����ȷֱ�ΪN��M��ʵ��һ���㷨������ַ���str
 * �к����ִ�match���򷵻�match��str�еĿ�ʼλ�ã��������򷵻�-1��
 */
public class Code_01_KMP {
    /**
     * ������
     * @param s
     * @param m
     * @return
     */
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray(); // �ַ�����Ϊ�ַ����͵�����
        char[] ms = m.toCharArray();
        int si = 0; // ss�е�ָ��
        int mi = 0; // mi�е�ָ��
        int[] next = getNextArray(ms); // ��ȡms����Ԫ�ص��ǰ׺�����׺�ַ���ƥ��
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) { // ���ַ�����ǰλ���ַ���ͬ
                // ��ָ��һ��������
                si++;
                mi++;
            } else if (next[mi] == -1) { // mi��ms��0λ��ʱ��ss��ss[si]��ms[0]�����
                // ss��ָ��������
                si++;
            } else { // mi��ms��miλ��ʱ����0����ss��ss[si]��ms[mi]�����
                // KMP�㷨�����ƴ���
                // mi����ms[mi]���ǰ׺�����׺�ַ���ƥ�䴦
                // �����ж�ss[si+1]�Ƿ����ms[next[mi]]
                mi = next[mi];
            }
        }
        // ���miָ�뻬��������ms��Ԫ�أ����ҵ��ˣ�����ss��ƥ�䵽�ĵ�һ��λ��
        return mi == ms.length ? si - mi : -1;
    }

    /**
     * ��ȡms����Ԫ�ص��ǰ׺�����׺�ַ���ƥ��
     * @param ms
     * @return
     */
    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        // ��Ϊ�涨ms��0��1λ�õ��ǰ׺�����׺�ַ���ƥ��Ϊ-1��0
        next[0] = -1;
        next[1] = 0;
        int pos = 2; // ��ǰҪ���ǰ׺�����׺�ַ���ƥ���λ��
        int cn = 0; // ��ǰ������λ��
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) { // ��ǰ������λ�ú͵�ǰλ�õ�ǰ��һ��λ��Ԫ����ͬ
                next[pos++] = ++cn; // posλ�ô����ǰ׺�����׺�ַ���ƥ��Ϊ����λ��+1
            } else if (cn > 0) { // �������cn������ǰ��
                // ����cn�����ǰ׺�����׺�ַ���ƥ���ֵ
                cn = next[cn];
            } else { // ��������޴�����
                // ��ǰλ���ǰ׺�����׺�ַ���ƥ���ֵΪ0����������һ��λ�õ��ǰ׺�����׺�ַ���ƥ���ֵ
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str1 = "tkababcababtk";
        String str2 = "ababcababtk";
        System.out.println(getIndexOf(str1, str2));
    }
}
