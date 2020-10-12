/**
 * @Description //TODO ��ȡ�ַ���������Ӵ�
 * @Author ZX
 * @Date 15:41 2020/6/27
 **/
public class Code_16_Manacher {

    /**
     * @Description //TODO ������
     * @Author ZX
     * @Date 15:40 2020/6/27
     **/
    public static class getLPSubstr {
        public static String getLPSub(String str) {
            char[] strArray = str.toCharArray();
            // base case
            if (strArray == null || strArray.length < 2) {
                return str;
            }
            int start = 0, end = 0; // ������Ӵ�����㡢�յ�
            for (int i = 0; i < strArray.length; i++) {
                int evenLength = getProcess(strArray, i, i); // �ո�Ϊ�����е�
                int oddLength = getProcess(strArray, i, i + 1); // �ַ�Ϊ�����е�
                int length = Math.max(evenLength, oddLength); // iλ�������ĳ���
                // ����i��lengthȷ����ǰ������Ӵ�����㡢�յ�
                if (length > end - start) { // i + 1λ�õ�������Ӵ����� > iλ�õ�ʱ��start��end����
                    start = i - (length - 1) / 2;
                    end = i + length / 2;
                }
            }
            return str.substring(start, end + 1);
        }

        // ��ȡÿ��λ�õ�������Ӵ��ĳ���
        private static int getProcess(char[] strArray, int L, int R) {
            while (L >= 0 && R < strArray.length && strArray[L] == strArray[R]) {
                L--;
                R++;
            }
            return R - L - 1;
        }
    }

    /**
     * @Description //TODO manacher
     * @Author ZX
     * @Date 15:40 2020/6/27
     **/
    public static class manacher {

        // ����ԭ�ַ���
        public static char[] produceNewStr(String str) {
            char[] strArray = str.toCharArray();
            char[] newArray = new char[strArray.length * 2 + 1];
            int index = 0;
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = (i & 1) == 0 ? '#' : strArray[index++];
            }
            return newArray;
        }

        public static int manacher(String str) {
            // base case
            if (str == null || str.length() < 1) {
                return 0;
            }
            char[] newStrArray = produceNewStr(str); // ��������ַ�������
            int[] Parr = new int[newStrArray.length]; // ���İ뾶����
            int Pcenter = -1; // ��������
            int Pr = -1; // �����ұ߽�
            int max = Integer.MIN_VALUE; // ��ʼ���������Ӵ�����
            for (int i = 0; i < newStrArray.length; i++) {
                Parr[i] = Pr > i ? Math.min(Parr[2 * Pcenter - i], Pr - i) : 1;
                while (i + Parr[i] < newStrArray.length && i - Parr[i] > -1) {
                    if (newStrArray[i + Parr[i]] == newStrArray[i - Parr[i]]) {
                        Parr[i]++;
                    } else {
                        break;
                    }
                }
                if (i + Parr[i] > Pr) {
                    Pr = i + Parr[i];
                    Pcenter = i;
                }
                max = Math.max(max, Parr[i]);
            }
            return max - 1;
        }
    }

    public static void main(String[] args) {
        String str = "abc1234321ab";
        System.out.println("�����ⷨ��" + getLPSubstr.getLPSub(str));
        System.out.println("Manacher��" + manacher.manacher(str));
    }

}
