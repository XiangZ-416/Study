/**
 * @Description: //TODO ��ת����˳��:ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 *                                  ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 *                      ���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/1 16:25
 */
public class main45 {
    /**
     * @Author ZX
     * @Description //TODO ���η�ת��1.��һ�η�ת���������ַ�����ת
     *                              2.�ڶ��η�ת������ת����ַ����е�ÿ�����ʷ�ת
     *                              3.��' 'ƴ�ӷ�ת���ÿ������Ϊ���ؽ��ans
     * @Date 17:16 2020/4/1
     * @Param [s]
     * @return java.lang.String
     **/
    public String ReverseSentence(String s) {
        // 1.��һ�η�ת���������ַ�����ת
        String firstReverse = new StringBuilder(s).reverse().toString();
        StringBuilder ans = new StringBuilder(); // �������ս��
        StringBuilder res = new StringBuilder(); // �������ÿ������
        for (int i = 0; i < firstReverse.length(); i++) {
            if (firstReverse.charAt(i) != ' ') {
                res.append(firstReverse.charAt(i));
            } else {
                // 2.�ڶ��η�ת������ת����ַ����е�ÿ������word��ת
                String word = res.reverse().toString();
                // 3.��' 'ƴ�ӷ�ת���ÿ������Ϊ���ؽ��ans
                ans.append(word).append(' ');
                res = new StringBuilder(); // ���res��ǰ�ĵ��ʣ�����ȥ������һ������
            }
        }
        ans.append(res.reverse().toString()); // ��ӵ�һ�η�ת������һ������

        return ans.toString();
    }
}
