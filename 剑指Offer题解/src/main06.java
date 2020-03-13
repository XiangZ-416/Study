public class main06 {
    /**
     * 方法1：暴力法：遍历数组找最小值
     * 时间复杂度：O(N)
     * @param array
     * @return
     */
    public static int minNumberInRotateArray1(int[] array) {
        // 若数组大小为0，返回0
        if (array == null) {
            return 0;
        }
        int min = Findmin(array);
        return min;
//        int ans = array[0];
//        for (int i = 1; i < array.length; i++){
//            ans = Math.min(ans, array[i]);
//        }
//        return ans;
    }

    public static int Findmin(int[] arr) {
        int Min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < Min) {
                Min = arr[i];
            }
        }
        return Min;
    }

    /**
     * 方法2：在旋转数组中寻找原数组的第一个元素
     * 时间复杂度：O(logN)
     * @param array
     * @return
     */
    public static int minNumberInRotateArray2(int [] array) {
        if (array == null) {
            return 0;
        }

        int l = 0;
        int r = array.length - 1;
        while (l < r - 1) {
            int mid = (l + r) >> 1;
            if (array[l] <= array[mid]) { // mid在array的左子非递减数组中
                l = mid;
            }else if (array[l] >= array[mid]) { // mid在array的右子非递减数组中
                r = mid;
            }
        }
        return array[r];
    }

    public static void main(String[] args) {
        int[] arr1 = {2,2,2,0,1};
        System.out.println("方法1：" + minNumberInRotateArray1(arr1));
        int[] arr = null;
        System.out.println("方法1：" + minNumberInRotateArray1(arr));
        System.out.println("--------------");
        System.out.println("方法2：" + minNumberInRotateArray2(arr));

    }
}
