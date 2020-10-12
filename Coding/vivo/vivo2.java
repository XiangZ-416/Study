import java.util.ArrayList;
import java.util.List;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/9/12 20:24
 */
public class vivo2 {
    private static int solve(int[][] mg, int x, int y, int endx, int endy) {
        int[][] queue = new int[x*y][3];
        queue[0][0] = x;
        queue[0][1] = y;
        queue[0][2] = -1;
        int front = 0;
        int rear = 1;
        OUT:
        while(front!=rear) {
            mg[queue[front][0]][queue[front][1]] = 1;
            for (int i = queue[front][0]-1; i <= queue[front][0]+1; i++) {
                for (int j = queue[front][1]-1; j <= queue[front][1]+1; j++) {
                    if(mg[i][j]==0) {//通路记录下
                        queue[rear][0] = i;
                        queue[rear][1] = j;
                        queue[rear++][2] = front;
                        mg[i][j]=1;
                        if(i==endx && j==endy) {
                            break OUT;
                        }
                    }
                }
            }
            front++;
        }
        List<String> list = new ArrayList<String>();
        for (int i = rear-1; i>=0; i--) {
            list.add("("+queue[i][0]+","+queue[i][1]+")");
            i = queue[i][2]+1;
        }
        for (int i = list.size()-1; i>0; i--) {
            System.out.print(list.get(i)+"-->");
        }
        return Integer.parseInt(list.get(0));
    }
    public static void main(String[] args) {
        int[][] nums = {{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                                 {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                                 {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                                 {0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                               {0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                 {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                                {0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                               {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}};
        System.out.println(solve(nums, 0, 0, nums.length - 1, nums[0].length - 1));

    }
}
