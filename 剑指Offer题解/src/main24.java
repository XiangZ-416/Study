import java.util.ArrayList;
/**
 * ��Ŀ����
 * ����һ���������飬�жϸ������ǲ���ĳ���������������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * ˼·���ݹ�
 * 1.����
 *  �����ֳ����ڸ��Ĳ���large��С�ڸ��Ĳ���small��
 * 2.�ж�
 *  ����������������ĺ��������ÿһ�����ж�Ҫ����
 * ��1��large��small���ұ�
 * ��2��large��small������
 */
public class main24 {
    public static boolean solve(ArrayList<Integer> list) {
        if (list.size() == 0 || list.size() == 1) // ����������������Ԫ�� || ������Ҷ�ӽڵ�
            return true;

        ArrayList<Integer> small = new ArrayList<>(); // ���С�ڸ��ڵ㲿��
        ArrayList<Integer> large = new ArrayList<>(); // ��Ŵ��ڸ��ڵ㲿��
        int root = list.get(list.size() - 1); // ���ڵ�
        int firstSmallIndex = -1;
        int firstLargeIndex = -1;

        // 1.����
        // ��list��Ԫ�ط�Ϊ�����֣�С�ڸ��ڵ㡢���ڸ��ڵ�
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < root) {
                if (firstSmallIndex == -1) { // ȷ����һ��С�ڸ��ڵ�ֵ��Ԫ��
                    firstSmallIndex = i;
                }
                small.add(list.get(i));
            }else if (list.get(i) > root){
                if (firstLargeIndex == -1) { // ȷ����һ�����ڸ��ڵ��Ԫ��
                    firstLargeIndex = i;
                }
                large.add(list.get(i));
            }
        }

        // 2.�ж�
        // ���ں�С�ڲ��ֶ���Ϊ��
        if (firstSmallIndex != -1 && firstLargeIndex != -1) {
            // �ж�С�ڲ����Ƿ��ڴ��ڲ��ֵ����
            if (firstSmallIndex > firstLargeIndex) {
                return false;
            }
            // �жϴ��ڲ����Ƿ�����
            for (int i = firstLargeIndex; i < list.size(); i++) {
                if (list.get(i) < root) {
                    return false;
                }
            }
        }

        return solve(small) && solve(large); // ÿһ�������ж���Ҫ����
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        // base case
        if (sequence.length == 0)
            return false;

        // �ŵ�ArrayList�кò���
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < sequence.length; i++) {
            arrayList.add(sequence[i]);
        }

        return solve(arrayList);
    }

    public static void main(String[] args) {
        int[] sequence = {4, 6, 7, 5};
        System.out.println(VerifySquenceOfBST(sequence));
    }
}