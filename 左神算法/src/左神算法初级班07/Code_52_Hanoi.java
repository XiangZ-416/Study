package 左神算法初级班07;

public class Code_52_Hanoi {
    /**
     * 移动过程
     * @param N N个圆盘
     * @param Start 起点杆
     * @param End 终点杆
     * @param Help 辅助杆
     */
    public static void Move(int N, String Start, String End, String Help) {
        if (N == 1) {
            System.out.println(" Move 1 From " + Start + " to " + End  );
        }else {
            Move( N - 1, Start, Help, End); // 将剩下的N - 1个圆盘借助终点杆从起点杆移到辅助杆上
            System.out.println(" Move " +  N + " From " + Start + " to " + End);
            Move(N - 1, Help, End, Start); // 再将剩下的N - 1个圆盘借助起点杆从辅助杆移到终点杆
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Move(n, "左", "右", "中" );
    }
}