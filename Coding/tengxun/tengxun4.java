import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/9/6 20:17
 */
public class tengxun4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            arr2[i] = arr1[i];
        }
        Arrays.sort(arr2);
        int mid = n / 2;
        for (int j = 0; j < n; j++) {
            if (arr1[j] < arr2[mid]) {
                System.out.println(arr2[mid]);
            } else {
                System.out.println(arr2[mid - 1]);
            }
        }
    }
}
