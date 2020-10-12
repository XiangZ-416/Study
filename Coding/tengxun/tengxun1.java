import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/9/6 20:46
 */
public class tengxun1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long n = sc.nextLong();
        ArrayList<Long> list1 = new ArrayList<>();
        while (n > 0) {
            list1.add(sc.nextLong());
            n--;
        }

        Long m = sc.nextLong();
        if (m == 0) {
            System.out.println();
        }
        ArrayList<Long> list2 = new ArrayList<>();
        while (m > 0) {
            list2.add(sc.nextLong());
            m--;
        }

        ArrayList<Long> ans = new ArrayList<>();
        for (Long num : list1) {
            if (list2.contains(num)) {
                System.out.print(num + " ");
            }
        }
    }
}
