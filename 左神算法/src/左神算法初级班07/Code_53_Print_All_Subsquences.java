package �����㷨������07;

public class Code_53_Print_All_Subsquences {
    /**
     * ��ӡ�ַ�������������
     * @param str �ַ���
     * @param i �±�
     * @param res ǰһ��λ�ô��������ַ���
     */
    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) { // �������ַ������һ��λ�ã����
            System.out.println(res);
            return;
        }
        // ����·��Ҫ/��Ҫ
        printAllSub(str, i + 1, res); // ��Ҫ��ǰλ���ַ�
        printAllSub(str, i + 1, res + str[i]); // Ҫ��ǰλ���ַ�
    }

    public static void main(String[] args) {
        String test = "abc";
        //printAllSubsquence(test);
        printAllSub(test.toCharArray(), 0, "");
    }
}
