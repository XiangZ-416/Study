/**
 * @Description: //TODO ���üӼ��˳����ӷ���дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 *                                   ʾ��
 *                                      ����: a = 1, b = 1
 *                                      ���: 2
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/2 17:08
 */
public class main49 {
    /**
     * @Author ZX
     * @Description //TODO �磺5 + 7 = 12�����Կ��� 2 + 10�������������ǽ�λ��5 + 7�� + ��ֻ���ǽ�λ��5 + 7��
     *                     �ٿ��������µ���⣺�����ǽ�λ�൱�ڣ�num1 ^ num2�����ǽ�λ�൱�ڣ�(num1 & num2) << 1
     *                          num1��101 �����ǽ�λ num1 = sum1��010
     *                                 +                          +
     *                          num2��111 ֻ���ǽ�λ num2 = sum2��1010
     *                       ѭ��
     *                          num1�� 010 �����ǽ�λ num1 = sum1��1000
     *                                  +                          +
     *                          num2��1010 ֻ���ǽ�λ num2 = sum2��0100
     *                       ѭ��ֱ��num2Ϊ0 ---> Ҳ����num1 + num2û�н�λ ---> Ҳ����sum1Ϊ����num1 + num2�Ľ��
     *                          num1��1000 �����ǽ�λ num1 = sum1��1100 ---> 12
     *                           +                          +
     *                          num2�� 100 ֻ���ǽ�λ num2 = sum2��0000
     * @Date 17:44 2020/4/2
     * @Param [num1, num2]
     * @return int
     **/
    public static int add(int num1, int num2) {
        int sum1; // �����ǽ�λ num1 + num2
        int sum2; // ֻ���ǽ�λ num1 + num2
        do {
            sum1 = num1 ^ num2;
            sum2 = (num1 & num2) << 1;
            num1 = sum1;
            num2 = sum2;
        } while (sum2 != 0); // ֱ��sum2Ϊ0 ---> û�н�λ

        return sum1;
    }

    public static void main(String[] args) {
        System.out.println(add(5, 7));
    }
}
