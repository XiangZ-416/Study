package �����㷨���װ�;

/**
 * @Description //TODO ���������ַ���str��match�����ȷֱ�ΪN��M��ʵ��һ���㷨������ַ���str
 *                     �к����ִ�match���򷵻�match��str�еĿ�ʼλ�ã��������򷵻�-1��
 *                     ʱ�临�Ӷ�O(N + M)
 * @Author ZX
 * @Date 14:40 2020/6/26
 * @Param
 * @return
 **/
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
        char[] sArray = s.toCharArray(); // �ַ�����Ϊ�ַ����͵�����
        char[] mArray = m.toCharArray();
        int sIndex = 0; // sArray�е�ָ��
        int mIndex = 0; // mArray�е�ָ��
        int[] next = getNextArray(mArray); // ��ȡmArray����Ԫ�ص��ǰ׺�����׺�ַ���ƥ��
        while (sIndex < sArray.length && mIndex < mArray.length) {
            if (sArray[sIndex] == mArray[mIndex]) { // ���ַ�����ǰλ���ַ���ͬ
                // ��ָ��һ��������
                sIndex++;
                mIndex++;
            } else if (next[mIndex] == -1) { // mIndex��mArray��0λ��ʱ��sArray��sArray[sIndex]��mArray[0]�����
                // sArray��ָ��������
                sIndex++;
            } else { // mIndex��mArray��mIndexλ��ʱ����0����sArray��sArray[sIndex]��mArray[mIndex]�����
                // KMP�㷨�����ƴ���
                // mIndex����mArray[mIndex]���ǰ׺�����׺�ַ���ƥ�䴦
                // �����ж�sArray[sIndex+1]�Ƿ����mArray[next[mIndex]]
                mIndex = next[mIndex];
            }
        }
        // ���mIndexָ�뻬��������mArray��Ԫ�أ����ҵ��ˣ�����sArray��ƥ�䵽�ĵ�һ��λ��
        return mIndex == mArray.length ? sIndex - mIndex : -1;
    }

    /**
     * ��ȡms����Ԫ�ص��ǰ׺�����׺�ַ���ƥ��
     * @param mArray
     * @return
     */
    public static int[] getNextArray(char[] mArray) {
        if (mArray.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[mArray.length];
        // ��Ϊ�涨ms��0��1λ�õ��ǰ׺�����׺�ַ���ƥ��Ϊ-1��0
        next[0] = -1;
        next[1] = 0;
        int cur = 2; // ��ǰҪ���ǰ׺�����׺�ַ���ƥ���λ��
        int cn = 0; // ��ǰ������λ��
        while (cur < next.length) {
            if (mArray[cur - 1] == mArray[cn]) { // ��ǰ������λ�ú͵�ǰλ�õ�ǰ��һ��λ��Ԫ����ͬ
                next[cur++] = ++cn; // curλ�ô����ǰ׺�����׺�ַ���ƥ��Ϊ����λ��+1
            } else if (cn > 0) { // �������cn������ǰ��
                // ����cn�����ǰ׺�����׺�ַ���ƥ���ֵ
                cn = next[cn];
            } else { // ��������޴�����
                // ��ǰλ���ǰ׺�����׺�ַ���ƥ���ֵΪ0����������һ��λ�õ��ǰ׺�����׺�ַ���ƥ���ֵ
                next[cur++] = 0;
            }
        }
        return next;
    }

    /**
     * @return int
     * @Description //TODO ������
     * @Author ZX
     * @Date 10:50 2020/6/24
     * @Param [str1, str2]
     **/
    public static int StringMatching(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();

        int i = 0;
        int j = 0;

        // ƥ�����
        while (i < str1Len && j < str2Len) {
            if (str1Array[i] == str2Array[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == str2Len) { // ƥ��ɹ�
            return i - j;
        }
        return -1; // ƥ��ʧ��
    }

    public static void main(String[] args) {
        String str1 = "tkababcababtk";
        String str2 = "ababcababtk";
        System.out.println(getIndexOf(str1, str2));
        System.out.println(StringMatching(str1, str2));
    }
}
