import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/8/25 19:38
 */
public class shenxinfu1 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt(); // n¿ÃÊ÷
        ArrayList<Integer> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(sc.nextInt());
        }
        if (tree.get(0) == tree.get(tree.size() - 1)) {
            System.out.println(0);
        }
        int ans = solve(tree, 0);
        System.out.println(ans);
    }

    private static int solve(ArrayList<Integer> tree, int ans) {
        if (tree.get(0) == tree.get(tree.size() - 1)) {
            return ans + 1;
        }
        ans++;
        Collections.sort(tree);
        for (int i = 0; i < tree.size() - 1; i++) {
            int curTree = tree.get(i);
            tree.set(i, curTree + 1);
        }
        return solve(tree, ans);
    }
}
