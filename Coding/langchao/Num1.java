import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/8/15 20:15
 */
public class Num1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 1, maxr = 1;

        while(sc.hasNext()) {
            int treeNum = sc.nextInt();
            int[] c = new int[treeNum];
            int[] arr = new int[treeNum];

            for(int i = 0; i < treeNum; i++) {
                c[i] = sc.nextInt();
            }

            for(int i = 0; i < treeNum; i++) {
                arr[i] = c[i];
                for(int j = i + 1; j < treeNum; j++) {
                    arr[j] = c[j];
                    if(arr[i] + 1 == arr[j]) {
                        num = num + 1;
                        arr[i] = arr[j];
                    }
                }

                if(num > maxr) {
                    maxr = num;
                }
                num = 1;
            }
            System.out.println(treeNum - maxr);
        }
    }

}
