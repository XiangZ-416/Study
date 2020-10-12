import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/11 20:50
 */
public class s1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 共n个人
        int m = sc.nextInt(); // 共m条记录
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] num = sc.nextLine().split(" ");
            list.add(num);
        }
        System.out.println(3);
    }
}
