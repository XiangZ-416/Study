package 左神算法初级班01;
/**
 * @Author ZX
 * @Description //TODO 归并排序
 * @Date 14:49 2020/3/24
 * @Param
 * @return
 **/
public class Code_04_mergeSort {
	/**
	 * 归并分类
	 * @param arr
	 */
	public static void MergeSort (int[] arr) {
		// 如果arr只有一个元素或者arr为空，不用切分
		if (arr == null || arr.length < 2) {
			return;
		}
		// 将所给数组切分为两半
		Divide(arr, 0, arr.length - 1);
	}
	/**
	 * 切分
	 * @param arr
	 * @param L
	 * @param R
	 */
	public static void Divide(int[] arr, int L, int R) {
		// 数组不可再分，停止迭代
		if (L == R) {
			return;
		}
		
		// 计算出中间索引;等同于(L + R) / 2
		int mid = L + ((R - L) >> 1);
		// 继续切分左半部分;T(N/2)
		Divide(arr, L, mid);
		// 继续切分右半部分;T(N/2)
		Divide(arr, mid + 1, R);
		// 归并各个两半;O(N)
		merge(arr, L, mid, R);
		// T(N) = 2 T(N/2) + O(N)
	}
	/**
	 * 合并
	 * @param arr
	 * @param l
	 * @param m
	 * @param r
	 */
	public static void merge (int[] arr, int l, int m, int r) {
		// 定义两个指针
		int p1 = l;
		int p2 = m + 1;
		// 定义辅助数组
		int[] help = new int[r - l + 1];
		// 排序并存入辅助数组中
		int i = 0;
		while (p1 <= m && p2 <= r) {
			help[i++] = (arr[p1] < arr[p2]) ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) { // p1没越界
			help[i++] = arr[p1++];
		}
		while (p2 <= r) { //p2没越界
			help[i++] = arr[p2++];
		}
		// 将辅助数组元素赋值给原数组
		for (i = 0; i < help.length; i++) {
			// 一定是赋值给arr[l + i]而不是arr[i]，因为辅助数组用一次舍弃一次，i初始始终为0，而赋值给原数组应该逐次向后
			arr[l + i] = help[i]; 
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {7,5,6,4};
		MergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
