/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/8/31 19:56
 */
public class tongcheng3 {
    public int translateNum (int num) {
        // write code here
        String str = String.valueOf(num);
        int l1 = 0, l2 = 0, l3 = 1;
        for (int i = 0; i < str.length(); ++i) {
            l1 = l2;
            l2 = l3;
            l3 = 0;
            l3 += l2;
            if (i == 0) {
                continue;
            }
            String pre = str.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                l3 += l1;
            }
        }
        return l3;
    }
}
