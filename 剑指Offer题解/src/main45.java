/**
 * @Description: //TODO 翻转单词顺序:牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 *                                  同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 *                      例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/1 16:25
 */
public class main45 {
    /**
     * @Author ZX
     * @Description //TODO 两次反转：1.第一次翻转：将整个字符串反转
     *                              2.第二次反转：将反转后的字符串中的每个单词反转
     *                              3.用' '拼接反转后的每个单词为返回结果ans
     * @Date 17:16 2020/4/1
     * @Param [s]
     * @return java.lang.String
     **/
    public String ReverseSentence(String s) {
        // 1.第一次翻转：将整个字符串反转
        String firstReverse = new StringBuilder(s).reverse().toString();
        StringBuilder ans = new StringBuilder(); // 保存最终结果
        StringBuilder res = new StringBuilder(); // 逐个保存每个单词
        for (int i = 0; i < firstReverse.length(); i++) {
            if (firstReverse.charAt(i) != ' ') {
                res.append(firstReverse.charAt(i));
            } else {
                // 2.第二次反转：将反转后的字符串中的每个单词word反转
                String word = res.reverse().toString();
                // 3.用' '拼接反转后的每个单词为返回结果ans
                ans.append(word).append(' ');
                res = new StringBuilder(); // 清空res当前的单词，继续去保存下一个单词
            }
        }
        ans.append(res.reverse().toString()); // 添加第一次反转后的最后一个单词

        return ans.toString();
    }
}
