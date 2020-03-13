package 左神算法初级班01;

public class Code_05_SmallSum {
	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static int mergeSort(int[] arr, int L, int R) {
		if (L == R) {
			return 0;
		}
		int mid = L + ((R - L) >> 1); // 等同于 mid = l + (r - l) / 2
		//左边小和 + 右边小和 + 左右合并时的小和
		return mergeSort(arr, L, mid) + mergeSort(arr, mid + 1, R) + merge(arr, L, mid, R);
	}

	public static int merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		int res = 0;
		while (p1 <= m && p2 <= r) {
			// 如果arr[p1]<arr[p2]
			// 小和+ = p2(包括p2)到r(包括r)元素的个数 * arr[p1]
			// 否则 小和+ = 0
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
			// 将元素全部存入辅助数组
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 5};
		System.out.println(smallSum(arr));
	}
}
