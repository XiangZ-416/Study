import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/8/20 11:30
 */
public class HW0819Ans2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        int Max = Integer.MIN_VALUE;
        while (temp-- != 0) {
            int i = sc.nextInt();
            Max = Math.max(Max, i);
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        if (!map.containsKey(0) || map.get(0) != 1) {
            System.out.println("0");
            return;
        }
        int i = 1;
        BigInteger res = new BigInteger("1");
        while (map.containsKey(i)) {
            int new_length = map.get(i);
            int old_length = map.get(i - 1) * 2;
            if (new_length > old_length) {
                System.out.println("0");
                return;
            }
            res = res.multiply(A(new_length, old_length));
            i++;
        }
        if (i != (Max +1)){
            System.out.println("0");
            return;
        }
        System.out.println(res.mod(new BigInteger("1000000007")));
    }

    private static BigInteger A(int new_length, int old_length) {
        if (new_length == old_length) {
            return new BigInteger("1");
        } else {
            return C(old_length, new_length).divide(C(old_length - new_length, 0));
        }
    }

    private static BigInteger C(int end, int start) {
        BigInteger res = BigInteger.valueOf(1);
        do {
            start++;
            res = res.multiply(BigInteger.valueOf(start));
        } while (start != end);
        return res;
    }
}
