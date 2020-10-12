import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/8/23 15:07
 */
public class qushi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int qx = sc.nextInt(); // 取餐点x坐标
//        int qy = sc.nextInt(); // 取餐点y坐标
//        int homex = sc.nextInt(); // 骑手家x坐标
//        int homey = sc.nextInt(); // 骑手家y坐标
        ArrayList<int[]> list = new ArrayList<>(); // 存放各个送餐点
        while (sc.hasNext()) {
            int[] aim = new int[2];
            aim[0] = sc.nextInt();
            aim[1] = sc.nextInt();
            list.add(aim);
        }
        if (list.size() < 7 || list.size() > 12) {
            return;
        }
        ArrayList<Integer> dis = new ArrayList<>();
        for (int i = 0; i < list.size(); i+=2) {
            int distance = ABdistance(list.get(i)[0], list.get(i)[1], list.get(i + 1)[0], list.get(i + 1)[1]);
            dis.add(distance);
        }
        int ans = 0;
        for (int i = 0; i < dis.size(); i++) {
            ans += dis.get(i);
        }
        System.out.println(ans);
    }

    private static int ABdistance(int ax, int ay, int bx, int by) {
        int x = Math.abs(ax - bx) * Math.abs(ax - bx); // (ax - bx)^2
        int y = Math.abs(ay - by) * Math.abs(ay - by); // (ay - by)^2
        return (int) Math.sqrt(x + y);
    }
}
