import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/9/6 21:27
 */
public class tengxun2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < m; j++) {
            int t = sc.nextInt();
            ArrayList<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                list1.add(sc.nextInt());
            }
            if (list1.contains(0)) {
                arr[j] = 1;
            }
            list.add(list1);
        }
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            if (arr[i] == 1) {
                flag = false;
                ArrayList<Integer> list1 = list.get(i);
                for (Integer num : list1) {
                    set.add(num);
                }
            }
        }
        if (flag) {
            System.out.println(0);
            return;
        }
        int count = 1;
        int k = 0;
        boolean f = true;
        while (true) {
            if (f) {
                k = count;
                for (int i = 0; i < list.size(); i++) {
                    if (arr[i] != 1) {
                        for (Integer num : list.get(i)) {
                            if (set.contains(num)) {
                                f = false;
                                count++;
                                arr[i] = 1;
                                for (Integer nu : list.get(i)) {
                                    set.add(nu);
                                }
                            }
                        }
                    }
                }
            } else {
                if (count < m && k != count) {
                    for (int i = 0; i < list.size(); i++) {
                        if (arr[i] != 1) {
                            for (Integer num : list.get(i)) {
                                if (set.contains(num)) {
                                    f = false;
                                    count++;
                                    arr[i] = 1;
                                    for (Integer nu : list.get(i)) {
                                        set.add(nu);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(set.size());
    }
}
