public class Test {
    private static void Merge(int[] nums, int l, int mid, int r) {
        int p1 = l;
        int p2 = mid + 1;
        int[] help = new int[r - l + 1];
        int i = 0;

        while (p1 <= mid && p2 <= r) {
            help[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }
    }

    private static void Divide(int[] Nums, int l, int r) {
        // base case
        if (l == r)
            return;

        int mid = l + ((r - l) >> 1);

        Divide(Nums, l, mid);
        Divide(Nums, mid + 1, r);
        Merge(Nums, l, mid, r);
    }

    public static void mergeSort(int[] nums){
        // base case
        if (nums == null || nums.length < 2)
            return;

        Divide(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        mergeSort(nums);
        for (int temp : nums) {
            System.out.print(temp + " ");
        }
    }
}
