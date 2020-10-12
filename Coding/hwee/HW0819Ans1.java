import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/20 11:30
 */
public class HW0819Ans1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // M行
        int N = sc.nextInt(); // N列
        if ( M < 10 || M > 1000 || N < 10 || N > 1000){ // 非法输入
            System.out.println("[]");
            return;
        }
        boolean[][] st = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(st[i], false);
        }
        int f = 0;
        int[] xx = {0, 1, 0, -1};
        int[] yy = {1, 0, -1, 0};
        int x = 0, y = 0;
        LinkedList<Pair> ans = new LinkedList<>();
        st[0][0] = true;
        for (int i = 2; i < (M * N); i++) {
            x = xx[f] + x;
            y = yy[f] + y;
            if ((i % 10 == 7) && (((i % 100) / 10)) % 2 == 1) {
                ans.add(new Pair(x, y));
            }
            st[x][y] = true;

            while (xx[f] + x < 0 || xx[f] + x == M || yy[f] + y < 0 || yy[f] + y == N || st[xx[f]+x][yy[f]+y]) {
                f = (++f)%4;
            }
        }
        int[][] out = new int[ans.size()][2];
        int index = 0;
        Iterator<Pair> iterator = ans.iterator();
        while (iterator.hasNext()){
            Pair temp = iterator.next();
            out[index][0] = temp.x;
            out[index][1] = temp.y;
            index++;
        }
        System.out.print(Arrays.deepToString(out).replace(" ",""));

    }

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
