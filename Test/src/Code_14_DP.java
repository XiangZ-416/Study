/**
 * @Description: //TODO �ݹ�Ͷ�̬�滮
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/6/21 21:10
 */
public class Code_14_DP {

    /**
     * @Description //TODO ����num�Ľ׳�
     * @Author ZX
     * @Date 21:29 2020/6/21
     * @Param
     * @return
     **/
    public static class calculate {
        public static int process(int num) {
            if (num == 1) {
                return 1;
            }
            return num * process(num - 1);
        }
    }

    /**
     * @Description //TODO ��N�㺺ŵ��������Ƶ��ұ�
     * @Author ZX
     * @Date 21:39 2020/6/21
     * @Param
     * @return
     **/
    public static class hanNuoTa {
        public static void process(int N, String from, String to, String help) {
            if (N == 1) {
                System.out.println("move 1 from " + from + "to" + to);
            } else {
                process(N - 1, from, help, to);
                System.out.println("move " + N + " from " + from + "to" + to);
                process(N - 1, help, to, from);
            }
        }
    }

    /**
     * @Description //TODO ��ӡ���е����ַ���
     * @Author ZX
     * @Date 21:48 2020/6/21
     * @Param
     * @return
     **/
    public static class printSubString {
        public static void process(char[] str, int i, String res) {
            if (i == str.length) {
                System.out.print(res + " ");
                return;
            }
            process(str, i + 1, res); // ��Ҫ��ǰ�ַ�
            process(str, i + 1, res + str[i]); // Ҫ��ǰ�ַ�
        }
    }

    /**
     * @Description //TODO ��ӡ�ַ�����ȫ����
     * @Author ZX
     * @Date 21:57 2020/6/21
     * @Param
     * @return
     **/
    public static class printAllStrings {

    }

    /**
     * @Description //TODO ĸţ����
     * @Author ZX
     * @Date 22:04 2020/6/21
     * @Param
     * @return
     **/
    public static class NumberOfCows {

    }

    public static void main(String[] args) {
        System.out.println("����num�Ľ׳ˣ�" + calculate.process(3));
        System.out.println();

        System.out.println("��ŵ�������ƶ�����");
        hanNuoTa.process(3, "��", "��", "��");
        System.out.println();

        System.out.println("��ӡ���е����ַ���");
        String str = "abc";
        printSubString.process(str.toCharArray(), 0, "");

    }

}
