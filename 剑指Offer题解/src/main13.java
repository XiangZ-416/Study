/**
 *
 */
public class main13 {
    /**
     * ����1��ֱ�ӵ��ÿ⺯��
     * ʱ�临�Ӷȣ�O(1)
     * @param base
     * @param exponent
     * @return
     */
    public static double Power1(double base, int exponent) {
        // base case
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }

        return Math.pow(base, exponent);
    }

    /**
     * ����2���Լ�ʵ��Math.pow()
     * ע���ָ��������
     * ʱ�临�Ӷȣ�O(exponent)
     * @param base
     * @param exponent
     * @return
     */
    public static double Power2(double base, int exponent) {
        // base case
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }

        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent > 0) {
            return result;
        }else {
            return 1 / result;
        }
    }

    /**
     * ����3��������ݹ�
     * ʱ�临�Ӷȣ�O(exponent)
     * @param base
     * @param exponent
     * @return
     */
    public static double Power3(double base, int exponent) {
        // base case
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }

        // ������ݹ�
        if (exponent > 0) {
            return base * Power3(base, exponent - 1);
        }else {
            return 1 / (base * Power3(base, Math.abs(exponent) - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println("����1��"+Power1(0.2, 2));
        System.out.println("����1��"+Power1(2, -3));
        System.out.println("����1��"+Power1(2, 2));
        System.out.println("-----------");
        System.out.println("����2��"+Power2(0.2, 2));
        System.out.println("����2��"+Power2(2, -3));
        System.out.println("����2��"+Power2(2, 2));
        System.out.println("-----------");
        System.out.println("����3��"+Power3(0.2, 2));
        System.out.println("����3��"+Power3(2, -3));
        System.out.println("����3��"+Power3(2, 2));
    }
}
