/**
 * ��Ŀ����
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
public class main11 {
    // ����1��temp��������ж�n��ÿһλ�Ƿ�λ1
    // ȱ�㣺����ÿһ��������Ҫ��temp����32��
    public int NumberOfOne1(int n) {
        int sum = 0; // ��¼1�ĸ���
        int temp = 1; // ��temp�ж�n��ÿһλ�Ƿ�Ϊ1
        while(temp != 0) { // int�ͱ���Ϊ32λ��temp����32��֮��temp�ͻ��Ϊ0����ʱ˵��n����������
            sum = (n & temp) != 0 ? sum + 1 : sum;
            temp = temp << 1;
        }
        return sum;
    }


    // ����2��n & (n -1)������n���ұߵ�1
    public int NumberOfOne2(int n) {
        int sum = 0; // ��¼1�ĸ���
        while(n != 0) { // ˵��n��������һ��1
            sum++;
            n = n & (n - 1); // ����n - 1����n���ұߵ�1
        }
        return sum;
    }
}
