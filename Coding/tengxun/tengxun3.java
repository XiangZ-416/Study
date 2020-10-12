import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/9/6 21:02
 */
public class tengxun3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] str2 = str1.split(" ");
        int n1 = Integer.parseInt(str2[0]);
        int n2 = Integer.parseInt(str2[1]);
        String[] arrs = new String[n1];
        PriorityQueue<String> pq = new PriorityQueue<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            String str = sc.nextLine();
            int num = hashMap.getOrDefault(str,0) + 1;
            hashMap.put(str, num);
        }
        Comparator<String> minC = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hashMap.get(o1) < hashMap.get(o2)) return -1;
                else if (hashMap.get(o1) > hashMap.get(o2)) return 1;
                else {
                    int l0 = 0, l1 = 0;
                    while (l0 < o1.length() && l1 < o2.length()) {
                        if (o1.charAt(l0) < o2.charAt(l1)) {
                            return -1;
                        } else if (o1.charAt(l0) > o2.charAt(l1)) {
                            return 1;
                        } else {
                            l0++;
                            l1++;
                        }
                    }
                    return o1.length() - o2.length();
                }
            }
        };
        Comparator<String> maxC = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hashMap.get(o1) < hashMap.get(o2)) return 1;
                else if (hashMap.get(o1) > hashMap.get(o2)) return -1;
                else {
                    int l0 = 0, l1 = 0;
                    while (l0 < o1.length() && l1 < o2.length()) {
                        if (o1.charAt(l0) < o2.charAt(l1)) {
                            return -1;
                        } else if (o1.charAt(l0) > o2.charAt(l1)) {
                            return 1;
                        } else {
                            l0++;
                            l1++;
                        }
                    }
                    return o1.length() - o2.length();
                }
            }
        };
        PriorityQueue<String> min = new PriorityQueue<>(minC);
        PriorityQueue<String> max = new PriorityQueue<>(maxC);
        for (String s : hashMap.keySet()) {
            min.offer(s);
            max.offer(s);
        }
        for (int i = 0; i < n2; i++) {
            String str = max.poll();
            System.out.println(str + " " + hashMap.get(str));
        }
        for (int i = 0; i < n2; i++) {
            String str = min.poll();
            System.out.println(str + " " + hashMap.get(str));
        }
    }
}
