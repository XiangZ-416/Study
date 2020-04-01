import java.util.ArrayList;

public class Test {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        // base case
        if (array == null || array.length < 2)
            return ans;

        int p1 = 0;
        int p2 = array.length - 1;
        while (p1 < p2) {
            if (array[p1] + array[p2] == sum) {
                ans.add(array[p1]);
                ans.add(array[p2]);
                return ans;
            } else if (array[p1] + array[p2] < sum) {
                p1++;
            } else {
                p2--;
            }
        }
        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        // base case
        if (nums == null || nums.length < 2)
            return ans;

        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < p2) {
            if (nums[p1] + nums[p2] == target) {
                ans[0] = (nums[p1]);
                ans[1] = (nums[p2]);
                return ans;
            } else if (nums[p1] + nums[p2] < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        System.out.println(FindNumbersWithSum(nums, 21));
    }
}
