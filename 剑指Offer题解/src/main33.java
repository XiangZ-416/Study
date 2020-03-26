import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: //TODO ��Ŀ���� ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/3/20 17:09
 */
public class main33 {
    public String PrintMinNumber(int [] nums) {
        // base case
        if (nums == null || nums.length == 0)
            return "";

        // ����������浽String���͵�list��
        List<String> list = new ArrayList<>();
        for (int temp : nums) {
            list.add("" + temp);
        }
        // ����������
        list.sort(new myComparator());

        // ƴ�������list�еĸ���Ԫ��
        StringBuilder ans = new StringBuilder();
        for (String str : list) {
            ans.append(str);
        }
        return ans.toString();
    }

    // ȷ��һ������M,Nƴ��ʱ��M+N < N+M ʱ��MӦ����ǰ
    // ���ֵ��ֵ����磺ȫ���� {1,2,3} �����ֵ������һ�����зֱ��� 123��132��213��231��312 �� 321����ά���ٿƣ�
    public static class myComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s1 + s2).compareTo(s2 + s1);
        }
    }
}
