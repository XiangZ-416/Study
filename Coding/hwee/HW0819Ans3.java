import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/8/20 11:30
 */
public class HW0819Ans3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frame_str = sc.nextLine().trim();
        String block_str = sc.nextLine().trim();
        int[] frame = new int[frame_str.length()];
        int[] block = new int[block_str.length()];
        int length = frame_str.length();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            frame[i] = Integer.parseInt(frame_str.charAt(i) + "");
        }
        for (int i = 0; i < block_str.length(); i++) {
            block[i] = Integer.parseInt(block_str.charAt(i) + "");
        }
        int[] old_frame = Arrays.copyOf(frame, length);
        for (int i = 0; i < (length - block_str.length() + 1); i++) {
            frame = Arrays.copyOf(old_frame, length);
            for (int j = 0; j < block_str.length(); j++) {
                frame[i+j] = frame[i+j] + block[j];
            }
            Arrays.sort(frame);
            res = Math.min(res,frame[length-1]-frame[0]);
        }
        System.out.println(res);

    }
}
